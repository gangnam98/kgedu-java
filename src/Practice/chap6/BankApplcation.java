package Practice.chap6;

import java.util.Scanner;
import java.util.zip.CheckedOutputStream;

public class BankApplcation {
    private static Account[] accountArray = new Account[100];
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean run = true;
        while (run) {
            System.out.println("---------------------");
            System.out.println("1.계좌생성 : 2.계좌목록 : 3.예금 : 4.출금 : 5.종료");
            System.out.println("----------------------");
            System.out.print("선택>");

            int selectNo = scanner.nextInt();
            scanner.nextLine();
            if (selectNo == 1) {
                createAccount();
            } else if (selectNo == 2) {
                accountList();
            } else if (selectNo == 3) {
                deposit();
            } else if (selectNo == 4) {
                withdraw();
            } else if (selectNo == 5) {
                run = false;
            }
        }
        System.out.println("프로그램 종료");

    }

    //계좌생성하기
    private static void createAccount() {
        int i;

        for (i = 0; accountArray[i] != null && i < accountArray.length; i++);

        System.out.println("-----------");
        System.out.println("계좌생성");
        System.out.println("-----------");
        System.out.print("계좌번호:");
        String ano = scanner.nextLine();
        System.out.print("계좌주:");
        String owner = scanner.nextLine();
        System.out.print("조기입금액:");
        int balance = scanner.nextInt();
        Account account = new Account(ano,owner,balance);
        accountArray[i]=account;
        System.out.println("결과: 계좌가 생성되었습니다.");


    }

    private static void accountList() {
        System.out.println("-----------");
        System.out.println("계좌목록");
        System.out.println("-----------");
        for (int i = 0; accountArray[i]!=null&&i<accountArray.length; i++) {
            System.out.println(accountArray[i].getAno() +
                    accountArray[i].getOwner() + accountArray[i].getBalance());
        }

    }

    //예금하기
    private static void deposit() {
        System.out.println("계좌번호:");
        String sub_ano = scanner.nextLine();
        int sub_balance = findAccount(sub_ano).getBalance();
        System.out.println("예금액:");
        int in_balance = scanner.nextInt();
        int sum = sub_balance + in_balance;
        findAccount(sub_ano).setBalance(sum);
        System.out.println("결과: 예금이 성공되었습니다.");

    }

    //출금하기
    private static void withdraw() {
        System.out.println("계좌번호:");
        String sub_ano = scanner.nextLine();
        System.out.println("출금액:");
        int out_balance = scanner.nextInt();
        int sub_balance = findAccount(sub_ano).getBalance();
        int sum = sub_balance - out_balance;
        findAccount(sub_ano).setBalance(sum);
        System.out.println("결과: 출금이 성공되었습니다.");
    }

    private static Account findAccount(String ano) {
        for (int i = 0; accountArray[i]!=null&&i<accountArray.length; i++) {
            if (ano.equals(accountArray[i].getAno()))
                return accountArray[i];
            else
                continue;
        }
        return null;
        //return accountArray[i];
    }

}

