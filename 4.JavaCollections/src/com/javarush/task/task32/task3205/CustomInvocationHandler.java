package com.javarush.task.task32.task3205;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustomInvocationHandler implements InvocationHandler {
    private SomeInterfaceWithMethods methods;

    public CustomInvocationHandler(SomeInterfaceWithMethods methods){
        this.methods=methods;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + " in");
        Object obj = method.invoke(methods,args);
        System.out.println(method.getName() + " out");
        return obj;
    }
}
