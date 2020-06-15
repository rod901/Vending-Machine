package com.vending.machine;

import java.util.Scanner;

public class Console {
    VendingMachine vendingMachine = new VendingMachine();
    final static String ERROR_MESSAGE = "Input was not acceptable. Please, try again.";
    final static String INPUT_MESSAGE = "Give an input to purchase including a letter between A-E and a number between 1-10: ";

    public void userMode() {
        for (int i = 0; i < 5; i++) {
            System.out.print(INPUT_MESSAGE);
            String row = new Scanner(System.in).nextLine().toUpperCase();
            if (VendingMachine.inventoryMap.containsKey(row)) {
                int resp = vendingMachine.pullFromInventory(row);
                System.out.println("Inventory for " + row + " is now " + resp);
            } else {
                System.err.println(ERROR_MESSAGE);
            }
        }
    }

    public void inventoryMode(int mode) {
        String answer = "y";
        while (!answer.equalsIgnoreCase("n")) {
            System.out.println(INPUT_MESSAGE);
            String row = new Scanner(System.in).nextLine().toUpperCase();

            if(!VendingMachine.inventoryMap.containsKey(row)) {
                System.err.println(ERROR_MESSAGE);
            }

            System.out.println("Give an inventory amount to add: ");
            int inventoryAmount = new Scanner(System.in).nextInt();
            if (mode == 0 || mode == 1) {
                int resp = vendingMachine.saveToInventory(row, inventoryAmount);
                System.out.println("Inventory for " + row + " is now " + resp);
                System.out.println("Would you like to add more? Y/N");
                answer = new Scanner(System.in).nextLine();
                if(!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n")) {
                    answer = "n";
                    System.err.println(ERROR_MESSAGE);
                }
            } else {
                System.err.println(ERROR_MESSAGE);
            }
        }
    }
}
