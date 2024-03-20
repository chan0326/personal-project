package com.erichgamma.api.account;

public interface AccountService {

    String deposit(Account account);
    String withdraw(Account account);
    String getBalance(String accountNumber);



}
