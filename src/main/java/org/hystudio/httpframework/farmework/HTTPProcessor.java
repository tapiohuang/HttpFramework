package org.hystudio.httpframework.farmework;

import org.hystudio.httpframework.HTTPSession;

public class HTTPProcessor implements IProcessor {
    private HTTPSession httpSession;

    HTTPProcessor(HTTPSession httpSession) {
        this.httpSession = httpSession;
    }

    @Override
    public void process() {

    }
}
