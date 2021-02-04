package com.kawainekosann.Proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    static private Target target = new Target();
    //获得增强对象
    static private Advice advice = new Advice();
    public static void main(String[] args) {
        TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),//目标对象的类加载器
                target.getClass().getInterfaces(),//目标对象相同的接口字节码对象
                new InvocationHandler() {
                    //调用代理对象是实际执行invoke方法
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //这里的invoke是通过反射执行方法
                        advice.before();
                        method.invoke(target, args);
                        advice.after();
                        return null;
                    }
                }
        );
        proxy.save();
    }
}
