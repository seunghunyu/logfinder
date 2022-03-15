package ysh.aop.internalcall;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import ysh.aop.internalcall.aop.CallLogAspect;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@Import(CallLogAspect.class)
@SpringBootTest
class CallServiceVOTest {
    @Autowired CallServiceVO callServiceVO;

    @Test
    void external(){
        callServiceVO.external();
    }

    @Test
    void internal(){
        callServiceVO.internal();
    }
}