package ysh.proxy.jdkdynamic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

@Slf4j
public class ReflectionTest {
    @Test
    void reflection0(){
        Hello target = new Hello();
        //공통 로직1 시작
        log.info("start");
        String result1 = target.callA();
        log.info("result={}", result1);
        //공통 로직1 종료

        //공통 로직1 시작
        log.info("start");
        String result2 = target.callB();
        log.info("result={}", result1);
        //공통 로직1 종료
    }
    @Test
    void reflection1() throws Exception{
        //클래스정보
        Class classHello = Class.forName("ysh.proxy.jdkdynamic.ReflectionTest$Hello");

        Hello target = new Hello();
        //class A 정보
        Method methodClassA = classHello.getMethod("callA");
        dynamicCall(methodClassA,target);
        /*
        Object result1 = methodClassA.invoke(target);
        log.info("result1 = {}",result1);
        */

        //class B 정보
        Method methodClassB = classHello.getMethod("callB");
        dynamicCall(methodClassA,target);
        /*
        Object result2 = methodClassB.invoke(target);
        log.info("result2 = {}",result2);
        */
    }

    private void dynamicCall(Method method, Object target) throws Exception{
        log.info("start");
        Object result = method.invoke(target);
        log.info("result={}",result);
    }

    @Slf4j
    static class Hello{
        public String callA() {
            log.info("callA");
            return "A";
        }

        public String callB() {
            log.info("callB");
            return "B";
        }
    }
}
