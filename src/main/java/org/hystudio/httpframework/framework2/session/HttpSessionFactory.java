package org.hystudio.httpframework.framework2.session;

import com.sun.org.apache.regexp.internal.RE;
import org.hystudio.httpframework.framework2.reader.IReaderFactory;
import org.hystudio.httpframework.framework2.sender.ISenderFactory;
import org.hystudio.httpframework.framework2.reader.ReaderFactory;
import org.hystudio.httpframework.framework2.sender.SenderFactory;
import org.hystudio.httpframework.framework2.data.RequestData;
import org.hystudio.httpframework.framework2.data.ResponseData;
import org.hystudio.httpframework.framework2.exception.HttpSessionInitException;
import org.hystudio.httpframework.framework2.processor.request.handle.IRequestProcessorHandleFactory;
import org.hystudio.httpframework.framework2.processor.request.handle.RequestProcessorHandleFactory;
import org.hystudio.httpframework.framework2.processor.request.handle.RequestProcessorsHandle;
import org.hystudio.httpframework.framework2.processor.response.handle.IResponseProcessorHandleFactory;
import org.hystudio.httpframework.framework2.processor.response.handle.ResponseProcessorHandleFactory;
import org.hystudio.httpframework.framework2.processor.response.handle.ResponseProcessorsHandle;
import org.hystudio.httpframework.framework2.reader.IReader;
import org.hystudio.httpframework.framework2.sender.ISender;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * HttpSession工厂，生命周期只实例化一次
 * HttpSessionFactory将会被注入到每个代理的对象中
 */
public final class HttpSessionFactory implements ISenderFactory, IReaderFactory, IRequestProcessorHandleFactory, IResponseProcessorHandleFactory {

    private ReaderFactory readerFactory;

    private SenderFactory senderFactory;

    private RequestProcessorHandleFactory requestProcessorHandleFactory;

    private ResponseProcessorHandleFactory responseProcessorHandleFactory;

    public HttpSessionFactory() {
        this.requestProcessorHandleFactory = new RequestProcessorHandleFactory();
        this.responseProcessorHandleFactory = new ResponseProcessorHandleFactory();
        this.senderFactory = new SenderFactory();
        this.readerFactory = new ReaderFactory();
    }

    /**
     * @param httpSessionDefinition HttpSession的定义
     * @param objects               方法的参数
     * @return HttpSession
     */
    public HttpSession createHttpSession(HttpSessionDefinition httpSessionDefinition, Object[] objects) {
        HttpSession httpSession = new HttpSession();
        httpSession.setRequestMethod(httpSessionDefinition.getRequestMethod());
        httpSession.setSender(createSender(httpSession));
        httpSession.setReader(creatReader(httpSession));
        httpSession.setRequestData(new RequestData());
        httpSession.setResponseData(new ResponseData());

        RequestProcessorsHandle requestProcessorsHandle = createRequestProcessorsHandle(objects, httpSessionDefinition);
        ResponseProcessorsHandle responseProcessorsHandle = createResponseProcessorsHandle(objects, httpSessionDefinition);
        requestProcessorsHandle.setRequestData(httpSession.getRequestData());

        responseProcessorsHandle.setResponseData(httpSession.getResponseData());
        httpSession.setRequestProcessorHandle(requestProcessorsHandle);
        httpSession.setResponseProcessorHandle(responseProcessorsHandle);

        httpSession.setUrl(httpSessionDefinition.getUrl());

        return httpSession;
    }


    @Override
    public ISender createSender(HttpSession httpSession) {
        ISender sender = senderFactory.createSender(httpSession);
        if (sender == null) {
            throw new HttpSessionInitException("找不到合适的Sender");
        }
        return sender;
    }

    @Override
    public IReader creatReader(HttpSession httpSession) {
        IReader reader = readerFactory.creatReader(httpSession);
        if (reader == null) {
            throw new HttpSessionInitException("找不到合适的Reader");
        }
        return reader;
    }

    @Override
    public RequestProcessorsHandle createRequestProcessorsHandle(Object[] objects, HttpSessionDefinition httpSessionDefinition) {
        RequestProcessorsHandle requestProcessorsHandle = this.requestProcessorHandleFactory.createRequestProcessorsHandle(objects, httpSessionDefinition);
        return requestProcessorsHandle;
    }

    @Override
    public ResponseProcessorsHandle createResponseProcessorsHandle(Object[] objects, HttpSessionDefinition httpSessionDefinition) {
        ResponseProcessorsHandle responseProcessorsHandle = this.responseProcessorHandleFactory.createResponseProcessorsHandle(objects, httpSessionDefinition);
        return responseProcessorsHandle;
    }
}
