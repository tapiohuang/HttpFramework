package org.hystudio.httpframework.framework2;

import org.hystudio.httpframework.framework2.processor.IProcessorHandle;

public interface IProcessorHandleFactory {
    public IProcessorHandle createProcessorHandle(Object[] objects, int[] processorOrder);
}
