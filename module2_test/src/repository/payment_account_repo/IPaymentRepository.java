package repository.payment_account_repo;

import model.PaymentAccount;

import java.util.List;

public interface IPaymentRepository {
     List<PaymentAccount> findAll();
     void addPaymentAccount(PaymentAccount paymentAccount);
     void deletePaymentAccount(String cardID);
     PaymentAccount findPaymentAccountById(String id);
     PaymentAccount searchPaymentAccountByName(String name);
}
