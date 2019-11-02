package org.hystudio.httpframework.annonations;

import org.hystudio.httpframework.type.HTTPContentType;
import org.hystudio.httpframework.type.HTTPDataType;
import org.hystudio.httpframework.type.HTTPRequestMethodType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface HTTPRequestMethod {
    String url();

    HTTPContentType contentType();

    HTTPDataType dataType();

    HTTPRequestMethodType methodType() default HTTPRequestMethodType.GET;
}
