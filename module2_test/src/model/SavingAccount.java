package model;

import java.time.LocalDate;

public class SavingAccount extends BankAccount {
    private double deposit;
    String depositDate;
    private double interest;
    private int term;
    public SavingAccount(String accountDate, String customerName, String accountNumber, String id, double deposit,String depositDate, double interest, int term) {
        super(accountDate, customerName, accountNumber, id);
        this.deposit = deposit;
        this.depositDate = depositDate;
        this.interest = interest;
        this.term = term;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public String getDepositDate() {
        return depositDate;
    }

    public void setDepositDate(String depositDate) {
        this.depositDate = depositDate;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public String getInfoCSVToCSV(){
        return super.getId() + "," + super.getAccountNumber() + "," + super.getCustomerName() + "," + getAccountDate() + "," + getDeposit() + "," + getAccountDate() + "," + getInterest() + "," + getTerm();
    }


    @Override
    public String toString() {
        return "SavingAccount{" + super.toString()+
                "deposit=" + deposit +
                ", depositDate=" + depositDate +
                ", interest=" + interest +
                ", term=" + term +
                '}';
    }
}
