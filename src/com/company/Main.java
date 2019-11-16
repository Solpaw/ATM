package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Set<BankAccount> set = new HashSet<>();
        File file = new File(".//data.txt");
        Scanner sc = new Scanner(file);
        List<String> list = new ArrayList<>();
        while (sc.hasNextLine()){
            list.add(sc.next());
        }
        for(int i=0;i<list.size();i+=3) {
            for(int j=0;j<3;j++){
                String accountNumber = list.get(i);
                String pinNumber = list.get(i+1);
                int balance = Integer.parseInt(list.get(i+2));
                BankAccount acc = new BankAccount(accountNumber,pinNumber,balance);
                set.add(acc);
            }

        }
        BankAccount current = null;
        while(true) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter account number: ");
            String accountNumber = input.nextLine();
            for(BankAccount a:set) {
                if(a.getAccountNumber().equals(accountNumber)) {
                    current = a;
                }
            }
            if(current==null) {
                System.out.println("Account not found!");
                continue;
            }
            break;
        }
        while(true) {
            Scanner input = new Scanner(System.in);
            System.out.println("Input pin: ");
            String pinNumber = input.nextLine();
            if(current.getPinNumber().equals(pinNumber)) break;
            System.out.println("Wrong pin number!");
        }

        String menu = "1. Make deposit\n2. Withdraw funds\n3. Show balance\n4. End";
        Scanner input = new Scanner(System.in);
        boolean exit = false;
        while(!exit){
            System.out.println(menu);
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Input the amount: ");
                    int amount=0;
                    System.out.println("Input the amount: ");
                    amount = input.nextInt();
                    while(amount<=0) {
                        System.out.println("Please input a positive number!");
                        amount = input.nextInt();
                    }
                    current.makeDeposit(amount);
                    break;
                case 2:
                    System.out.println("Input the amount: ");
                    amount = input.nextInt();
                    while(amount<=0) {
                        System.out.println("Please input a positive number!");
                        amount = input.nextInt();
                    }
                    while(amount>current.getBalance()){
                        System.out.println("Insufficient funds! Please input a different number!");
                        amount = input.nextInt();
                    }
                    current.withdrawFunds(amount);
                    break;
                case 3:
                    System.out.println("Current balance: "+current.getBalance());
                    break;
               case 4:
                   exit = true;
                   break;
            }
       }
    }
}
