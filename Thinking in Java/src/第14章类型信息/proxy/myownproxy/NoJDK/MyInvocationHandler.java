package 第14章类型信息.proxy.myownproxy.NoJDK;

import java.lang.reflect.Method;

public interface MyInvocationHandler {
    
     public Object invoke(Object proxy, Method method, Object[] args)
                throws Throwable;
     
}
