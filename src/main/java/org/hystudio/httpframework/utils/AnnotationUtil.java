package org.hystudio.httpframework.utils;

import sun.reflect.annotation.AnnotationType;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

public class AnnotationUtil {

    public static boolean findAnnotations(Class clazz, Class annotationType) {
        AnnotationScanner annotationScanner = new AnnotationScanner();
        return annotationScanner.findAnnotation(clazz).contains(annotationType);
    }

    private static boolean isAnnotation(Class clazz) {
        return clazz.isAnnotation();
    }

    private static boolean isAnnotation(Object o) {
        return isAnnotation(o.getClass());
    }

    private static class AnnotationScanner {
        private Set<Class> annotationSet = new HashSet<>();

        public Set<Class> findAnnotation(Class clazz) {
            Annotation[] annotations = clazz.getAnnotations();
            for (Annotation a : annotations
            ) {
                if (!annotationSet.contains(a.annotationType())) {
                    annotationSet.add(a.annotationType());
                    findAnnotation(a.annotationType());
                }
            }
            return annotationSet;
        }
    }
}
