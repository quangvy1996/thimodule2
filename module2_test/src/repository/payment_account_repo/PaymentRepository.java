package repository.payment_account_repo;

import model.PaymentAccount;
import util.ReadAndWrite;

import java.util.ArrayList;
import java.util.List;

public class PaymentRepository implements IPaymentRepository {
    public static final String PATH = "src/data/data/bank_accounts.csv";


    @Override
    public List<PaymentAccount> findAll() {
        List<String> stringList = ReadAndWrite.readFileCSVToListString(PATH);
        List<PaymentAccount> paymentAccountList = new ArrayList<>();
        String[] array = null;
        for (String string : stringList) {
            array = string.split(",");
            PaymentAccount paymentAccount = new PaymentAccount(array[0], array[1], array[2], array[3], array[4], Double.parseDouble(array[5]));
            paymentAccountList.add(paymentAccount);
        }
        return paymentAccountList;
    }

    @Override
    public void addPaymentAccount(PaymentAccount paymentAccount) {
        List<String> stringList = new ArrayList<>();
        stringList.add(paymentAccount.getInfoToCSV());
        ReadAndWrite.writeStringListToFile(PATH, stringList, true);

    }

    @Override
    public void deletePaymentAccount(String cardID) {
        List<PaymentAccount> paymentAccountList = findAll();
        for (int i = 0; i < paymentAccountList.size(); i++) {
            if (paymentAccountList.get(i).getAccountNumber().equals(cardID)) {
                paymentAccountList.remove(i);
            }
        }
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < paymentAccountList.size(); i++) {
            stringList.add(paymentAccountList.get(i).getInfoToCSV());
        }
        ReadAndWrite.writeStringListToFile(PATH, stringList, false);

    }

    @Override
    public PaymentAccount findPaymentAccountById(String id) {
        List<PaymentAccount> paymentAccountList = findAll();
        for (int i = 0; i < paymentAccountList.size(); i++) {
            if (paymentAccountList.get(i).getAccountNumber().equals(id)) {
                return paymentAccountList.get(i);
            }
        }
        return null;
    }

    @Override
    public PaymentAccount searchPaymentAccountByName(String name) {
        List<PaymentAccount> paymentAccountList = findAll();
        for (int i = 0; i < paymentAccountList.size(); i++) {
            if (paymentAccountList.get(i).getInfoToCSV().equals(name)) {
                return paymentAccountList.get(i);
            }
        }
        return null;
    }
}
