package ysh.logfinder.app.v3;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ysh.logfinder.trace.TraceId;
import ysh.logfinder.trace.TraceStatus;
import ysh.logfinder.trace.logtrace.LogTrace;
import ysh.logfinder.trace.logtrace.LogTraceV2;

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {
    private final OrderRepositoryV3 orderRepository; //의존성 주입
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
