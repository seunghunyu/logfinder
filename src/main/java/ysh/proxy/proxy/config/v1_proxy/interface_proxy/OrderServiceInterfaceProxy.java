package ysh.proxy.proxy.config.v1_proxy.interface_proxy;

import lombok.RequiredArgsConstructor;
import ysh.logfinder.app.v1.OrderServiceV1;
import ysh.logfinder.trace.TraceStatus;
import ysh.logfinder.trace.logtrace.LogTrace;
import ysh.proxy.proxy.app.v1.OrderRepositoryV1;
import ysh.proxy.proxy.app.v1.OrderService1;
@RequiredArgsConstructor
public class OrderServiceInterfaceProxy implements OrderService1 {

    private final OrderServiceV1 target;
    private final LogTrace logTrace;

    @Override
    public void orderItem(String itemId) {
        TraceStatus status = null;
        try{
            status = logTrace.begin("OrderService.orderItem()");
            //target호출
            target.orderItem(itemId);
            logTrace.end(status);
        }catch(Exception e){
            logTrace.exception(status,e);
            throw e;
        }
    }
}
