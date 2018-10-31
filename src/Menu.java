import java.util.Scanner;

/**
 * Menu class
 * Prints menu title; prompts user input at menu screen; lists minions; adds minions;
 * removes minions; increments minion's deeds; debug dump of minion details;
 * and displays exit selection.
 * Inherits Main (hierarchical) so it has access to Minion
 */

public class Menu extends Main {
    private String title;
    private String[] options;
    private static Menu listMenu = new Menu("List of Minions", new String[]{null});
    private static Menu addMenu = new Menu("Add a Minion", new String[]{null});
    private static Menu removeMenu = new Menu("Remove a Minion", new String[]{null});
    private static Menu incrementDeedMenu = new Menu("Increment a Minion's Deed", new String[]{null});
    private static Menu debugMenu = new Menu("Debug Dump", new String[]{null});


    public Menu(String initialTitle, String[] initialOptions) {
        title = initialTitle;
        options = initialOptions;
    }

    public void printMenu() {
        System.out.print("\n");
        for (int i = 0; i <= title.length() + 3; i++) {
            System.out.print("*");
        }
        System.out.println("\n* " + title + " *");
        for (int i = 0; i <= title.length() + 3; i++) {
            System.out.print("*");
        }
        System.out.print("\n");
        int i = 0;
        while (options[i] != null) {
            System.out.println(i + 1 + " " + options[i++]);
        }
    }

    public void menuInput() {
        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            printMenu();
            System.out.print("\nPlease select an option: ");
            int input = scan.nextInt();
            switch (input) {
                case 1:
                    listMinions();
                    break;

                case 2:
                    addMinion();
                    break;

                case 3:
                    removeMinion();
                    break;

                case 4:
                    incrementDeed();
                    break;

                case 5:
                    debugDump();
                    break;

                case 6: //exit program option
                    flag = false;
                    break;

                default:
                    System.out.println("\nThat is not an option. Please enter one of the integers shown below:");
                    break;
            }
        }
    }

    private void listMinions() {
        listMenu.printMenu();
        if (minions.isEmpty()) {
            System.out.println("\nNo minions to list.");
        }
        for (int i = 0; i < minions.size(); i++) {
            System.out.println(i + 1 + ":\tName: " + minions.get(i).getName());
            System.out.println("\tHeight: " + minions.get(i).getHeight());
            System.out.println("\tNumber of evil deeds: " + minions.get(i).getDeeds());
        }

    }

    private void addMinion() {
        addMenu.printMenu();
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your minion's name: ");
        String name = scan.nextLine();
        System.out.print("Enter your minion's height: ");
        double height = scan.nextDouble();
        Minion minion = new Minion(name, Math.abs(height), 0);
        minions.add(minion);
        System.out.println("\nMinion added.");
    }

    private void removeMinion() {
        removeMenu.printMenu();
        if (minions.isEmpty()) {
            System.out.println("\nThere are no minions to remove.");
        } else {
            Scanner scan = new Scanner(System.in);
            listMinions();
            System.out.print("Enter the minion's index to remove it (0 to cancel): ");
            int input = scan.nextInt();
            if (input == 0) {
                System.out.println("\nRemove minion cancelled.");
            } else if (input > minions.size() || input < 0) {
                System.out.println("\nThere is no minion on index " + input + ". Please try again.");
                removeMinion();
            } else {
                String removedName = minions.get(input - 1).getName();
                minions.remove(input - 1);
                System.out.println("Minion \"" + removedName + "\" has been removed.");
            }
        }
    }

    private void incrementDeed() {
        incrementDeedMenu.printMenu();
        if (minions.isEmpty()) {
            System.out.println("\nThere are no minions to give a deed to.");
        } else {
            Scanner scan = new Scanner(System.in);
            listMinions();
            System.out.print("\nEnter the minion's index to assign a deed (0 to cancel): ");
            int input = scan.nextInt();
            int deeds;
            if (input == 0) {
                System.out.println("\nIncrementing deed cancelled.");
            } else if (input > minions.size() || input < 0) {
                System.out.println("\nThere is no minion on index " + input + ". Please try again.");
                incrementDeed();
            } else {
                deeds = minions.get(input - 1).getDeeds();
                minions.get(input - 1).setDeeds(++deeds);
                String removedName = minions.get(input - 1).getName();
                System.out.println("\nMinion \"" + removedName + "\" now has " + minions.get(input - 1).getDeeds() + " deed(s).");
            }
        }
    }

    private void debugDump() {
        debugMenu.printMenu();
        if (minions.isEmpty()) {
            System.out.println("\nMinion list is empty.");
        } else {
            System.out.println("\nDebug dump: ");
            for (Minion minion : minions) {
                System.out.println(minion.toString()); //normally prints className@hashCodeOfObject; but I override it in Minion
            }
        }
    }
}