package com.oxagile.kiryl_sprynchan.example.dynamic;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

/**
 * Created by kirylsprynchan on 12.07.17.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();

        mBeanServer.registerMBean(new SimpleDynamic(), new ObjectName("com.oxagile.kiryl_sprynchan.example:type=Dynamic"));

        System.out.println("Waiting forever...");
        Thread.sleep(Long.MAX_VALUE);
    }
}
