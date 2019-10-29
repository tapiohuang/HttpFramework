package org.hystudio.httpframework;

public class RequestSessionExecutor implements
        IRequestResolvableSession {
    private RequestSession requestSession;

    private RequestSessionExecutor(RequestSession requestSession) {
        this.requestSession = requestSession;
    }

    public static Object execute(RequestSession requestSession) {
        RequestSessionExecutor requestSessionExecutor = new RequestSessionExecutor(requestSession);
        requestSessionExecutor.executeRequestDataResolver();
        requestSessionExecutor.executeResponseDataResolver();
        return null;
    }

    @Override
    public void executeRequestDataResolver() {
        this.requestSession.executeRequestDataResolver();

    }

    @Override
    public void executeResponseDataResolver() {
        this.requestSession.executeResponseDataResolver();
    }
}
