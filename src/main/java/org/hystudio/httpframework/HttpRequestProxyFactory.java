package org.hystudio.httpframework;

import org.hystudio.httpframework.exceptions.CreateRequestBeanProxyException;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.cglib.proxy.Enhancer;

import java.util.Set;

public class HttpRequestProxyFactory implements BeanFactoryAware {
    private static HttpRequestProxyFactory httpRequestProxyFactory;
    private Set<BeanDefinition> beanDefinitionSet;
    private DefaultListableBeanFactory defaultListableBeanFactory;

    private HttpRequestProxyFactory() {
    }

    synchronized static HttpRequestProxyFactory createFactory() {
        if (httpRequestProxyFactory == null) {
            httpRequestProxyFactory = new HttpRequestProxyFactory();
        }
        return httpRequestProxyFactory;
    }

    void setBeanDefinitionSet(Set<BeanDefinition> beanDefinitionSet) {
        this.beanDefinitionSet = beanDefinitionSet;
    }

    void createBean() {
        for (BeanDefinition beanDefinition : beanDefinitionSet
        ) {
            if (beanDefinition instanceof AnnotatedBeanDefinition) {
                defaultListableBeanFactory.registerSingleton(beanDefinition.getBeanClassName(), createBean((AnnotatedBeanDefinition) beanDefinition));
            }
        }
    }

    private Object createBean(AnnotatedBeanDefinition annotatedBeanDefinition) {
        try {
            Class clazz = Class.forName(annotatedBeanDefinition.getBeanClassName());
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(clazz);
            enhancer.setCallback(new HttpRequestProxy());
            return enhancer.create();
        } catch (Exception e) {
            throw new CreateRequestBeanProxyException(e);
        }
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.defaultListableBeanFactory = (DefaultListableBeanFactory) beanFactory;
    }
}
