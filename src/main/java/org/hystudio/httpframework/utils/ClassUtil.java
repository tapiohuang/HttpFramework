package org.hystudio.httpframework.utils

import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method
import java.util.Arrays
import java.util.HashMap
import java.util.HashSet

object ClassUtil {

    private val baseMethod = HashSet(Arrays.asList("toString", "hashCode", "equals", "clone"))

    fun callMethod(method: Method, target: Any, vararg args: Any) {
        try {
            method.invoke(target, *args)
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
        }

    }

    fun isImplement(c1: Class<*>, c2: Class<*>): Boolean {
        val interfaces = c1.interfaces
        for (interfaceClass in interfaces) {
            if (interfaceClass == c2) {
                return true
            }
        }
        return false
    }

    fun getMethodMap(o: Any): HashMap<String, Method> {
        return getMethodMap(o.javaClass)
    }

    fun getMethodMap(clazz: Class<*>): HashMap<String, Method> {
        val methods = clazz.methods
        val methodHashMap = HashMap<String, Method>()
        for (m in methods) {
            methodHashMap[m.name] = m
        }
        return methodHashMap
    }

    fun isBaseMethod(method: Method): Boolean {
        val methodName = method.name
        return baseMethod.contains(methodName)
    }
}
