package ysh.logfinder.app.v3;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ysh.logfinder.trace.TraceStatus;
import ysh.logfinder.trace.logtrace.LogTrace;
import ysh.logfinder.trace.logtrace.LogTraceV2;

@RestController
//@RestController = @Controller + @ResponseBody
@RequiredArgsConstructor
public class OrderControllerV3 {
    private final OrderServiceV3 orderService;
    private final LogTrace trace;


    @GetMapping("/v3/request")
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
