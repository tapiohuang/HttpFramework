package org.hystudio.httpframework.farmework;

import org.hystudio.httpframework.HTTPSession;

import java.lang.reflect.Method;

public final class HTTPFramework {
    private HTTPPreprocessor httpPreprocessor;
    private HTTPProcessor httpProcessor;
    private HTTPPostProcessor httpPostProcessor;
    private HTTPSession httpSession;

    /**
     * 框架初始化
     *
     * @param objects 参数
     * @param method  被调用的方法
     */
    public void initialize(Object[] objects, Method method) {
        this.httpSession = new HTTPSession(objects, method);
        this.httpProcessor = new HTTPProcessor(httpSession);
        this.httpPreprocessor = new HTTPPreprocessor(httpSession);
        this.httpPostProcessor = new HTTPPostProcessor(httpSession);
    }

    public void run() {
        /*
        1.前置处理器：生成RequestData
         */
        httpPreprocessor.process();

        /*
        2.中处理器：手发HTTP请求
         */
        httpProcessor.process();

        /*
        3.后置处理器：处理ResponseData,封装成指定Bean
         */
        httpPostProcessor.process();
    }

    /**
     * 获取HTTP请求的结果
     *
     * @return Object 返回封装的结果对象
     */
    public Object getHTTPResult() {
        return this.httpSession.getResultObject();
    }
}
