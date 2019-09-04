package org.hystudio.httpframework.framework.proxy;

import org.hystudio.httpframework.framework.annotation.HttpRequest;
import org.hystudio.httpframework.framework.handle.RequestHandle;
import org.hystudio.httpframework.framework.proxy.HttpRequestProxyFactory;
import org.hystudio.httpframework.utils.StackTraceUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Method;
import java.util.Set;

public class HttpRequestDefinitionRegistry implements BeanDefinitionRegistryPostProcessor, EnvironmentAware, ResourceLoaderAware, BeanClassLoaderAware, BeanFactoryAware {
    private String mainClassPath;
    private ClassPathScanningCandidateComponentProvider scanner;
    private Environment environment;
    private ResourceLoader resourceLoader;
    private ClassLoader classLoader;
    private Set<BeanDefinition> beanDefinitionSet;
    private BeanFactory beanFactory;


    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        this.getBasePackage();//获取main的包名路径
        this.createPackageScanner();//创建包扫描器
        this.startScan();
        this.resolveHttpRequest();
    }

    private void startScan() {
        AnnotationTypeFilter annotationTypeFilter = new AnnotationTypeFilter(HttpRequest.class);
        scanner.addIncludeFilter(annotationTypeFilter);
        scanner.setResourceLoader(this.resourceLoader);
        beanDefinitionSet = scanner.findCandidateComponents(mainClassPath);
    }

    private void resolveHttpRequest() {
        for (BeanDefinition beanDefinition : beanDefinitionSet
        ) {
            if (beanDefinition instanceof AnnotatedBeanDefinition) {
                ((DefaultListableBeanFactory) beanFactory).registerSingleton(beanDefinition.getBeanClassName(), createBean((AnnotatedBeanDefinition) beanDefinition));
            }
        }
    }

    /**
     * 使用Cglib对接口进行代理
     *
     * @param annotatedBeanDefinition AnnotatedBeanDefinition
     * @return Object //返回的代理Bean
     */
    private Object createBean(AnnotatedBeanDefinition annotatedBeanDefinition) {
        Object o = HttpRequestProxyFactory.createProxy(annotatedBeanDefinition);
        return o;
    }

    /*
    JDK的动态代理
     */
/*    private InvocationHandler createInvocationHandler() {
        return new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                RequestHandle requestHandle = new RequestHandle(method, args);
                return requestHandle.handle();
            }
        };
    }*/


    private void getBasePackage() {
        try {
            mainClassPath = StackTraceUtil.getBasePackageByMain(128);
        } catch (NoSuchMethodException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void createPackageScanner() {
        this.scanner = new ClassPathScanningCandidateComponentProvider(false, this.environment) {
            @Override
            protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
                if (beanDefinition.getMetadata().isInterface()) {
                    try {
                        Class<?> target = ClassUtils.forName(beanDefinition.getMetadata().getClassName(), classLoader);
                        return !target.isAnnotation();
                    } catch (Exception ex) {
                        return false;
                    }
                }
                return false;
            }
        };
    }

    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
    }

    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
