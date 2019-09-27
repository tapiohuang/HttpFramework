package org.hystudio.httpframework.framework2.executor;


import org.hystudio.httpframework.framework2.data.RequestData;
import org.hystudio.httpframework.framework2.processors2.RequestProcessorsHandle;
import org.hystudio.httpframework.framework2.processors2.ResponseProcessorsHandle;
import org.hystudio.httpframework.framework2.reader.IReader;
import org.hystudio.httpframework.framework2.sender.ISender;
import org.hystudio.httpframework.framework2.session.HttpSession;
import org.hystudio.httpframework.utils.LogUtils;

public class HttpSessionExecutor implements Runnable {
    private HttpSession httpSession;

    public HttpSessionExecutor(HttpSession httpSession) {
        this.httpSession = httpSession;
        this.processRequestData();
        this.processResponseData();
    }

    private void processRequestData() {
        System.out.println("RequestData处理开始");
        RequestProcessorsHandle requestProcessorsHandle = httpSession.getRequestProcessorHandle();
        requestProcessorsHandle.process();
        RequestData requestData = requestProcessorsHandle.getRequestData();
        System.out.println("RequestData处理完成");
        LogUtils.info("DataBody", requestData.getHeader().toString());
    }

    private void processResponseData() {
        System.out.println("ResponseData处理开始");
        ResponseProcessorsHandle responseProcessorsHandle = httpSession.getResponseProcessorHandle();
        System.out.println(responseProcessorsHandle);
        responseProcessorsHandle.process();
        Object o = responseProcessorsHandle.getFinalResult();
        System.out.println("ResponseData处理完成");
        LogUtils.info("处理结果", o.toString());
    }

    @Override
    public void run() {
        ISender sender = httpSession.getSender();
        IReader reader = httpSession.getReader();
        sender.send();
        reader.read();
    }
}
