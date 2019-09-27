package org.hystudio.httpframework.framework2.processors2;

interface IRequestProcessor extends IProcessor {
    public void setProcessData(ProcessData processData);

    void saveProcessData();
}
