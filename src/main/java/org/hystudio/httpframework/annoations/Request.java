package org.hystudio.httpframework.annoations;


import org.hystudio.httpframework.ContentType;
import org.hystudio.httpframework.DataType;
import org.hystudio.httpframework.RequestMethod;

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
