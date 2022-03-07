package ysh.aop.pointcut;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import ysh.aop.order.aop.member.MemberService;
/*
* application.properties
* spring.aop.proxy-target-class=true //CGLIB
* spring.aop.proxy-target-class=false//JDK 동적 프록시
 */
@Slf4j
@Import(ThisTargetTest.ThisTargetAspect.class)
@SpringBootTest(properties = "spring.aop.proxy-target-class=false")
public class ThisTargetTest {

    @Autowired
    MemberService memberService;

    @Test
    void success(){
        log.info("memberService Proxy={}", memberService.getClass());
        memberService.Hello("helloA");
    }

    @Slf4j
    @Aspect
    static class ThisTargetAspect{
        //부모타입 허용
        @Around("this(ysh.aop.order.aop.member.MemberService)")
        public Object doThisInterface(ProceedingJoinPoint joinPoint) throws Throwable {
            log.info("[this-interface] {}",joinPoint.getSignature());
            return joinPoint.proceed();
        }
        //부모타입 허용
        @Around("target(ysh.aop.order.aop.member.MemberService)")
        public Object doTargetInterface(ProceedingJoinPoint joinPoint) throws Throwable {
            log.info("[target-interface] {}",joinPoint.getSignature());
            return joinPoint.proceed();
        }

        @Around("this(ysh.aop.order.aop.member.MemberServiceImpl)")
        public Object doThis(ProceedingJoinPoint joinPoint) throws Throwable {
            log.info("[this-impl] {}",joinPoint.getSignature());
            return joinPoint.proceed();
        }

        @Around("target(ysh.aop.order.aop.member.MemberServiceImpl)")
        public Object doTarget(ProceedingJoinPoint joinPoint) throws Throwable {
            log.info("[target-impl] {}",joinPoint.getSignature());
            return joinPoint.proceed();
        }
    }

}
