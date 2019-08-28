package org.hystudio.httpframework.framework.config;

public enum ResponseDataType {
    XML("XML"), HTML("HTML"), SCRIPT("SCRIPT"), JSON("JSON"),
    TEXT("TEXT");

    private final String dataType;

    ResponseDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDataType() {
        return dataType;
    }
}
