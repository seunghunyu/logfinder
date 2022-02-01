package ysh.logfinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import ysh.logfinder.trace.logtrace.LogTrace;
import ysh.logfinder.trace.logtrace.ThreadLocalLogTrace;
import ysh.proxy.proxy.config.v1_proxy.InterfaceProxyConfig;

@Import(InterfaceProxyConfig.class)
@SpringBootApplication
public class LogfinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogfinderApplication.class, args);
	}
	@Bean
	public LogTrace logTrace(){
		return new ThreadLocalLogTrace();
	}

}
