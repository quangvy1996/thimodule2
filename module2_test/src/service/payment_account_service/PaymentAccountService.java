package service.payment_account_service;

import model.PaymentAccount;
import repository.payment_account_repo.IPaymentRepository;
import repository.payment_account_repo.PaymentRepository;

import java.util.List;

public class PaymentAccountService implements IPaymentAccountService {
    IPaymentRepository paymentRepo = new PaymentRepository();
    @Override
    public List<PaymentAccount> findAll() {
        return paymentRepo.findAll();
    }

    @Override
    public void addPaymentAccount(PaymentAccount paymentAccount) {
        paymentRepo.addPaymentAccount(paymentAccount);

    }

    @Override
    public void deletePaymentAccount(String cardID) {
    paymentRepo.deletePaymentAccount(cardID);
    }

    @Override
    public PaymentAccount findPaymentAccountById(String id) {
        return paymentRepo.findPaymentAccountById(id);
    }

    @Override
    public PaymentAccount searchPaymentAccountByName(String name) {
        return paymentRepo.searchPaymentAccountByName(name);
    }
}
