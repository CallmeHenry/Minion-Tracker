import java.util.List;
import java.util.ArrayList;

/**
 * Name:            Henry Nguyen
 * Date:            September 28 2018
 * Description:     Main class for declaring list of minions, main menu screen, and object's menu input
 */

public class Main {
    List<Minion> minions = new ArrayList<>();

    public static void main(String[] args) {

        //passing menu title and options to Menu constructor
        Menu main = new Menu("Main Menu", new String[]{
                "List minions",
                "Add a new minion",
                "Remove minion",
                "Attribute an evil deed to minion",
                "Debug dump of minion",
                "Exit program",
                null
        });
        main.menuInput();

        System.out.println("Program exiting.");
    }
}