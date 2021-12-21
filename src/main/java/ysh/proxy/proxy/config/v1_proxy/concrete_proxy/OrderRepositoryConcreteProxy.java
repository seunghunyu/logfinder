package ysh.proxy.proxy.config.v1_proxy.concrete_proxy;

import ysh.logfinder.trace.logtrace.LogTrace;
import ysh.proxy.proxy.app.v2.OrderRepositoryV2;

public class OrderRepositoryConcreteProxy extends OrderRepositoryV2 {
    private final OrderRepositoryV2 target;
    private final LogTrace trace;

    public OrderRepositoryConcreteProxy(OrderRepositoryV2 target, LogTrace trace) {
        this.target = target;
        this.trace = trace;
    }

    @Override
    public void save(String itemId) {
        super.save(itemId);
    }
}
