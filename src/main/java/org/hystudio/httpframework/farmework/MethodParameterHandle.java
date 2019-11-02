package org.hystudio.httpframework.farmework;

import org.hystudio.httpframework.HTTPSession;
import org.hystudio.httpframework.annonations.*;
import org.hystudio.httpframework.utils.ClassUtil;
import org.hystudio.httpframework.utils.StringUtil;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MethodParameterHandle implements IHandle {
    private final HTTPSession httpSession;
    private final Object[] objects;
    private final Method method;
    private final MethodParameterPackage methodParameterPackage;
    private final MethodParameterBean methodParameterBean;

    MethodParameterHandle(HTTPSession httpSession) {
        this.httpSession = httpSession;
        this.objects = this.httpSession.getObjects();
        this.method = this.httpSession.getMethod();
        this.methodParameterPackage = new MethodParameterPackage();
        this.methodParameterBean = this.methodParameterPackage.getMethodParameterBean();
    }


    @Override
    public void handle() {
        this.handleOfMethodParameterBean();
        this.handleOfMethodParameterPackage();
        this.setMethodParameterToHTTPSession();
    }

    private void handleOfMethodParameterBean() {
        this.methodParameterBean.setObjectsNumb(this.objects.length);
        int index = 0;
        Annotation[][] methodParameterAnnotations = this.method.getParameterAnnotations();
        for (Annotation[] parameterAnnotations : methodParameterAnnotations
        ) {
            if (parameterAnnotations.length > 0) {
                Annotation parameterAnnotation = parameterAnnotations[0];
                Class annotationType = parameterAnnotation.annotationType();
                if (annotationType == RequestData.class) {
                    this.methodParameterBean.addRequestData(this.objects[index]);
                } else if (annotationType == RequestHeader.class) {
                    this.methodParameterBean.addRequestHeader(this.objects[index]);
                } else if (annotationType == RequestResolver.class) {
                    this.methodParameterBean.addRequestResolver((IRequestDataResolver) this.objects[index]);
                } else if (annotationType == ResponseResolver.class) {
                    this.methodParameterBean.addResponseResolver(this.objects[index]);
                }
            }
            index++;
        }
    }

    private void handleOfMethodParameterPackage() {
        this.r(this.methodParameterBean.getRequestDataObjectList(), 0);
        this.r(this.methodParameterBean.getRequestHeaderObjectList(), 1);
    }

    private void r(List<Object> objectList, int type) {
        for (Object o : objectList
        ) {
            if (o instanceof Map) {
                ((Map) o).forEach((k, v) -> {
                    if (type == 0) {
                        this.methodParameterPackage.addDataKey(StringUtil.toString(k), null, o);
                    }
                    if (type == 1) {
                        this.methodParameterPackage.addHeaderKey(StringUtil.toString(k), null, o);
                    }
                });
            } else {
                Field[] fields = o.getClass().getDeclaredFields();
                HashMap<String, Method> methodMap = ClassUtil.getMethodMap(o);
                for (Field field : fields
                ) {
                    if (!field.isAnnotationPresent(Excpet.class)) {
                        String keyName;
                        String fieldName = field.getName();
                        if (field.isAnnotationPresent(Name.class)) {
                            keyName = field.getAnnotation(Name.class).name();
                        } else {
                            keyName = field.getName();
                        }
                        Method method = methodMap.get("get" + StringUtil.upperFirstWord(fieldName));
                        if (method != null) {
                            if (type == 0) {
                                this.methodParameterPackage.addDataKey(keyName, method, o);
                            }
                            if (type == 1) {
                                this.methodParameterPackage.addHeaderKey(keyName, method, o);
                            }
                        }
                    }
                }
            }
        }
    }

    private void setMethodParameterToHTTPSession() {
        this.httpSession.setMethodParameterBean(this.methodParameterBean);
        this.httpSession.setMethodParameterPackage(this.methodParameterPackage);
    }
}
