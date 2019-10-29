package org.hystudio.httpframework.processors;

public interface IProcessor {
    public void process();

    public void setCurrentResult(Object currentResult);

    public Object getPrevResult();

    public void setProcessData(ProcessData processData);
}
