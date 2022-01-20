package ysh.proxy.postprocessor;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BasicTest {
    @Test
    void basicConfig(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext();
    }

}
