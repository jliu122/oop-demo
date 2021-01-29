package com.company.assignment1;

class Bank {
    private String SAVING_ACCOUNT_TYPE = "S";
    private String CHECKING_ACCOUNT_TYPE = "C";

    private Account saving;
    private Account checking;

    // open bank accounts with zero money
    public Bank() {
        saving = new Account();
        checking = new Account();
    }

    // deposit positive amount of value into a valid account
    public void deposit(double amount, String account) {
        if (!validityCheck(amount, account)) {
            return;
        }
        if (account.equals(SAVING_ACCOUNT_TYPE)) {
            this.saving.add(amount);
        } else {
            this.checking.add(amount);
        }
    }

    // withdraw positive amount of value from a valid account
    public void withdraw(double amount, String account) {
        if (!validityCheck(amount, account)) {
            return;
        }
        if (account.equals(SAVING_ACCOUNT_TYPE)) {
            this.saving.withdraw(amount);
        } else {
            this.checking.withdraw(amount);
        }
    }

    // transfer positive amount of value from one valid account to another
    public void transfer(double amount, String account) {
        if (!validityCheck(amount, account)) {
            return;
        }
        if (account.equals(SAVING_ACCOUNT_TYPE)) {
            if (this.saving.withdraw(amount)) {
                this.checking.add(amount);
            }
        } else {
            if (this.checking.withdraw(amount)) {
                this.saving.add(amount);
            }
        }
    }

    // print the balance in the saving and checking accounts
    public void printBalances() {
        System.out.printf("Saving account: %f\nChecking account: %f\n", this.saving.balance, this.checking.balance);
    }

    // validity check
    private boolean validityCheck(double amount, String account) {
        // check account type
        if (!account.equals(SAVING_ACCOUNT_TYPE) && !account.equals(CHECKING_ACCOUNT_TYPE)) {
            return false;
        }
        // check deposit value
        if (amount < 0) {
            return false;
        }
        return true;
    }

    class Account {

        // account balance, can not be negative
        private double balance;

        public Account() {
            this.balance = 0;
        }

        public Account(double balance) {
            this.balance = Math.max(0.0, balance);
        }

        private void add(double amount) {
            this.balance += amount;
        }

        private boolean withdraw(double amount) {
            if (this.balance < amount) {
                // penalty
                this.balance = Math.max(0.0, this.balance - 5.0);
                return false;
            }
            this.balance -= amount;
            return true;
        }
    }
}