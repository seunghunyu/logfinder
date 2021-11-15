package ysh.logfinder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ysh.logfinder.trace.logtrace.FieldLogTrace;
import ysh.logfinder.trace.logtrace.LogTrace;
import ysh.logfinder.trace.logtrace.ThreadLocalLogTrace;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace(){
//        return new FieldLogTrace();
        return new ThreadLocalLogTrace();
    }

}