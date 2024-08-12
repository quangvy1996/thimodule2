package model;

import java.time.LocalDate;

public abstract class BankAccount {
    private String id;
    private String accountNumber;
    private String customerName;
    private String accountDate;
    public BankAccount(String accountDate, String customerName, String accountNumber, String id) {
        this.accountDate = accountDate;
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountDate() {
        return accountDate;
    }

    public void setAccountDate(String accountDate) {
        this.accountDate = accountDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id='" + id + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", customerName='" + customerName + '\'' +
                ", accountDate=" + accountDate +
                '}';
    }
}
