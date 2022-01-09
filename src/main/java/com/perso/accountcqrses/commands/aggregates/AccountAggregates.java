package com.perso.accountcqrses.commands.aggregates;

import com.perso.accountcqrses.common.commands.CreateAccountCommand;
import com.perso.accountcqrses.common.events.AccountActivatedEvent;
import com.perso.accountcqrses.common.events.AccountCreatedEvent;
import com.perso.accountcqrses.common.models.enums.AccountStatus;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@NoArgsConstructor
@Aggregate
public class AccountAggregates {

    @AggregateIdentifier
    private String accountId;
    private double balance;
    private String currency;
    private AccountStatus status;


    /**
     * Fonction de décision
     * @param createAccountCommand
     */
    @CommandHandler
    public AccountAggregates(CreateAccountCommand createAccountCommand) {
        if (createAccountCommand.getInitialBalance() < 0)
            throw new RuntimeException("Impossible de créer un compte avec un solde négatif");

        AggregateLifecycle.apply(new AccountCreatedEvent(
                createAccountCommand.getId(),
                createAccountCommand.getInitialBalance(),
                createAccountCommand.getCurrency()
        ));
    }

    /**
     * Fonction d'évolution
     * @param event
     */
    @EventSourcingHandler
    public void on(AccountCreatedEvent event) {
        accountId = event.getId();
        balance = event.getInitialBalance();
        currency = event.getCurrency();
        status = AccountStatus.CREATED;

        AggregateLifecycle.apply(new AccountActivatedEvent(
                event.getId(),
                AccountStatus.ACTIVATED
        ));
    }

    @EventSourcingHandler
    public void on(AccountActivatedEvent event) {
        status = event.getStatus();
    }

}
