package org.hystudio.httpframework.framework.processor;

import org.hystudio.httpframework.framework.processor.response.AbstractResponseProcessor;

import java.util.LinkedList;

public abstract class AbstractProcessorHandle implements IProcessorHandle {
    protected LinkedList<IProcessor> processors;

    public AbstractProcessorHandle() {
        this.processors = new LinkedList<>();
    }

    public abstract void addProcessor(IProcessor processor);

    @Override
    public void process() {

    }
}
