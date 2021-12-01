package ysh.proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import ysh.logfinder.LogfinderApplication;
import ysh.proxy.proxy.config.AppV1Config;
import ysh.proxy.proxy.config.AppV2Config;

//@Import(AppV1Config.class)
//@Import(AppV2Config.class)
@Import({AppV1Config.class, AppV2Config.class})
@SpringBootApplication(scanBasePackages = "ysh.proxy.app") //주의
public class ProxyApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProxyApplication.class, args);
    }
}

/**
 * AppV1Config 파일내에 @Configuration 어노테이션은 내부에 @Component 어노테이션을 포함하고있어서 컴포넌트 스캔대상이된다.
 * 따라서 컴포넌트 스캔에의해 'hello.proxy.config' 위치의 설정 파일들이 스프링빈으로 자동 등록 되지않도록 컴포넌트 스캔의 시작위치를
 * 'scanBasePackages=hello.proxy.app' 으로 설정
 * */

