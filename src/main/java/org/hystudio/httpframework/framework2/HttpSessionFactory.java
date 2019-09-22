package org.hystudio.httpframework.framework2.session;

import org.hystudio.httpframework.framework2.session.HttpSession;
import org.hystudio.httpframework.framework2.session.HttpSessionDefinition;

/**
 * HttpSession工厂，生命周期只实例化一次
 * HttpSessionFactory将会被注入到每个代理的对象中
 */
public class HttpSessionFactory {

    /**
     * @param httpSessionDefinition HttpSession的定义
     * @param objects               方法的参数
     * @return HttpSession
     */
    public HttpSession createHttpSession(HttpSessionDefinition httpSessionDefinition, Object[] objects) {
        HttpSession httpSession = new HttpSession();
        httpSession.setRequestMethod(httpSessionDefinition.getRequestMethod());
        return null;
    }
}
