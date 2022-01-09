package com.perso.accountcqrses.common.events;

import com.perso.accountcqrses.common.models.enums.AccountStatus;
import lombok.Getter;

@Getter
public class AccountActivatedEvent extends BaseEvent<String> {

    private final AccountStatus status;

    public AccountActivatedEvent(String id, AccountStatus status) {
        super(id);
        this.status = status;
    }

}
