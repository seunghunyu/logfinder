package ysh.logfinder.app.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ysh.logfinder.app.v0.OrderServiceV0;
import ysh.logfinder.trace.TraceId;
import ysh.logfinder.trace.TraceStatus;
import ysh.logfinder.trace.logtrace.LogTraceV1;

@RestController
//@RestController = @Controller + @ResponseBody
@RequiredArgsConstructor
public class OrderControllerV1 {
    private final OrderServiceV1 orderService;
    private final LogTraceV1 trace;


    @GetMapping("/v1/request")
    public String request(String itemId){

        TraceStatus status = null;

        try{
            status = trace.begin("OrderController.request()");
            orderService.orderItem(itemId);
            trace.end(status);
        }catch(Exception e){
            trace.exception(status,e);
            throw e;//예외를 꼭 다시 던져주어야 한다.
        }

        return "ok";
    }

}
