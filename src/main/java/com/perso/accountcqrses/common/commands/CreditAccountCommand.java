package com.perso.accountcqrses.common.commands;

public class CreditAccountCommand extends BaseCommand<String> {

    private final double amount;
    private final String currency;

    public CreditAccountCommand(String id, double amount, String currency) {
        super(id);
        this.amount = amount;
        this.currency = currency;
    }

}
