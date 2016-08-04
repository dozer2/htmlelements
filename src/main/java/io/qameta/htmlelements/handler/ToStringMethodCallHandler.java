package io.qameta.htmlelements.handler;

import java.lang.reflect.Method;

class ToStringMethodCallHandler implements ByNameMethodCallHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method);
        return "Proxy element";
    }

    @Override
    public String getHandleMethodName() {
        return "toString";
    }
}