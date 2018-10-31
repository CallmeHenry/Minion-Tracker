/**
 * Minion class
 * Contains minion's data
 * Contains minion constructor, accessors, and mutators.
 * Inherits Main (hierarchical) so it has access to Menu
 */

public class Minion extends Main {
    private String name;
    private double height;
    private int deeds;

    Minion(String name, double height, int deeds) {
        this.name = name;
        this.height = height;
        this.deeds = deeds;
    }

    public String getName() {
        return this.name;
    }

    public double getHeight() {
        return this.height;
    }

    public int getDeeds() {
        return this.deeds;
    }

    /*
    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    */

    public void setDeeds(int deeds) {
        this.deeds = deeds;
    }

    @Override
    public String toString() {
        return "\nName: " + this.name + "\n\tHeight: " + this.height + "\n\tDeeds: " + this.deeds;
    }
}