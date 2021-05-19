package com.bsoft.office.common.TimeConsumer;

public class TimeConsumer {
    private long times;
    public TimeConsumer(){
        times = System.currentTimeMillis();
    }

    public static TimeConsumer start(){
        return new TimeConsumer();
    }

    public long end(){
        return System.currentTimeMillis() - times;
    }
}
