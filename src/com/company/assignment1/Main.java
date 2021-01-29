package com.company.assignment1;

public class Main {

    public static void main(String[] args) {
        // Question 1
        System.out.println("Question 1:");
        Complex c1 = new Complex(2, 3);
        Complex c2 = new Complex(8, 5);
        Complex c3 = new Complex();
        Complex c4 = new Complex();
        c3 = c1.add(c2);
        System.out.println(c3);
        c4 = c1.multiply(c2);
        System.out.println(c4);

        // Question 2
        System.out.printf("\n\nQuestion 2:\n");
        Bank myBank = new Bank();
        // my first paycheck
        myBank.deposit(9000.0, "C");
        // transfer 7000 to saving account
        myBank.transfer(7000.0, "C");
        // pay the rent
        myBank.withdraw(1500.0, "C");
        // transfer 2000 to saving account with penalty
        myBank.transfer(2000, "C");
        myBank.printBalances();
    }
}

