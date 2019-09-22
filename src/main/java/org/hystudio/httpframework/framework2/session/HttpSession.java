package org.hystudio.httpframework.framework2;

import org.hystudio.httpframework.framework2.config.RequestMethod;
import org.hystudio.httpframework.framework2.data.RequestData;
import org.hystudio.httpframework.framework2.data.ResponseData;
import org.hystudio.httpframework.framework2.sender.ISender;
import org.hystudio.httpframework.framework2.reader.IReader;

public class HttpSession {
    private ISender sender;//请求的发送器
    private IReader reader;//请求的接收器
    private RequestMethod requestMethod;//请求方式
    private RequestData requestData;//请求数据
    private ResponseData responseData;//返回数据
    private HttpSessionConnection httpSessionConnection;//会话的Http连接
}
