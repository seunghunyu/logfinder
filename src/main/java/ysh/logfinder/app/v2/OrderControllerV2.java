package ysh.logfinder.app.v2;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ysh.logfinder.app.v0.OrderServiceV0;
import ysh.logfinder.trace.TraceStatus;
import ysh.logfinder.trace.logtrace.LogTraceV1;
import ysh.logfinder.trace.logtrace.LogTraceV2;

@RestController
//@RestController = @Controller + @ResponseBody
@RequiredArgsConstructor
public class OrderControllerV2 {
    private final OrderServiceV2 orderService;
    private final LogTraceV2 trace;


    @GetMapping("/v2/request")
    public String request(String itemId){

        TraceStatus status = null;

        try{
            status = trace.begin("OrderController.request()");
            orderService.orderItem(status.getTraceId(), itemId);
            trace.end(status);
        }catch(Exception e){
            trace.exception(status,e);
            throw e;//예외를 꼭 다시 던져주어야 한다.
        }

        return "ok";
    }

}
