package org.hystudio.httpframework.framework.config;

public enum ResponseDataType {
    XML("text/xml"), HTML("text/html"), SCRIPT("SCRIPT"), JSON("application/json"), FORM("application/x-www-form-urlencoded"),
    TEXT("TEXT");

    private final String dataType;

    ResponseDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDataType() {
        return dataType;
    }
}
