package org.hystudio.httpframework.framework2.executor;

import org.hystudio.httpframework.framework2.data.RequestData;
import org.hystudio.httpframework.framework2.processor.request.handle.RequestProcessorsHandle;
import org.hystudio.httpframework.framework2.session.HttpSession;

public class HttpSessionExecutor implements Runnable {
    private HttpSession httpSession;

    public HttpSessionExecutor(HttpSession httpSession) {
        this.httpSession = httpSession;
        this.processRequestData();
    }

    private void processRequestData() {
        RequestProcessorsHandle requestProcessorsHandle = httpSession.getRequestProcessorHandle();
        requestProcessorsHandle.process();
        RequestData requestData = requestProcessorsHandle.getRequestData();
    }

    @Override
    public void run() {

    }
}
