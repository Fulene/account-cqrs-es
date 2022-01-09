package com.perso.accountcqrses.common.events;

import lombok.Getter;

public abstract class BaseEvent<T> {

    @Getter
    private final T id;

    public BaseEvent(T id) {
        this.id = id;
    }
}
