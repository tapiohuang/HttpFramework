package org.hystudio.httpframework.processors;

public abstract class AbstractProcessor implements IProcessor {
    private ProcessData processData;

    @Override
    public void setCurrentResult(Object currentResult) {
        this.processData.setCurrentResult(currentResult);
    }

    @Override
    public Object getPrevResult() {
        return this.processData.getPrevResult();
    }

    @Override
    public void setProcessData(ProcessData processData) {
        this.processData = processData;
    }
}
