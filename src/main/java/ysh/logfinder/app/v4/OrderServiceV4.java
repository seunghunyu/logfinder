package ysh.logfinder.app.v4;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ysh.logfinder.trace.TraceStatus;
import ysh.logfinder.trace.logtrace.LogTrace;

@Service
@RequiredArgsConstructor
public class OrderServiceV4 {
    private final OrderRepositoryV4 orderRepository; //의존성 주입
    private final LogTrace trace;

    public void orderItem(String itemId){
        TraceStatus status = null;
        try{
            status = trace.begin("OrderService.orderItem()");
            orderRepository.save(status.getTraceId(),itemId);
            trace.end(status);
        }catch(Exception e){
            trace.exception(status, e);
            throw e;
        }
        orderRepository.save(status.getTraceId(), itemId);
    }
}
