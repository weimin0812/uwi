package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CookHandler implements InvocationHandler {
    private Cook realCooker;

    public CookHandler(Cook realCooker) {
        this.realCooker = realCooker;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke start");
        System.out.println("method name: " + method.getName());
        method.invoke(realCooker, args);
        System.out.println("invoke end");
        return null;
    }
}
