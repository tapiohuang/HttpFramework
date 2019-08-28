package org.hystudio.httpframework.framework.factory;

import org.hystudio.httpframework.framework.config.RequestContentType;
import org.hystudio.httpframework.framework.exception.HttpRequestException;
import org.hystudio.httpframework.framework.interfaces.ContentParser;
import org.hystudio.httpframework.framework.parser.content.DefaultFormContentParser;
import org.hystudio.httpframework.framework.parser.content.DefaultJsonContentParser;

public class DefaultContentParserFactory {
    public static ContentParser createParser(RequestContentType requestContentType) throws HttpRequestException {
        switch (requestContentType) {
            case FORM:
                return new DefaultFormContentParser();
            case JSON:
                return new DefaultJsonContentParser();
            case XML:
            default:
                throw new HttpRequestException("没有找到默认的数据解析器");
        }
    }
}
