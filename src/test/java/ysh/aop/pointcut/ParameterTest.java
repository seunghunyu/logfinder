package ysh.aop.pointcut;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ysh.aop.order.aop.member.MemberService;

@Slf4j
@SpringBootTest
public class ParameterTest {
    @Autowired
    MemberService memberService;

    @Test
    void success(){
        log.info("memberService Proxy={}", memberService.getClass());
    }

    @Slf4j
    @Aspect
    static class ParameterAspect{
        @Pointcut("execution(* ysh.aop.member..*.*(..))")
        private void allMember(){}
        @Around("allMember()")
        public Object logArgs1(ProceedingJoinPoint joinPoint) throws Throwable {
            Object arg1 = joinPoint.getArgs()[0];
            log.info("[logArgs]{}, args={}", joinPoint.getSignature(), arg1);
            return joinPoint.proceed();
        }
    }

}
