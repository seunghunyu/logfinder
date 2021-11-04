package ysh.logfinder.app.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV1 {
    private final OrderRepositoryV1 orderRepository; //의존성 주입

    /* @RequiredArgsConstructor 사용시 의존성주입과 생성자를 만들어줌
    @Autowired
    public OrderService(OrderRepositoryV0 orderRepository){
        this.orderRepository = orderRepository;
    }
    */
    public void orderItem(String itemId){
        orderRepository.save(itemId);
    }
}
