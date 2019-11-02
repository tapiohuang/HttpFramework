package org.hystudio.httpframework.farmework;

import org.hystudio.httpframework.HTTPSession;
import org.hystudio.httpframework.annonations.HTTPRequestMethod;
import org.hystudio.httpframework.type.HTTPContentType;
import org.hystudio.httpframework.type.HTTPDataType;
import org.hystudio.httpframework.type.HTTPRequestMethodType;

import java.lang.reflect.Method;

public class RequestMethodHandle implements IHandle {
    private final HTTPSession httpSession;

    RequestMethodHandle(HTTPSession httpSession) {
        this.httpSession = httpSession;
    }

    @Override
    public void handle() {
        Method method = httpSession.getMethod();
        HTTPRequestMethod httpRequestMethod = method.getAnnotation(HTTPRequestMethod.class);
        if (httpRequestMethod != null) {
            HTTPRequestMethodType httpRequestMethodType = httpRequestMethod.methodType();
            HTTPDataType httpDataType = httpRequestMethod.dataType();
            HTTPContentType httpContentType = httpRequestMethod.contentType();
            String url = httpRequestMethod.url();
            this.httpSession.setHttpContentType(httpContentType);
            this.httpSession.setHttpRequestMethodType(httpRequestMethodType);
            this.httpSession.setHttpDataType(httpDataType);
            this.httpSession.setUrl(url);
        }
    }
}
