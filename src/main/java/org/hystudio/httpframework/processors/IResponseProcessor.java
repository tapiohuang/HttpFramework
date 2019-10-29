package org.hystudio.httpframework.processors;


public interface IResponseProcessor extends IProcessor {
    public void setProcessData(ProcessData processData);

    void saveProcessData();
}
