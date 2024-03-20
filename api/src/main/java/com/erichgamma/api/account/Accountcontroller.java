package com.erichgamma.api.account;




import com.erichgamma.api.enums.Message;

import java.util.List;
import java.util.Scanner;

public class Accountcontroller {
    private static Accountcontroller instance = new Accountcontroller();
     AcoountServiceImpl as ;

    public Accountcontroller() {
        this.as = AcoountServiceImpl.getInstance();
    }

    public static Accountcontroller getinstance() {
        return instance;
    }


    public Message createAccount(Scanner sc) {
        System.out.println("생성할 계좌의 id를 입력하세요\n"+
                "이름을 입력하세요\n"+
                "게좌번호를 입럭세요\n" +
                "잔고를 입력하세요(0원으로 자동입력)\n"+
                "생성날짜를 입력하세요\n");
        return as.save(Account.builder()
                        .id(sc.nextLong())
                .accountHolder(sc.next())
                .accountNumber(sc.next())
                        .balance(0)
                        .transactionDate(null)
                .build());
    }

    public String deposit(Scanner sc) {
        System.out.println("인출한 계좌의 id를 입력하세요");
        System.out.println("인출할 금액을 입력하세요");
        return as.deposit(Account.builder()
                .id(sc.nextLong())
                .accountHolder(sc.next())
                .accountNumber(sc.next())
                .balance(sc.nextDouble())
                .transactionDate(null)
                .build()
        );
    }

    public String withdraw(Scanner sc) {
        return as.withdraw(Account.builder()
                .id(sc.nextLong())
                .accountHolder(sc.next())
                .accountNumber(sc.next())
                .balance(sc.nextDouble())
                .transactionDate(null)
                .build());
    }
    public String getBalance(Scanner sc) {
        return as.getBalance(sc.next());    }

    public String deletAcoount(Scanner sc) {
        return as.delete(Account.builder().accountNumber(sc.next()).build());
    }

    public List<?> getAccount() {
        return as.findAll();
    }
}
