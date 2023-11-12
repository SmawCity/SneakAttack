import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SneakAttack {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);

        System.out.println("Welcome to the Sneak Attack dice roller!");
        System.out.println("1. Standard Sneak Attack");
        System.out.println("2. Zym's Sneak Attack");
        System.out.println("3. Custom");
        System.out.print("Choose an option: ");

        int choice = myObj.nextInt();

        switch (choice) {
            case 1:
                standardSneakAttackRoll(myObj);
                break;
            case 2:
                zymsSneakAttackRoll(myObj);
                break;
            case 3:
                customRoll(myObj);
                break;
            default:
                System.out.println("Invalid choice. Exiting the program.");
        }
    }

    private static void standardSneakAttackRoll(Scanner myObj) {
        // Rolls the number of dice for a standard Rogue using the 5th Edition ruleset
        System.out.println("Standard Sneak Attack option selected.");
        System.out.print("What level is your rogue? ");
        int level = myObj.nextInt();
        int diceNum = (int) Math.ceil(level / 2.0);
        int diceSize = 6;

        ArrayList<Integer> results = new ArrayList<>();

        // Rolls a die and adds it to an array until no more dice remain
        for (int i = 0; i < diceNum; i++) {
            Random rand = new Random();
            int value = rand.nextInt(diceSize) + 1;
            results.add(value);
        }

        int sum = results.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Total: " + sum);
        System.out.println(results);
    }

    private static void zymsSneakAttackRoll(Scanner myObj) {
        // Rolls the number of dice and extra rules for the character Zym Myrrett
        System.out.println("Zym's Sneak Attack option selected.");
        System.out.print("Choose a weapon (1. Dragon Slayer, 2. Ionbreaker): ");
        int weaponChoice = myObj.nextInt();

        int level = 20;
        int diceNum = (int) Math.ceil(level / 2.0);

        ArrayList<Integer> results = new ArrayList<>();

        // Rolls a die and adds it to an array until no more dice remain
        for (int i = 0; i < diceNum; i++) {
            Random rand = new Random();
            int value = rand.nextInt(6) + 1;

            // Special rule: Any roll of 1 becomes a 6
            if (weaponChoice == 1 && value == 1) {
                value = 6;
            }
            results.add(value);
        }

        int sum = results.stream().mapToInt(Integer::intValue).sum();
        if (weaponChoice == 1) {
            ArrayList<Integer> spellResults = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                Random rand = new Random();
                int value = rand.nextInt(8) + 1; // Assume 8-sided dice
                spellResults.add(value);
            }
            int spellSum = spellResults.stream().mapToInt(Integer::intValue).sum();
            Random rand = new Random();
            int weaponDamage = (rand.nextInt(8) + 1);
            int weaponTotal = weaponDamage + 7;

            
            System.out.println("Weapon: " + weaponTotal);
            System.out.println("["+ weaponDamage + "]");
            System.out.println("Booming Blade: " + spellSum);
            System.out.println(spellResults);
            System.out.println("Sneak Attack: " + sum);
            System.out.println(results);
        }
        else if (weaponChoice == 2)
        {
            Random rand = new Random();
            int weaponDamage = (rand.nextInt(6) + 1);
            int weaponTotal = weaponDamage + 8;
            int lightningDamage = (rand.nextInt(10) + 1);

            System.out.println("Weapon: " + weaponTotal);
            System.out.println("["+ weaponDamage + "]");
            System.out.println("Discharge: " + lightningDamage);
            System.out.println("["+ lightningDamage + "]");
            System.out.println("Sneak Attack: " + sum);
            System.out.println(results);
        }

        
    }

    private static void customRoll(Scanner myObj) {
        // Allows the user to roll any amount of dice of any size
        System.out.println("Custom Roll option selected.");
        System.out.print("How many sides does the dice have? ");
        int diceSize = myObj.nextInt();

        System.out.print("How many dice do you want to roll? ");
        int diceNum = myObj.nextInt();

        ArrayList<Integer> results = new ArrayList<>();

        // Rolls a die and adds it to an array until no more dice remain
        for (int i = 0; i < diceNum; i++) {
            Random rand = new Random();
            int value = rand.nextInt(diceSize) + 1;
            results.add(value);
        }

        int sum = results.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Total: " + sum);
        System.out.println(results);
    }

    
}

