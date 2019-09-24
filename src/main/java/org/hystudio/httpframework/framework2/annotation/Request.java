package org.hystudio.httpframework.framework2.annotation;


import org.hystudio.httpframework.framework2.config.ContentType;
import org.hystudio.httpframework.framework2.config.RequestMethod;
import org.hystudio.httpframework.framework2.config.DataType;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Request {
    String url();

    RequestMethod method();

    ContentType contentType();

    DataType dataType();

    int timeout() default 5000;
}
