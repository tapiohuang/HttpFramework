package org.hystudio.httpframework.processors;

import org.hystudio.httpframework.beans.RequestEntityObjectBean;

public interface IRequestBodyPostedProcessor extends IRequestBodyProcessor {
    public void setRequestEntityObjectBean(RequestEntityObjectBean requestEntityObjectBean);
}
