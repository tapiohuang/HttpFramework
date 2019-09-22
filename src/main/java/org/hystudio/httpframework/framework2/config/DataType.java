package org.hystudio.httpframework.framework2.config;

public enum DataType {
    XML("text/xml"), HTML("text/html"), SCRIPT("SCRIPT"), JSON("application/json"), FORM("application/x-www-form-urlencoded"),
    TEXT("TEXT");

    private final String dataType;

    DataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDataType() {
        return dataType;
    }
}
