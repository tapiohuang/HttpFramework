package org.hystudio.httpframework.farmework;

import org.hystudio.httpframework.HTTPSession;

public final class HTTPPreprocessor implements IProcessor {
    private final MethodParameterHandle methodParameterHandle;
    private final RequestDataHandle requestDataHandle;
    private final RequestMethodHandle requestMethodHandle;
    private HTTPSession httpSession;

    HTTPPreprocessor(HTTPSession httpSession) {
        this.httpSession = httpSession;
        this.methodParameterHandle = new MethodParameterHandle(this.httpSession);
        this.requestDataHandle = new RequestDataHandle(this.httpSession);
        requestMethodHandle = new RequestMethodHandle(this.httpSession);
    }

    @Override
    public void process() {
        /*
        1.将objects,method预处理MethodParameterHandle生成MethodParameterBean注入到HTTPSession
         */
        this.methodParameterHandle.handle();
        /*
        2.读取接口方法上的注解信息
         */
        this.requestMethodHandle.handle();
        /*
        3.使用RequestDataHandle生成RequestData
         */
        this.requestDataHandle.handle();
    }
}
