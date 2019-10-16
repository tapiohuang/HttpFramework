package org.hystudio.httpframework.framework2.sender;

import org.hystudio.httpframework.framework2.session.HttpSession;
import org.hystudio.httpframework.utils.LogUtils;

public class GetSender extends AbstractSender {

    public GetSender(HttpSession httpSession) {
        super(httpSession);
    }

    @Override
    public void send() {
        LogUtils.info("proxy", "");
    }

    private void prepareConnection() {

    }
}
