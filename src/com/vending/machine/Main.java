package com.vending.machine;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        Console console = new Console();

        System.out.println("Beginning inventory is.");
        vendingMachine.printInventory();

        System.out.println("Choose which mode to begin machine: ");
        System.out.println("0: Add Inventory");
        System.out.println("1: User mode");
        System.out.println("");

        int mode = new Scanner(System.in).nextInt();
        switch (mode) {
            case 0:
                console.inventoryMode(mode);
                break;
            default:
                    console.userMode();
                break;
        }
        System.out.println("Ending inventory is.");
        vendingMachine.printInventory();
    }
}
