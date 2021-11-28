package ysh.logfinder.app.v5;

import org.springframework.stereotype.Service;
import ysh.logfinder.trace.callback.TraceCallback;
import ysh.logfinder.trace.callback.TraceTemplate;
import ysh.logfinder.trace.logtrace.LogTrace;
import ysh.logfinder.trace.template.AbstractTemplate;

@Service
public class OrderServiceV5 {
    private final OrderRepositoryV5 orderRepository; //의존성 주입
    private final TraceTemplate template;

    public OrderServiceV5(OrderRepositoryV5 orderRepository, LogTrace trace) {
        this.orderRepository = orderRepository;
        this.template = new TraceTemplate(trace);
    }

    public void orderItem(String itemId){
        template.execute("OrderService.orderItem()", () -> {
            orderRepository.save(itemId);
            return null;
        });
    }
}
