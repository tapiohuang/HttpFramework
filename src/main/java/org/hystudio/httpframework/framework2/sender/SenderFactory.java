package org.hystudio.httpframework.framework2.sender;


import org.hystudio.httpframework.framework2.session.HttpSession;

public final class SenderFactory implements ISenderFactory {
    public SenderFactory() {
    }

    @Override
    public ISender createSender(HttpSession httpSession) {
        switch (httpSession.getRequestMethod()) {
            case GET:
                return new GetSender(httpSession);
            case PUT:
                return new PutSender(httpSession);
            case POST:
                return new PostSender(httpSession);
            case HEAD:
                return null;
            case DELETE:
                return null;
            case OPTIONS:
                return null;
        }
        return null;
    }

}
