package org.hystudio.httpframework.framework.annotation;

import org.hystudio.httpframework.framework.config.RequestContentType;
import org.hystudio.httpframework.framework.config.RequestMethod;
import org.hystudio.httpframework.framework.config.ResponseDataType;
import org.hystudio.httpframework.framework.interfaces.ContentParser;
import org.hystudio.httpframework.framework.interfaces.DataParser;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Request {
    String url();

    RequestMethod method();

    RequestContentType contentType();

    ResponseDataType dataType();

    int timeout() default 5000;
}
