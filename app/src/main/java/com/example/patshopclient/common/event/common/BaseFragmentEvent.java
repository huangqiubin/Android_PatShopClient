package com.example.patshopclient.common.event.common;

import com.example.patshopclient.common.event.BaseEvent;

public class BaseFragmentEvent<T> extends BaseEvent<T> {
    public BaseFragmentEvent(int code) {
        super(code);
    }
}
