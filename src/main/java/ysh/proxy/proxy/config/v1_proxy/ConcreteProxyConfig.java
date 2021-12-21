package ysh.proxy.proxy.config.v1_proxy;

import org.springframework.context.annotation.Bean;
import ysh.logfinder.trace.logtrace.LogTrace;
import ysh.proxy.proxy.app.v2.OrderControllerV2;
import ysh.proxy.proxy.app.v2.OrderRepositoryV2;
import ysh.proxy.proxy.app.v2.OrderServiceV2;
import ysh.proxy.proxy.config.v1_proxy.concrete_proxy.OrderControllerConcreteProxy;
import ysh.proxy.proxy.config.v1_proxy.concrete_proxy.OrderRepositoryConcreteProxy;
import ysh.proxy.proxy.config.v1_proxy.concrete_proxy.OrderServiceConcreteProxy;

public class ConcreteProxyConfig {
    @Bean
    public OrderControllerV2 orderControllerV2(LogTrace logTrace){
        OrderControllerV2 controllerImpl = new OrderControllerV2(orderServiceV2(logTrace));
        return new OrderControllerConcreteProxy(controllerImpl, logTrace);
    }
    @Bean
    public OrderServiceV2 orderServiceV2(LogTrace logTrace){
        OrderServiceV2 serviceImpl = new OrderServiceV2(orderRepositoryV2(logTrace));
        return new OrderServiceConcreteProxy(serviceImpl, logTrace);
    }
    @Bean
    public OrderRepositoryV2 orderRepositoryV2(LogTrace logTrace){
        OrderRepositoryV2 repositoryImpl = new OrderRepositoryV2();
        return new OrderRepositoryConcreteProxy(repositoryImpl, logTrace);
    }

}
