package org.hystudio.httpframework.framework2.processors2;


public final class ProcessData {
    private Object currentResult;//当前Processor处理的结果
    private Object prevResult;//上一个Processor处理的结果

    public Object getCurrentResult() {
        return currentResult;
    }

    public void setCurrentResult(Object currentResult) {
        this.currentResult = currentResult;
    }

    public Object getPrevResult() {
        return prevResult;
    }

    public void setPrevResult(Object prevResult) {
        this.prevResult = prevResult;
    }
    
}
