package ysh.logfinder.trace.strategy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import ysh.logfinder.trace.strategy.code.template.CallBack;
import ysh.logfinder.trace.strategy.code.template.TimeLogTemplate;

@Slf4j
public class TemplateCallBackTest {
    /**
     * 템플릿 콜백 패턴 - 익명 내부 클래스
     */
    @Test
    void callbackV1(){
        TimeLogTemplate template = new TimeLogTemplate();
        template.execute(new CallBack() {
            @Override
            public void call() {
                log.info("비지니스 로직1 실행");
            }
        });
        template.execute(new CallBack() {
            @Override
            public void call() {
                log.info("비지니스 로직2 실행");
            }
        });
    }

    /**
     * 템플릿 콜백 패턴 - 람다
     */
    @Test
    void callbackV2(){
        TimeLogTemplate template = new TimeLogTemplate();
        template.execute(()->log.info("비지니스 로직1 실행"));
        template.execute(()->log.info("비지니스 로직2 실행"));
    }
}
