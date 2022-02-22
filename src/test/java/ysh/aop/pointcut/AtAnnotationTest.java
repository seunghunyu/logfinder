package ysh.aop.pointcut;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import ysh.aop.order.aop.member.MemberService;

@Slf4j
@Import(AtAnnotationTest.AtAnnotationAspect.class)
public class AtAnnotationTest {
    @Autowired
    MemberService memberService;

    @Test
    void success(){
        log.info("memberService Proxy={}", memberService.getClass());
        memberService.Hello("helloA");
    }
    @Slf4j
    @Aspect
    static class AtAnnotationAspect {
        @Around("@annotation(ysh.aop.order.aop.member.annotation.MethodAop)")
        public Object doAtAnnotation(ProceedingJoinPoint joinPoint) throws Throwable{
            log.info("[@annotation {}", joinPoint.getSignature());
            return joinPoint.proceed();
        }
    }
}
