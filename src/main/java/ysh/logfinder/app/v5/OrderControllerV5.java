package ysh.logfinder.app.v5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ysh.logfinder.trace.callback.TraceCallback;
import ysh.logfinder.trace.callback.TraceTemplate;
import ysh.logfinder.trace.logtrace.LogTrace;
import ysh.logfinder.trace.template.AbstractTemplate;

@RestController
public class OrderControllerV5 {
    private final OrderServiceV5 orderService;
    private final TraceTemplate traceTemplate;

    @Autowired
    public OrderControllerV5(OrderServiceV5 orderService, LogTrace trace) {
        this.orderService = orderService;
        this.traceTemplate = new TraceTemplate(trace);
    }


    @GetMapping("/v5/request")
    public String request(String itemId){
        return traceTemplate.execute("OrderController.request()", new TraceCallback<>() {
            @Override
            public String call() {
                orderService.orderItem(itemId);
                return "ok";
            }
        });
    }

}
