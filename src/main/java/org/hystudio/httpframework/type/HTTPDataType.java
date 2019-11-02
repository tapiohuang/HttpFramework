package org.hystudio.httpframework.type;

public enum HTTPDataType {
    XML("text/xml"), HTML("text/html"), SCRIPT("SCRIPT"), JSON("application/json"), FORM("application/x-www-form-urlencoded"),
    TEXT("TEXT");

    private final String dataType;

    HTTPDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDataType() {
        return dataType;
    }
}
