package ysh.proxy.proxy.config.v1_proxy.concrete_proxy;

import ysh.logfinder.trace.TraceStatus;
import ysh.logfinder.trace.logtrace.LogTrace;
import ysh.proxy.proxy.app.v2.OrderControllerV2;
import ysh.proxy.proxy.app.v2.OrderServiceV2;

public class OrderControllerConcreteProxy extends OrderControllerV2 {
    private final OrderControllerV2 target;
    private final LogTrace logTrace;

    public OrderControllerConcreteProxy(OrderControllerV2 target, LogTrace logTrace) {
        super(null);
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public String request(String itemId) {
        TraceStatus status=null;
        try{
            status = logTrace.begin("OrderController.request()");
            //target호출
            String result = target.request(itemId);
            logTrace.end(status);
            return result;
        }catch(Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }

    @Override
    public String noLog() {
        return target.noLog();
    }
}
