package controller.payment_account_controller;

import model.PaymentAccount;
import service.payment_account_service.IPaymentAccountService;
import service.payment_account_service.PaymentAccountService;

import java.util.List;
import java.util.Scanner;

public class PaymentAccountController {
    private IPaymentAccountService paymentAccountService = new PaymentAccountService();
    private Scanner scanner = new Scanner(System.in);

    public void displayPaymentAccount() {
        List<PaymentAccount> paymentAccounts = paymentAccountService.findAll();
        for (PaymentAccount paymentAccount : paymentAccounts) {
            if (paymentAccount != null) {
                System.out.println(paymentAccount);
            }
        }
    }

    public void addPaymentAccount() {
        System.out.println("Nhập id: ");
        String id = scanner.nextLine();
        System.out.println("Nhập mã tài khoản");
        String accountNumber = scanner.nextLine();
        System.out.println("Nhập tên chủ tài khoản:");
        String accountName = scanner.nextLine();
        System.out.println("Nhập ngày tạo tài khoản");
        String accountDate = scanner.nextLine();
        System.out.println("Nhập số thẻ");
        String cardNumber = scanner.nextLine();
        System.out.println("Nhập số tien trong tai khoan");
        double balance = Double.parseDouble(scanner.nextLine());

        PaymentAccount paymentAccount = new PaymentAccount(id, accountNumber, accountName, accountDate, cardNumber, balance);
        paymentAccountService.addPaymentAccount(paymentAccount);

    }

    public void deletePaymentAccount() {
        System.out.println("Nhập mã tài khoản:");
        String cardID = scanner.nextLine();

        PaymentAccount existingPaymentAccount = paymentAccountService.findPaymentAccountById(cardID);
        if (existingPaymentAccount != null) {
            System.out.println("Thông tin tai khoản muốn xóa");
            System.out.println(existingPaymentAccount);
            paymentAccountService.deletePaymentAccount(cardID);
        }
        else {
            System.out.println("Không tìm thấy tài khoản");
        }
    }

    public void searchPaymentAccount() {
        System.out.println("Nhap tên tài chủ tài khoản");
        String accountName = scanner.nextLine();
        System.out.println(paymentAccountService.searchPaymentAccountByName(accountName));
    }

    public void displayAccountPaymentFunction() {
        int choice;
        do {
            System.out.println("Quản lý tài khoản thanh toán \n" +
                    "1.Thêm mới \n" +
                    "2.Xóa \n" +
                    "3.Xem danh sách tài khoản ngân hàng \n" +
                    "4.Tìm kiếm \n" +
                    "5.Trở về menu \n" +
                    "Chọn các chức năng"
            );
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addPaymentAccount();
                    break;
                case 2:
                    deletePaymentAccount();
                    break;
                case 3:
                    displayPaymentAccount();
                    break;
                case 4:
                    searchPaymentAccount();
                    break;
                case 5:
                    return;
            }
        }
        while (true);

    }
}
