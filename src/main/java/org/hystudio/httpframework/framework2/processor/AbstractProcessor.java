package org.hystudio.httpframework.framework2.processor;

public abstract class AbstractProcessor implements IProcessor {
    protected Object currentResult;//当前Processor处理的结果
    protected Object prevResult;//上一个Processor处理的结果
    protected boolean isFirst;//是否为第一个Processor
    protected Class<? extends IProcessor> nextProcessor;//下一个Processor

    /**
     * 获取当前Processor的处理结果，并且将处理好的结果使用setPrevRequest(Object prevRequest)传入下一个Processor
     *
     * @return Object
     */
    public final Object getCurrentResult() {
        return currentResult;
    }

    /**
     * 设置当前Processor处理完成的结果，此方法应该被子类调用
     *
     * @param currentResult Object
     */
    protected final void setCurrentResult(Object currentResult) {
        this.currentResult = currentResult;
    }

    /**
     * 获取上一个Processor处理后的结果，此方法仅被子类调用
     *
     * @return Object
     */
    protected final Object getPrevResult() {
        return prevResult;
    }

    /**
     * 设置上一个Processor处理的结果
     *
     * @param prevResult Object
     */
    public final void setPrevResult(Object prevResult) {
        this.prevResult = prevResult;
    }

    protected abstract void setNextProcessor(Class<? extends IProcessor> processor);
}
