package org.hystudio.httpframework.framework2.sender;

import org.hystudio.httpframework.framework2.session.HttpSession;

public class AbstractSender implements ISender {
    protected HttpSession httpSession;

    public AbstractSender(HttpSession httpSession) {
        this.httpSession = httpSession;
    }

    public AbstractSender() {
    }

    @Override
    public void send() {

    }
}
