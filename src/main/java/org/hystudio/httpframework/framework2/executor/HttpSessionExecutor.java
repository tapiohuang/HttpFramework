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
    private ISender sender;
    private IReader reader;

    public HttpSessionExecutor(HttpSession httpSession) {
        this.httpSession = httpSession;
        this.sender = httpSession.getSender();
        this.reader = httpSession.getReader();
    }

    private void processRequestData() {
        System.out.println("RequestData处理开始");
        RequestProcessorsHandle requestProcessorsHandle = httpSession.getRequestProcessorHandle();
        LogUtils.info("Header", requestProcessorsHandle.toString());
        requestProcessorsHandle.process();
        RequestData requestData = requestProcessorsHandle.getRequestData();
        System.out.println("RequestData处理完成");
        LogUtils.info("Header", requestData.getHeader().toString());
        LogUtils.info("DataBody", requestData.getDataBody().toString());
    }

    private void processResponseData() {
        System.out.println("ResponseData处理开始");
        ResponseProcessorsHandle responseProcessorsHandle = httpSession.getResponseProcessorHandle();
        System.out.println(responseProcessorsHandle);
        responseProcessorsHandle.process();
        Object o = responseProcessorsHandle.getFinalResult();
        System.out.println("ResponseData处理完成");
        //LogUtils.info("处理结果", o.toString());
    }

    @Override
    public void run() {
        this.processRequestData();
        sender.send();
        reader.read();
        this.processResponseData();
    }
}
