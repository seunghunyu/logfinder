package ysh.logfinder.app.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ysh.logfinder.app.v0.OrderServiceV0;

@RestController
//@RestController = @Controller + @ResponseBody
@RequiredArgsConstructor
public class OrderControllerV1 {
    private final OrderServiceV0 orderService;

    @GetMapping("/v1/request")
    public String request(String itemId){
        orderService.orderItem(itemId);
        return "ok";
    }

}
