package com.oxagile.kiryl_sprynchan.example.mxbean;

import java.util.Date;
import java.util.Queue;

public class QueueSampler implements QueueSamplerMXBean {

    private Queue<String> queue;

    public QueueSampler(Queue<String> queue) {
        this.queue = queue;
    }

    public MyQueue getQueueSample() {
        synchronized (queue) {
            return new MyQueue(new Date(), queue.size(), queue.peek());
        }
    }

    public void clearQueue() {
        synchronized (queue) {
            queue.clear();
        }
    }
}

