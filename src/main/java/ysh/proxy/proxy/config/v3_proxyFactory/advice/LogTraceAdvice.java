package ysh.proxy.proxy.config.v3_proxyFactory.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import ysh.logfinder.trace.logtrace.LogTrace;

public class LogTraceAdvice implements MethodInterceptor {
    private final LogTrace logTrace;
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        return null;
    }
}
