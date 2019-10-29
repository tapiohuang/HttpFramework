package org.hystudio.httpframework;

public enum ContentType {
    DOC("application/msword", ".doc"),
    DOCX("application/vnd.openxmlformats-officedocument.wordprocessingml.document", ".docx"),
    RTF("application/rtf", ".rtf"),
    XLS1("application/vnd.ms-excel", ".xls"),
    XLS2("application/x-excel", ".xls"),
    XLSX("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", ".xlsx"),
    PPT("application/vnd.ms-powerpoint", ".ppt"),
    PPTX("application/vnd.openxmlformats-officedocument.presentationml.presentation", ".pptx"),
    PPS("application/vnd.ms-powerpoint", ".pps"),
    PPSX("application/vnd.openxmlformats-officedocument.presentationml.slideshow", ".ppsx"),
    PDF("application/pdf", ".pdf"),
    TAR("application/x-tar", ".tar"),
    TGZ("application/x-compressed", ".tgz"),
    ZIP("application/x-zip-compressed", ".zip"),
    Z("application/x-compress", ".z"),
    BMP("image/bmp", ".bmp"),
    GIF("image/gif", "gif"),
    PNG("image/png", ".png"),
    TIFF("image/tiff", ".tiff"),
    JPEG("image/jpeg", ".jpeg"),
    TXT("text/plain", ".txt"),
    XML("text/xml", ".xml"),
    HTML("text/html", ".html"),
    //HTML("text/html", ".html"),
    FORM("application/x-www-form-urlencoded", ".html"),
    JSON("application/json", ".json");

    private final String suffix;
    private final String contentType;

    ContentType(String contentType, String suffix) {
        this.contentType = contentType;
        this.suffix = suffix;

    }

    public String getSuffix() {
        return suffix;
    }

    public String getContentType() {
        return contentType;
    }
}
