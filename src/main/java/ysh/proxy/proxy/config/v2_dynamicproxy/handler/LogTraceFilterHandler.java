package ysh.proxy.proxy.config.v2_dynamicproxy.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;
import ysh.logfinder.trace.TraceStatus;
import ysh.logfinder.trace.logtrace.LogTrace;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Slf4j
public class LogTraceFilterHandler implements InvocationHandler {
    private final Object target;
    private final LogTrace logTrace;
    private String[] patterns;
    public LogTraceFilterHandler(Object target, LogTrace logTrace, String[] patterns) {
        this.target = target;
        this.logTrace = logTrace;
        this.patterns = patterns;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //메서드 이름필터
        String methodName = method.getName();
        //save, request, reque*, *est
        if(!PatternMatchUtils.simpleMatch(patterns,methodName)){
            return method.invoke(target,args);
        }


        TraceStatus status = null;
        try{
            String message = method.getDeclaringClass().getSimpleName() + "." +
                    method.getName() + "()";

            status = logTrace.begin(message);
            //로직 호출
            Object result = method.invoke(this.target, args);
            logTrace.end(status);

            return result;

        }catch(Exception e){
            logTrace.exception(status, e);
            throw e;
        }

    }
}
