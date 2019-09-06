package org.hystudio.httpframework.framework;

import org.hystudio.httpframework.framework.annotation.HttpRequest;
import org.hystudio.httpframework.framework.proxy.HttpRequestFactory;
import org.hystudio.httpframework.framework.proxy.HttpSessionHandle;
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
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.ClassUtils;

import java.util.Set;

public class HttpRequestRegistry implements
        BeanDefinitionRegistryPostProcessor, EnvironmentAware, ResourceLoaderAware, BeanClassLoaderAware, BeanFactoryAware, ApplicationContextAware {
    private String mainClassPath;
    private ClassPathScanningCandidateComponentProvider scanner;
    private Environment environment;
    private ResourceLoader resourceLoader;
    private ClassLoader classLoader;
    private Set<BeanDefinition> beanDefinitionSet;
    private BeanFactory beanFactory;
    private HttpRequestFactory httpRequestFactory;
    private ApplicationContext applicationContext;
    private HttpSessionDefinitionRegistry httpSessionDefinitionRegistry;

    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        this.initHttpSessionHandle();
        this.initHttpSessionThreadPool();
        this.initHttpSessionDefinitionRegistry();
        this.initHttpSessionFactory();
        this.initHttpRequestFactory();
        this.getBasePackage();//获取main的包名路径
        this.createPackageScanner();//创建包扫描器
        this.startScan();//开始扫描含有HttpQuest的注解
        this.resolveHttpRequest();//构建对象
    }

    /**
     * 初始化每个HttpSession的定义注册器
     */
    private void initHttpSessionDefinitionRegistry() {
        this.httpSessionDefinitionRegistry = new HttpSessionDefinitionRegistry();
        ((DefaultListableBeanFactory) beanFactory).registerSingleton(HttpSessionDefinitionRegistry.class.getName(), this.httpSessionDefinitionRegistry);
    }

    /**
     * 初始化HttpRequest工厂
     */
    private void initHttpRequestFactory() {
        this.httpRequestFactory = new HttpRequestFactory(this.applicationContext);
    }

    /**
     * 初始化HttpSession工厂
     */
    private void initHttpSessionFactory() {
        ((DefaultListableBeanFactory) beanFactory).registerSingleton(HttpSessionFactory.class.getName(), new HttpSessionFactory(this.httpSessionDefinitionRegistry));
    }

    /**
     * 2.
     * 初始化HttpSessionThreadPool
     */
    private void initHttpSessionThreadPool() {
        ((DefaultListableBeanFactory) beanFactory).registerSingleton(HttpSessionThreadPool.class.getName(), new HttpSessionThreadPool());
    }

    /**
     * 1.
     * 初始化HttpSessionHandle
     */
    private void initHttpSessionHandle() {
        ((DefaultListableBeanFactory) beanFactory).registerSingleton(HttpSessionHandle.class.getName(), new HttpSessionHandle(this.applicationContext));
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
        return httpRequestFactory.createProxy(annotatedBeanDefinition);
    }

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

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
