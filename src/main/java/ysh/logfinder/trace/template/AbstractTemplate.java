package ysh.logfinder.trace.template;

import ysh.logfinder.trace.TraceStatus;
import ysh.logfinder.trace.logtrace.LogTrace;

public abstract class AbstractTemplate<T> {

    private final LogTrace trace;

    protected AbstractTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public T execute(String message){
        TraceStatus status = null;
        try{
            status = trace.begin(message);
            //로직호출
            T result = call();
            trace.end(status);
            return result;
        }catch(Exception e){
            trace.exception(status, e);
            throw e;
        }

    }

    protected abstract T call();

}
