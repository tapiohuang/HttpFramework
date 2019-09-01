package org.hystudio.httpframework.framework.factory;

import org.hystudio.httpframework.framework.config.ResponseDataType;
import org.hystudio.httpframework.framework.exception.HttpRequestException;
import org.hystudio.httpframework.framework.interfaces.DataParser;
import org.hystudio.httpframework.framework.parser.data.DefaultJsonDataParser;

public class DefaultDataParserFactory {
    public static DataParser createParser(ResponseDataType responseDataType) throws HttpRequestException {
        switch (responseDataType) {
            case JSON:
                return new DefaultJsonDataParser();
            case TEXT:
            case HTML:
            case XML:
            case SCRIPT:
            default:
                throw new HttpRequestException("没有找到默认的数据解析器");
        }
    }
}
