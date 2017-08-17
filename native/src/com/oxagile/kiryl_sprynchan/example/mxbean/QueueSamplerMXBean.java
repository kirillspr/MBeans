package com.oxagile.kiryl_sprynchan.example.mxbean;


//@MXBean or you can use old specification.
public interface QueueSamplerMXBean {

    MyQueue getQueueSample();

    void clearQueue();

}
