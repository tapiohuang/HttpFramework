package org.hystudio.httpframework.farmework;

import org.hystudio.httpframework.HTTPSession;

public class HTTPPostProcessor implements IProcessor {
    private HTTPSession httpSession;

     HTTPPostProcessor(HTTPSession httpSession) {
        this.httpSession = httpSession;
    }

    @Override
    public void process() {

    }
}
