package ysh.logfinder.app.v5;

import org.springframework.stereotype.Repository;
import ysh.logfinder.trace.callback.TraceTemplate;
import ysh.logfinder.trace.logtrace.LogTrace;
import ysh.logfinder.trace.template.AbstractTemplate;

@Repository
public class OrderRepositoryV5 {
    private final TraceTemplate template;

    public OrderRepositoryV5(LogTrace trace) {
        this.template = new TraceTemplate(trace);
    }


    public void save(String itemId){

        template.execute("OrderRepository.save()",()->{
            //저장로직
            if(itemId.equals("ex")){
                throw new IllegalStateException("예외발생!");
            }
            sleep(1000);
            return null;
        });

    }

    private void sleep(int millis) {
        try{
            Thread.sleep(millis);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

}
