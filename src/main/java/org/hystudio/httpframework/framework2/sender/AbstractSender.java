package org.hystudio.httpframework.framework2.sender;

import org.hystudio.httpframework.framework2.session.HttpSession;

import java.io.IOException;

public abstract class AbstractSender implements ISender {
    protected HttpSession httpSession;

    public AbstractSender(HttpSession httpSession) {
        this.httpSession = httpSession;
    }

    public AbstractSender() {
    }

    protected void openConnection() throws IOException {
        this.httpSession.getHttpSessionConnection().openConnection();
    }

    @Override
    public abstract void send();
}
