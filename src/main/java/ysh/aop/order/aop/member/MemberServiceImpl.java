package ysh.aop.order.aop.member;

import org.springframework.stereotype.Component;
import ysh.aop.order.aop.member.annotation.ClassAop;
import ysh.aop.order.aop.member.annotation.MethodAop;

@ClassAop
@Component
public class MemberServiceImpl implements MemberService{

    @Override
    @MethodAop("test Value")
    public String Hello(String param) {
        return "ok";
    }

    public String internal(String param){
        return "ok";
    }

}
