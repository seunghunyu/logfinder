package ysh.aop.proxyvs;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;
import ysh.aop.order.aop.member.MemberService;
import ysh.aop.order.aop.member.MemberServiceImpl;
import ysh.proxy.proxyfactory.ProxyFactoryTest;

@Slf4j
public class ProxyCastingTest {
    @Test
    void jdkProxy(){
        MemberServiceImpl target = new MemberServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.setProxyTargetClass(false); //jdk 동적 프록시

        //프록시를 인터페이스로 캐스팅 성공
        MemberService proxy = (MemberService) proxyFactory.getProxy();

    }

}
