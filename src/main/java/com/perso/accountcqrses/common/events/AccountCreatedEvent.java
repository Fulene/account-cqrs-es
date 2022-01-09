package com.perso.accountcqrses.common.events;

import lombok.Getter;

@Getter
public class AccountCreatedEvent extends BaseEvent<String> {

    private final double initialBalance;
    private final String currency;

    public AccountCreatedEvent(String id, double initialBalance, String currency) {
        super(id);
        this.initialBalance = initialBalance;
        this.currency = currency;
    }
}
