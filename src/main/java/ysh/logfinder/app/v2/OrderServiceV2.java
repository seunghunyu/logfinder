package ysh.logfinder.app.v2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ysh.logfinder.trace.TraceId;
import ysh.logfinder.trace.TraceStatus;
import ysh.logfinder.trace.logtrace.LogTraceV2;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {
    private final OrderRepositoryV2 orderRepository; //의존성 주입
    private final LogTraceV2 trace;

    /* @RequiredArgsConstructor 사용시 의존성주입과 생성자를 만들어줌
    @Autowired
    public OrderService(OrderRepositoryV0 orderRepository){
        this.orderRepository = orderRepository;
    }
    */
    public void orderItem(TraceId traceId, String itemId){
        TraceStatus status = null;
        try{
            status = trace.beginSync(traceId,"OrderService.orderItem()");
            orderRepository.save(status.getTraceId(),itemId);
            trace.end(status);
        }catch(Exception e){
            trace.exception(status, e);
            throw e;
        }
        orderRepository.save(status.getTraceId(), itemId);
    }
}
