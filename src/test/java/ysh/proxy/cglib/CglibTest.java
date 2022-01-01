package ysh.proxy.cglib;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;
import ysh.proxy.cglib.code.TImeMethodInterceptor;
import ysh.proxy.common.sevice.ConcreteService;

@Slf4j
public class CglibTest {
    @Test
    void cglib(){
        ConcreteService target = new ConcreteService();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ConcreteService.class);
        enhancer.setCallback(new TImeMethodInterceptor(target));
        ConcreteService proxy = (ConcreteService) enhancer.create();

        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", target.getClass());

        proxy.call();
    }

}
