package ysh.logfinder.trace.logtrace;

import org.junit.jupiter.api.Test;
import ysh.logfinder.trace.TraceStatus;

import static org.junit.jupiter.api.Assertions.*;

class LogTraceV2Test {

    @Test
    void begin_end(){
        LogTraceV2 trace = new LogTraceV2();
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.beginSync(status1.getTraceId(), "hello2");

        trace.end(status2);
        trace.end(status1);
    }

    @Test
    void begin_exception(){
        LogTraceV2 trace = new LogTraceV2();
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.beginSync(status1.getTraceId(), "hello2");
        trace.exception(status2, new IllegalStateException());
        trace.exception(status1, new IllegalStateException());
    }

}