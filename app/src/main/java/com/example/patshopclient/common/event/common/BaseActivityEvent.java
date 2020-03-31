package com.example.patshopclient.common.event.common;


import com.example.patshopclient.common.event.BaseEvent;

public class BaseActivityEvent<T> extends BaseEvent<T> {
    public BaseActivityEvent(int code) {
        super(code);
    }
}
