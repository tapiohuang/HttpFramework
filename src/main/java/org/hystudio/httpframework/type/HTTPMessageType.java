package org.hystudio.httpframework.type;

public enum HTTPMessageType {
    _Unknown_Status(-1, "Unknown_Status"),
    _200(200, "OK"),
    _302(302, "Found"),
    _304(304, "Not Modified"),
    _400(400, "Bad Request"),
    _403(403, "Forbidden"),
    _500(500, "Internal Server Error"),
    _503(503, "Server Unavailable"),
    _404(404, "Not Found");


    private final String message;
    private final int statusCode;

    HTTPMessageType(int statusCode, String message) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public static HTTPMessageType getHttpMessage(int statusCode) {
        HTTPMessageType[] httpMessages = HTTPMessageType.values();
        for (HTTPMessageType httpMessage : httpMessages) {
            if (httpMessage.statusCode == statusCode) {
                return httpMessage;
            }
        }
        return _Unknown_Status;
    }

    public String getMethod() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
