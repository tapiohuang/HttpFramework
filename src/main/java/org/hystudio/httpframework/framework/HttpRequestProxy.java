package org.hystudio.httpframework.framework

import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.cglib.proxy.CallbackFilter
import org.springframework.cglib.proxy.Enhancer
import org.springframework.cglib.proxy.MethodInterceptor
import org.springframework.cglib.proxy.MethodProxy

import java.lang.reflect.Method

class HttpRequestProxy : MethodInterceptor, CallbackFilter {


    @Throws(Throwable::class)
    override fun intercept(o: Any, method: Method, objects: Array<Any>, methodProxy: MethodProxy): Any? {
        return null
    }

    override fun accept(method: Method): Int {
        return 0
    }

    companion object {
        var httpRequestProxy = HttpRequestProxy()

        fun createProxy(beanDefinition: BeanDefinition): Any? {
            try {
                val clazz = Class.forName(beanDefinition.beanClassName)
                val enhancer = Enhancer()
                enhancer.setSuperclass(clazz)
                val httpRequestProxy = HttpRequestProxy()
                enhancer.setCallback(httpRequestProxy)
                enhancer.setCallbackFilter(httpRequestProxy)
                return enhancer.create()
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return null
        }
    }
}
