package ysh.logfinder.app.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ysh.logfinder.trace.TraceStatus;
import ysh.logfinder.trace.logtrace.LogTraceV1;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV1 {
    private final LogTraceV1 trace;

    public void save(String itemId){
        TraceStatus status = null;

        try{
            status = trace.begin("OrderRepository.save()");

            //저장로직
            if(itemId.equals("ex")){
                throw new IllegalStateException("예외발생!");
            }
            sleep(1000);

            trace.end(status);
        }catch(Exception e){
            trace.exception(status,e);
            throw e;//예외를 꼭 다시 던져주어야 한다.
        }
    }

    private void sleep(int millis) {
        try{
            Thread.sleep(millis);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

}
