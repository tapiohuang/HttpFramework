package org.hystudio.httpframework.resolvers;

import org.hystudio.httpframework.processors.IProcessor;

import java.util.LinkedList;

public interface IProcessorResolver<T extends IProcessor> {
    public void setProcessorList(LinkedList<T> processorList);
}
