package repository.saving_account_repo;

import model.PaymentAccount;
import model.SavingAccount;
import util.ReadAndWrite;

import java.util.ArrayList;
import java.util.List;

public class SavingRepository implements ISavingRepository {
    public static final String PATH = "src/data/data/bank_accounts.csv";
    @Override
    public List<SavingAccount> findAll() {
        List<String> stringList = ReadAndWrite.readFileCSVToListString(PATH);
        List<SavingAccount> savingAccountList = new ArrayList<>();
        String[] array = null;
        for (String string : stringList) {
            array = string.split(",");
            SavingAccount savingAccount = new SavingAccount(array[0], array[1], array[2], array[3], Double.parseDouble(array[4]), array[5],Double.parseDouble(array[6]),Integer.parseInt(array[7]));
            savingAccountList.add(savingAccount);
        }
        return savingAccountList;
    }



    @Override
    public void addSavingAccount(SavingAccount savingAccount) {
        List<String> stringList = new ArrayList<>();
        stringList.add(savingAccount.getInfoCSVToCSV());
        ReadAndWrite.writeStringListToFile(PATH, stringList, true);
    }

    @Override
    public void deleteSavingAccount(String cardID) {
        List<SavingAccount> savingAccountList = findAll();
        for (int i = 0; i < savingAccountList.size(); i++) {
            if (savingAccountList.get(i).getAccountNumber().equals(cardID)) {
                savingAccountList.remove(i);
            }
        }
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < savingAccountList.size(); i++) {
            stringList.add(savingAccountList.get(i).getInfoCSVToCSV());
        }
        ReadAndWrite.writeStringListToFile(PATH, stringList, false);

    }

    @Override
    public PaymentAccount findSavingAccountById(String id) {
        return null;
    }

    @Override
    public PaymentAccount searchSavingAccountByName(String name) {
        return null;
    }
}
