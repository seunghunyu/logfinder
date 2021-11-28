package ysh.logfinder.trace.strategy.code.template;

import lombok.extern.slf4j.Slf4j;
import ysh.logfinder.trace.strategy.code.strategy.Strategy;

@Slf4j
public class TimeLogTemplate {
    public void  execute(CallBack callBack){
        long startTime = System.currentTimeMillis();
        //비지니스 로직 실행
        callBack.call(); //위임
        //비지니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}",resultTime);
    }
}
