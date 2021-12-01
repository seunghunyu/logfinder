package ysh.proxy.proxy.app.v1;

public class OrderControllerV1Impl implements OrderControllerV1{
    private final OrderService1 orderService1;

    public OrderControllerV1Impl(OrderService1 orderService1) {
        this.orderService1 = orderService1;
    }

    @Override
    public String request(String itemId) {
        orderService1.orderItem(itemId);
        return "ok";
    }

    @Override
    public String noLog() {
        return "ok";
    }
}
