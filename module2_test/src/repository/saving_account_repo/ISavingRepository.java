package repository.saving_account_repo;

import model.PaymentAccount;
import model.SavingAccount;

import java.util.List;

public interface ISavingRepository {
    List<SavingAccount> findAll();
    void addSavingAccount(SavingAccount savingAccount);
    void deleteSavingAccount(String cardID);
    PaymentAccount findSavingAccountById(String id);
    PaymentAccount searchSavingAccountByName(String name);
}
