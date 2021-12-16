package ysh.proxy.proxy.config.v1_proxy.interface_proxy;

import lombok.RequiredArgsConstructor;
import ysh.logfinder.trace.TraceStatus;
import ysh.logfinder.trace.logtrace.LogTrace;
import ysh.logfinder.trace.logtrace.LogTraceV1;
import ysh.proxy.proxy.app.v1.OrderRepositoryV1;

@RequiredArgsConstructor
public class OrderRepositoryInterfaceProxy implements OrderRepositoryV1 {
    private final OrderRepositoryV1 target;
    private final LogTrace logTrace;
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
