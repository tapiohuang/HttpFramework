package org.hystudio.httpframework.framework2.processors2;

import org.hystudio.httpframework.framework2.data.DataBody;

public interface IResponseBodyProcessor extends IResponseProcessor {
    public void setDataBody(DataBody dataBody);
}
