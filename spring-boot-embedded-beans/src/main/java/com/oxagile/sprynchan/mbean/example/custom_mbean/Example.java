package com.oxagile.sprynchan.mbean.example.custom_mbean;

import org.springframework.jmx.export.annotation.*;
import org.springframework.stereotype.Component;

import javax.management.AttributeChangeNotification;

/**
 * Created by kirylsprynchan on 19.07.17.
 */
@Component
@ManagedResource
@ManagedNotification(name = "not name", description = "desc", notificationTypes = {AttributeChangeNotification.ATTRIBUTE_CHANGE})
public class Example {

    private String name = "Spring MBean";
    private int value;

    @ManagedAttribute()
    public String getName() {
        return name;
    }

    @ManagedAttribute()
    public Example setName(String name) {
        this.name = name;
        return this;
    }

    @ManagedAttribute()
    public int getValue() {
        return value;
    }

    @ManagedAttribute
    public Example setValue(int value) {
        this.value = value;
        return this;
    }

    @ManagedOperation(description="Add two numbers")
    @ManagedOperationParameters({
            @ManagedOperationParameter(name = "x", description = "The first number"),
            @ManagedOperationParameter(name = "y", description = "The second number")})
    public int add(int x, int y) {
        return x + y;
    }
}
