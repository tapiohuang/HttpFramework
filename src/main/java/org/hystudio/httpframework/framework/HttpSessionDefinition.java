package org.hystudio.httpframework.framework

import java.lang.reflect.Method

class HttpSessionDefinition(val method: Method, val argsType: Array<Class<*>>, val argNumb: Int, val argsAnnotations: Array<Array<Annotation>>)
