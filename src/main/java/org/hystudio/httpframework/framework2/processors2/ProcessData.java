package org.hystudio.httpframework.framework2.processors2;


abstract class AbstractProcessData {
    private Object currentResult;//当前Processor处理的结果
    private Object prevResult;//上一个Processor处理的结果
    private boolean isFirst;//是否为第一个Processor
    private Class<? extends IProcessor> nextProcessor;//下一个Processor

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

    public boolean isFirst() {
        return isFirst;
    }

    public void setFirst(boolean first) {
        isFirst = first;
    }

    public Class<? extends IProcessor> getNextProcessor() {
        return nextProcessor;
    }

    public void setNextProcessor(Class<? extends IProcessor> nextProcessor) {
        this.nextProcessor = nextProcessor;
    }
}
