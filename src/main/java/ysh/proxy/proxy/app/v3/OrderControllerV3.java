package ysh.proxy.proxy.app.v3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@RequestMapping
@ResponseBody
public class OrderControllerV3 {
    private final OrderServiceV3 orderServiceV3;

    public OrderControllerV3(OrderServiceV3 orderServiceV3) {
        this.orderServiceV3 = orderServiceV3;
    }

    @GetMapping("/v2/request")
    public String request(String itemId) {
        orderServiceV3.orderItem(itemId);
        return "ok";
    }

    @GetMapping("/v2/no-log")
    public String noLog()
    {
        return "ok";
    }
}
