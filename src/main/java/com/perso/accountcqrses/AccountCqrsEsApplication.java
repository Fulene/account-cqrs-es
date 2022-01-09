package com.perso.accountcqrses;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccountCqrsEsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AccountCqrsEsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
