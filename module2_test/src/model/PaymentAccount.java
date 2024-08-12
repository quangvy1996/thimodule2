package model;

import java.time.LocalDate;

public class PaymentAccount extends BankAccount {
    private String cardID;
    private double balance;
    public PaymentAccount(String accountDate, String customerName, String accountNumber, String id, String cardID, double balance) {
        super(accountDate, customerName, accountNumber, id);
        this.cardID = cardID;
        this.balance = balance;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public String getInfoToCSV(){
        return super.getId() + "," + super.getAccountNumber() + "," + super.getCustomerName() + "," + super.getAccountDate() + "," + getCardID() + "," + getBalance();
    }
    @Override
    public String toString() {
        return "PaymentAccount{" +super.toString() +
                "cardID='" + cardID + '\'' +
                ", balance=" + balance +
                '}';
    }
}
