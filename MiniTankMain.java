import java.util.*;

public class MiniTankMain {

    public static void main(String[] args) {
        System.out.println("Mini Tank Test");
        System.out.println();

        System.out.println("======== Test Animals ========");
        TestAnimals();
        System.out.println("======== Test End ========");

        System.out.println("======== Test Plants ========");
        TestPlants();
        System.out.println("======== Test End ========");
    }

    public static void TestAnimals() {
        Random rand = new Random();
        Waste tankWaste = new Waste();
        Feed feeder = new Feed(tankWaste);

        Fish[] fishList = new Fish[3];
        Cleaner[] cleanerList = new Cleaner[3];

        for (int i = 0; i < fishList.length; i++) {
            int x = rand.nextInt(51);
            int y = rand.nextInt(51);
            fishList[i] = new Fish(x, y);
        }

        for (int j = 0; j < cleanerList.length; j++) {
            int x = rand.nextInt(51);
            int y = rand.nextInt(51);
            cleanerList[j] = new Cleaner(x, y);
        }

        for (int tick = 1; tick <= 3; tick++) {
            System.out.println("\n--- Tick " + tick + " ---");

            int foodGiven = 30;

            System.out.println("\n-- Fish Test --");
            for (Fish f : fishList) {
                if (!f.isAlive()) {
                    System.out.println("Dead fish at (" + f.getX() + "," + f.getY() + ")");
                    continue;
                }
                f.move();
                feeder.feedAnimals(fishList, foodGiven);
                System.out.println(f.visuals() + " at (" + f.getX() + "," + f.getY() + ") hunger=" + f.getHunger());
                tankWaste.increase(f.wasteProduced());
            }

            System.out.println("\n-- Cleaner Test --");
            for (Cleaner c : cleanerList) {
                if (!c.isAlive()) continue;
                c.move();
                int cleaned = c.cleanWaste((int)tankWaste.getWasteLevel());
                tankWaste.decrease(cleaned);
                System.out.println(c.visuals() + " cleaned " + cleaned + " waste");
                tankWaste.increase(c.wasteProduced());
            }

            System.out.println("Tank waste: " + tankWaste.getWasteLevel());
        }
    }

    public static void TestPlants() {
        Waste tankWaste = new Waste();
        tankWaste.increase(20); // start with some waste

        Plant[] plants = {                    
            new JavaFern("Ferny"),
            new WaterWeed("Weedy"),
            new LilyPad("Lily")
        };

        for (int tick = 1; tick <= 5; tick++) {
            System.out.println("\n--- Plant Tick " + tick + " ---");
            for (Plant p : plants) {
                p.grow();
                p.absorbWaste(tankWaste);
            }
            System.out.println("Waste level: " + tankWaste.getWasteLevel());
        }
    }
}