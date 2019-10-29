package org.hystudio.httpframework.processors;


public interface IRequestProcessor extends IProcessor {
    public void setProcessData(ProcessData processData);

    void saveProcessData();
}
