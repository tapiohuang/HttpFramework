package org.hystudio.httpframework.framework2;

import org.hystudio.httpframework.framework.Method;
import org.hystudio.httpframework.framework.SessionConnection;
import org.hystudio.httpframework.framework.data.request.RequestData;
import org.hystudio.httpframework.framework.data.response.ResponseData;
import org.hystudio.httpframework.framework.sender.ISender;

public class HttpSession {
    private ISender sender;//请求的发送器
    private Method method;//请求方式
    private RequestData requestData;//请求数据
    private ResponseData responseData;//返回数据
    private SessionConnection sessionConnection;//会话的Http连接
}
