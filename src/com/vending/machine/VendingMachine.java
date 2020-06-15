package com.vending.machine;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class VendingMachine {
    static Map<String, Integer> inventoryMap = new HashMap<>();

    VendingMachine() {
        String[] letters = {"A", "B", "C", "D", "E"};
        for (String let:letters) {
            IntStream.rangeClosed(1, 10).forEachOrdered(i -> inventoryMap.put(let.concat(String.valueOf(i)), 10));
        }
    }

    public Integer pullFromInventory(String input) {
        Objects.requireNonNull(input);
        int value = inventoryMap.get(input) - 1;
        inventoryMap.put(input, value);
        return value;
    }

    public int saveToInventory(String input, int amount) {
        Objects.requireNonNull(input);
        int result = inventoryMap.getOrDefault(input, 1);
        inventoryMap.put(input, result + amount);
        return inventoryMap.get(input);
    }

    public void printInventory(){
        inventoryMap.forEach((key, value) -> System.out.println("For position: " + key
                + ". There is an amount of: " + value + " left in inventory"));
    }
}
