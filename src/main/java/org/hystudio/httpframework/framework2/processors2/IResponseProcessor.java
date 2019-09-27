package org.hystudio.httpframework.framework2.processors2;

public interface IResponseProcessor extends IProcessor {
    public void setProcessData(ProcessData processData);

    void saveProcessData();
}
