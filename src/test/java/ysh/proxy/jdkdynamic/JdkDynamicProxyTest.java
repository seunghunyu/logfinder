package ysh.proxy.jdkdynamic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import ysh.proxy.jdkdynamic.code.AImpl;
import ysh.proxy.jdkdynamic.code.AInterface;
import ysh.proxy.jdkdynamic.code.TimeInvocationHandler;

import java.lang.reflect.Proxy;

@Slf4j
public class JdkDynamicProxyTest {
    @Test
    void dynamicA(){
        AInterface target = new AImpl();
        TimeInvocationHandler handler = new TimeInvocationHandler(target);

        AInterface proxy = (AInterface) Proxy.newProxyInstance(AInterface.class.getClassLoader(), new Class[]{AInterface.class}, handler);

        proxy.call();
        log.info("targetClass={}",target.getClass());
        log.info("proxyClass={}",proxy.getClass());
    }

}
