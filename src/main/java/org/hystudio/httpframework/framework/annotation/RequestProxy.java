package org.hystudio.httpframework.framework.annotation;

import java.lang.annotation.*;

/**
 * Proxy参数注解
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestProxy {
}
