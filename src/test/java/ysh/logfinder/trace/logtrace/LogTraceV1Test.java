package ysh.logfinder.trace.logtrace;

import org.junit.jupiter.api.Test;
import ysh.logfinder.trace.TraceStatus;

public class LogTraceV1Test {

    @Test
    void begin_end(){
        LogTraceV1 trace = new LogTraceV1();
        TraceStatus status = trace.begin("hello");
    }

    @Test
    void begin_exception(){
        LogTraceV1 trace = new LogTraceV1();
        TraceStatus status = trace.begin("hello");
        trace.exception(status, new IllegalStateException());
    }

}
