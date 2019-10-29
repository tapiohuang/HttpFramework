package org.hystudio.httpframework.resolvers;

import org.hystudio.httpframework.processors.IProcessor;

import java.util.LinkedList;

public class ResponseDataResolver implements
        IResolver, IProcessorResolver, IExecutableResolver {
    private LinkedList<IProcessor> responseProcessorList;

    @Override
    public void resolver() {

    }

    @Override
    public void execute() {

    }

    @Override
    public void setProcessorList(LinkedList processorList) {

    }
}
