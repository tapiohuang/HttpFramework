package org.hystudio.httpframework.framework2.processor;

import java.util.LinkedList;

public abstract class AbstractProcessorHandle implements IProcessorHandle {
    protected LinkedList<AbstractProcessor> processors;
    private Object finalResult;

    public AbstractProcessorHandle() {
        this.processors = new LinkedList<>();
    }

    public Object getFinalResult() {
        return finalResult;
    }

    public abstract void addProcessor(IProcessor processor);

    public abstract void addProcessorFirst(IProcessor processor);

    @Override
    public void process() {
        Object prevResult = null;
        int index = 0;
        do {
            AbstractProcessor processor = processors.get(index);
            processor.setPrevResult(prevResult);
            processor.process();
            prevResult = processor.getCurrentResult();
            index++;
        } while (index < processors.size());
        finalResult = prevResult;
    }
}
