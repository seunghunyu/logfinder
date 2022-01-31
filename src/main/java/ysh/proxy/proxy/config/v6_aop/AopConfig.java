package ysh.proxy.proxy.config.v6_aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ysh.logfinder.trace.logtrace.LogTrace;
import ysh.proxy.proxy.config.AppV1Config;
import ysh.proxy.proxy.config.AppV2Config;
import ysh.proxy.proxy.config.v6_aop.aspect.LogTraceAspect;

@Configuration
@Import({AppV1Config.class, AppV2Config.class})
public class AopConfig {
    @Bean
    public LogTraceAspect logTraceAspect(LogTrace logTrace){
        return new LogTraceAspect(logTrace);
    }
}
