package ysh.proxy.pureproxy.concreteproxy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import ysh.proxy.pureproxy.concreteproxy.code.ConcreteClient;
import ysh.proxy.pureproxy.concreteproxy.code.ConcreteLogic;

@Slf4j
public class ConcreteProxyTest {
    @Test
    void noProxy(){
        ConcreteLogic concreteLogic = new ConcreteLogic();
        ConcreteClient client = new ConcreteClient(concreteLogic);
        client.execute();
    }

}
