package org.hystudio.httpframework;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;

import java.util.Set;


public class HttpRequestRegistry implements
        BeanDefinitionRegistryPostProcessor, ApplicationContextAware, EnvironmentAware, BeanClassLoaderAware, ResourceLoaderAware, BeanFactoryAware {
    private ApplicationContext applicationContext;
    private HttpRequestInterfaceScanner httpRequestInterfaceScanner;
    private HttpRequestProxyFactory httpRequestProxyFactory;

    public HttpRequestRegistry() {
        httpRequestInterfaceScanner = HttpRequestInterfaceScanner.createScanner();
        httpRequestProxyFactory = HttpRequestProxyFactory.createFactory();
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        Set<BeanDefinition> beanDefinitionSet = this.httpRequestInterfaceScanner.scanHttpRequestInterface();
        this.httpRequestProxyFactory.setBeanDefinitionSet(beanDefinitionSet);
        this.httpRequestProxyFactory.createBean();
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.httpRequestInterfaceScanner.setBeanClassLoader(classLoader);
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.httpRequestInterfaceScanner.setEnvironment(environment);
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.httpRequestInterfaceScanner.setResourceLoader(resourceLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.httpRequestProxyFactory.setBeanFactory(beanFactory);
    }
}
