package service.payment_account_service;

import model.PaymentAccount;

import java.util.List;

public interface IPaymentAccountService {
    List<PaymentAccount> findAll();
    void addPaymentAccount(PaymentAccount paymentAccount);
    void deletePaymentAccount(String cardID);
    PaymentAccount findPaymentAccountById(String id);
    PaymentAccount searchPaymentAccountByName(String name);
}
