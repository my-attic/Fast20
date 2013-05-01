module dynogolo

import java.lang.invoke.MethodHandle
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

function DynamicProxy = |instance, dyno| { #dyno is a DynamicObject

    let instanceProxy = Proxy.newProxyInstance(
        instance:getClass():getClassLoader(),
        instance:getClass():getInterfaces(),
        (|proxy, method, args...| {

            #println("->[You've called : " + method:getName() + "]")

            let result = null

            dyno:realSubject(instance)

            let methodHandle = dyno:get(method:getName())

                if methodHandle isnt null {
                       if args isnt null { result = methodHandle(dyno, args) } else { result = methodHandle(dyno) }
                } else {
                        raise("### You have to wrap "+method:getName()+"() method ###")
                }

            return result

        }):to(InvocationHandler.class))

    return instanceProxy
}