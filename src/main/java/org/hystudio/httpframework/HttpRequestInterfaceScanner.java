package org.hystudio.httpframework;

import org.hystudio.httpframework.annonations.HTTP;
import org.hystudio.httpframework.utils.StackTraceUtil;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.ClassUtils;

import java.util.Set;

public class HttpRequestInterfaceScanner implements EnvironmentAware, BeanClassLoaderAware, ResourceLoaderAware {
    private static HttpRequestInterfaceScanner httpRequestInterfaceScanner;
    private ClassPathScanningCandidateComponentProvider scanner;
    private Environment environment;
    private ClassLoader classLoader;
    private ResourceLoader resourceLoader;
    private String mainClassPath;

    private HttpRequestInterfaceScanner() {
        this.getBasePackage();
    }

    synchronized static HttpRequestInterfaceScanner createScanner() {
        if (httpRequestInterfaceScanner == null) {
            httpRequestInterfaceScanner = new HttpRequestInterfaceScanner();
        }
        return httpRequestInterfaceScanner;
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

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }


    Set<BeanDefinition> scanHttpRequestInterface() {
        this.createPackageScanner();
        AnnotationTypeFilter annotationTypeFilter = new AnnotationTypeFilter(HTTP.class);
        scanner.addIncludeFilter(annotationTypeFilter);
        scanner.setResourceLoader(this.resourceLoader);
        return scanner.findCandidateComponents(mainClassPath);
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    private void getBasePackage() {
        try {
            this.mainClassPath = StackTraceUtil.getBasePackageByMain(128);
        } catch (NoSuchMethodException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

