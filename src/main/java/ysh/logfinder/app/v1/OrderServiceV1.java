package ysh.logfinder.app.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ysh.logfinder.trace.TraceStatus;
import ysh.logfinder.trace.logtrace.LogTraceV1;

@Service
@RequiredArgsConstructor
public class OrderServiceV1 implements ysh.proxy.proxy.app.v1.OrderServiceV1 {
    private final OrderRepositoryV1 orderRepository; //의존성 주입
    private final LogTraceV1 trace;
    /* @RequiredArgsConstructor 사용시 의존성주입과 생성자를 만들어줌
    @Autowired
    public OrderService(OrderRepositoryV0 orderRepository){
        this.orderRepository = orderRepository;
    }
    */
    public void orderItem(String itemId){
        TraceStatus status = null;
        try{
            status = trace.begin("OrderService.orderItem()");
            orderRepository.save(itemId);
            trace.end(status);
        }catch(Exception e){
            trace.exception(status, e);
            throw e;
        }
        orderRepository.save(itemId);
    }
}
