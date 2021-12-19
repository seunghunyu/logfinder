package ysh.proxy.pureproxy.concreteproxy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import ysh.proxy.pureproxy.concreteproxy.code.ConcreteClient;
import ysh.proxy.pureproxy.concreteproxy.code.ConcreteLogic;
import ysh.proxy.pureproxy.concreteproxy.code.TimeProxy;

@Slf4j
public class ConcreteProxyTest {
    @Test
    void noProxy(){
        ConcreteLogic concreteLogic = new ConcreteLogic();
        ConcreteClient client = new ConcreteClient(concreteLogic);
        client.execute();
    }

    @Test
    void addProxy(){
        ConcreteLogic concreteLogic = new ConcreteLogic();
        TimeProxy timeProxy = new TimeProxy(concreteLogic);
        ConcreteClient client = new ConcreteClient(timeProxy);
        client.execute();
    }
}
