package controller;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SellProxy implements InvocationHandler {
    private  Object o;

    public SellProxy() {
    }

    public SellProxy(Object o) {
        this.o = o;
    }
    public   Object getInstance(){
        return Proxy.newProxyInstance(o.getClass().getClassLoader(),o.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(o, args);
        System.out.println("充值50，送10");
        return invoke;
    }
}
