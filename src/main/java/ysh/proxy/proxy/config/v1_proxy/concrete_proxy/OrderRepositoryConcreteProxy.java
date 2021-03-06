package ysh.proxy.proxy.config.v1_proxy.concrete_proxy;

import ysh.logfinder.trace.TraceStatus;
import ysh.logfinder.trace.logtrace.LogTrace;
import ysh.proxy.proxy.app.v2.OrderRepositoryV2;

public class OrderRepositoryConcreteProxy extends OrderRepositoryV2 {
    private final OrderRepositoryV2 target;
    private final LogTrace logTrace;

    public OrderRepositoryConcreteProxy(OrderRepositoryV2 target, LogTrace logTrace) {
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public void save(String itemId) {
        TraceStatus status = null;
        try{
            status = logTrace.begin("OrderRepository.request()");
            //target호출
            target.save(itemId);
            logTrace.end(status);
        }catch(Exception e){
            logTrace.exception(status,e);
            throw e;
        }
    }
}
