package com.chennady;

import java.util.Scanner;

public class BillChange {

    private final static double PENNY = 0.01;
    private final static double NICKEL = 0.05;
    private final static double DIME = 0.10;
    private final static double QUARTER = 0.25;

    private final static int MAX_COINS = 100;

    private static int quarters_available = MAX_COINS;
    private static int dimes_available = MAX_COINS;
    private static int nickels_available = MAX_COINS;
    private static int pennies_available = MAX_COINS;

    public static void main(String[] args) {



        while (true) {

            Scanner scan = new Scanner(System.in);

            System.out.println("Enter the amount to get the change for: ");
            double amount = scan.nextDouble();

            if (amount % 1 != 0) {
                System.out.println("Error! Bad Input....");
                continue;
            }

            amount = leastAmountOfCoins(amount);

            if (amount > 0) {
                System.out.println("The machine doesn't have enough coins, please enter a lower amount!");
                continue;
            }
            System.out.println("Quarters Available: "+quarters_available);
            System.out.println("Dimes Available: "+dimes_available);
            System.out.println("Nickels Available: "+nickels_available);
            System.out.println("Pennies Available: "+pennies_available);
            System.out.println("*********************************");

            if (quarters_available == 0 && dimes_available == 0 && nickels_available ==0 && pennies_available == 0) {
                System.out.println("The machine has run out of change");
                break;
            }
        }
    }

    private static double leastAmountOfCoins(double amount) {
        int quarters_change = (int)(amount/QUARTER);
        int quarters_remaining = quarters_available - quarters_change;
        if (quarters_remaining < 0) {
            quarters_change = quarters_available;
            quarters_remaining = 0;
        }
        quarters_available = quarters_remaining;
        amount = amount - quarters_change*QUARTER;

        int dimes_change = (int)(amount/DIME);
        int dimes_remaining = dimes_available - dimes_change;
        if (dimes_remaining < 0) {
            dimes_change = dimes_available;
            dimes_remaining = 0;
        }
        dimes_available = dimes_remaining;
        amount = amount - dimes_change*DIME;

        int nickels_change = (int)(amount/NICKEL);
        int nickels_remaining = nickels_available - nickels_change;
        if (nickels_remaining < 0) {
            nickels_change = nickels_available;
            nickels_remaining = 0;
        }
        nickels_available = nickels_remaining;
        amount = amount - nickels_change*NICKEL;

        int pennies_change = (int)(amount/PENNY);
        int pennies_remaining = pennies_available - pennies_change;
        if (pennies_remaining < 0) {
            pennies_change = pennies_available;
            pennies_remaining = 0;
        }
        pennies_available = pennies_remaining;
        amount = amount - pennies_change*PENNY;

        if (amount == 0) {
            System.out.println("Change Returned ******");
            System.out.println("Quarters#: "+quarters_change);
            System.out.println("Dimes#: "+dimes_change);
            System.out.println("Nickels#: "+nickels_change);
            System.out.println("Pennies#: "+pennies_change);
            System.out.println("---------------");
        } else {
            quarters_available = quarters_available + quarters_change;
            dimes_available = dimes_available + dimes_change;
            nickels_available = nickels_available + nickels_change;
            pennies_available = pennies_available + pennies_change;
        }

        return amount;
    }

    private static double mostAmountOfCoins(double amount) {

        int pennies_change = (int)(amount/PENNY);
        int pennies_remaining = pennies_available - pennies_change;
        if (pennies_remaining < 0) {
            pennies_change = pennies_available;
            pennies_remaining = 0;
        }
        pennies_available = pennies_remaining;
        amount = amount - pennies_change*PENNY;

        int nickels_change = (int)(amount/NICKEL);
        int nickels_remaining = nickels_available - nickels_change;
        if (nickels_remaining < 0) {
            nickels_change = nickels_available;
            nickels_remaining = 0;
        }
        nickels_available = nickels_remaining;
        amount = amount - nickels_change*NICKEL;

        int dimes_change = (int)(amount/DIME);
        int dimes_remaining = dimes_available - dimes_change;
        if (dimes_remaining < 0) {
            dimes_change = dimes_available;
            dimes_remaining = 0;
        }
        dimes_available = dimes_remaining;
        amount = amount - dimes_change*DIME;

        int quarters_change = (int)(amount/QUARTER);
        int quarters_remaining = quarters_available - quarters_change;
        if (quarters_remaining < 0) {
            quarters_change = quarters_available;
            quarters_remaining = 0;
        }
        quarters_available = quarters_remaining;
        amount = amount - quarters_change*QUARTER;

        if (amount == 0) {
            System.out.println("Quarters#: "+quarters_change);
            System.out.println("Dimes#: "+dimes_change);
            System.out.println("Nickels#: "+nickels_change);
            System.out.println("Pennies#: "+pennies_change);
        }

        return amount;
    }
}
