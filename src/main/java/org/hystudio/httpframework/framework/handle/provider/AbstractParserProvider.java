package org.hystudio.httpframework.framework.handle.provider;

import org.hystudio.httpframework.framework.config.RequestContentType;
import org.hystudio.httpframework.framework.config.ResponseDataType;
import org.hystudio.httpframework.framework.factory.DefaultContentParserFactory;
import org.hystudio.httpframework.framework.factory.DefaultDataParserFactory;
import org.hystudio.httpframework.framework.interfaces.ContentParser;
import org.hystudio.httpframework.framework.interfaces.DataParser;

public abstract class AbstractParserProvider {
    public abstract void setContentParser();

    public abstract void setDataParser();

    public ContentParser createDefaultContentParser(RequestContentType requestContentType) {
        return DefaultContentParserFactory.createParser(requestContentType);
    }

    public DataParser createDefaultDataParser(ResponseDataType responseDataType) {
        return DefaultDataParserFactory.createParser(responseDataType);
    }
}
