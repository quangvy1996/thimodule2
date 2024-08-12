package view;

import controller.payment_account_controller.PaymentAccountController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PaymentAccountController pc = new PaymentAccountController();
        int choice;
        do {
            System.out.println("Quản lý tài khoản \n" +
                    "1. Quản lý tài khoản tiết kiệm \n" +
                    "2. Quản lý tài khoản thanh toán \n" +
                    "3. thoát chương trình \n" +
                    "xin chon \n"
                    );
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    pc.displayAccountPaymentFunction();

            }
        }
        while (true);
    }

}