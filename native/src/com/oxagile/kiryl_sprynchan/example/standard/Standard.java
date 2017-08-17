package com.oxagile.kiryl_sprynchan.example.standard;

import javax.management.AttributeChangeNotification;
import javax.management.MBeanNotificationInfo;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

//To create Mbean not necessary to extend NotificationBroadcasterSupport.
public class Standard extends NotificationBroadcasterSupport implements StandardMBean {

    private String name = "Oxa Standard MBean";

    private int number;

    private long sequenceNumber = 1;

    @Override
    public void sayHello() {
        System.out.println("hello, world");
    }

    @Override
    public int add(int x, int y) {
        return x + y;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getNumber() {
        return this.number;
    }

    @Override
    public synchronized void setNumber(int size) {
        int oldSize = this.number;

        this.number = size;
        System.out.println("Cache size now " + this.number);

        Notification n = new AttributeChangeNotification(
                this,
                sequenceNumber++,
                System.currentTimeMillis(),
                "CacheSize changed",
                "CacheSize",
                "int",
                oldSize,
                this.number);

        sendNotification(n);
    }

    @Override
    public MBeanNotificationInfo[] getNotificationInfo() {
        String[] types = new String[]{AttributeChangeNotification.ATTRIBUTE_CHANGE};

        String name = AttributeChangeNotification.class.getName();
        String description = "An attribute of this MBean has changed";

        MBeanNotificationInfo info = new MBeanNotificationInfo(types, name, description);

        return new MBeanNotificationInfo[]{info};
    }

}
