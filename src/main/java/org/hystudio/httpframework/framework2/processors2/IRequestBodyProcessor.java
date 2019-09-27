package org.hystudio.httpframework.framework2.processors2;

import org.hystudio.httpframework.framework2.data.DataBody;

public interface IRequestBodyProcessor extends IRequestProcessor {
    public void setRequestEntities(Object[] requestEntities);

    public void setDataBody(DataBody dataBody);
}
