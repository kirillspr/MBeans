package com.oxagile.kiryl_sprynchan.example.standard;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class Main {

    public static void main(String[] args) throws Exception {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();

        mBeanServer.registerMBean(new Standard(), new ObjectName("com.oxagile.kiryl_sprynchan.example:type=Standard"));

        System.out.println("Waiting forever...");
        Thread.sleep(Long.MAX_VALUE);
    }

}
