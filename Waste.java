public class Waste {
   
    protected double wasteLevel; // Stores the current amount of waste
    private final int DEATH_THRESHOLD = 80; // If waste reaches 80, it is dangerous for animals

    public Waste() {
        this.wasteLevel = 0; // The tank starts completely clean
    }

    public void increase(int amount) { // Increases the waste level
        this.wasteLevel += amount;
        if (this.wasteLevel > 100) {
            this.wasteLevel = 100; // Maximum limit
        }
    }

    public void decrease(int amount) { // Decreases the waste level
        this.wasteLevel -= amount;
        if (this.wasteLevel < 0) {
            this.wasteLevel = 0; // Minimum limit
        }
    }

    public double getWasteLevel() { // Returns the current waste percentage
        return this.wasteLevel;
    }
   
    public boolean isToxic() { // Checks if the waste level is too high
        return this.wasteLevel >= DEATH_THRESHOLD;
    }

    public String toString() { // Returns the current waste level for display
        return "Waste Level: " + this.wasteLevel + "/100.0";
    }
}




