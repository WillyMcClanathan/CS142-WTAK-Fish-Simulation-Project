import java.util.*;
import java.util.List;
import java.util.ArrayList;

public class TankMain {

   private TankPanel panel;

   private List<Animals> animals = new ArrayList<>();
   private List<Fish> fishs = new ArrayList<>();
   private List<Plant> plants = new ArrayList<>();
   private List<Cleaner> cleaners = new ArrayList<>();
   private Waste waste = new Waste();
   private Algae algae = new Algae();
 
   private Random rand = new Random();
 
   private final int FEED_AMOUNT = 20;
   public static final int SAND_HEIGHT = 50;
 
   public final int TANK_WIDTH = 1000;
   public final int TANK_HEIGHT = 800;

   // Hidden grid
   private final int GRID_COLS = 50;
   private final int GRID_ROWS = 40;
   private final int CELL_WIDTH = TANK_WIDTH / GRID_COLS;
   private final int CELL_HEIGHT = TANK_HEIGHT / GRID_ROWS;
   private List<Animals>[][] animalGrid;
   private List<Plant>[][] plantGrid;

   public TankMain() {
      animalGrid = new ArrayList[GRID_ROWS][GRID_COLS];
      plantGrid = new ArrayList[GRID_ROWS][GRID_COLS];

      for (int r = 0; r < GRID_ROWS; r++) {
          for (int c = 0; c < GRID_COLS; c++) {
              animalGrid[r][c] = new ArrayList<>();
              plantGrid[r][c] = new ArrayList<>();
          }
      }
   }

   // Getters
   public Waste getWaste() {
      return waste;
   }
   public Algae getAlgae() {
      return algae;
   }
   public List<Cleaner> getCleaners() {
      return cleaners;
   }
   public List<Fish> getFish() {
      return fishs;
   }
   public List<Plant> getPlants() {
      return plants;
   }

   public int getGridCol(int x) {
       int col = x / CELL_WIDTH;
       if (col >= GRID_COLS) col = GRID_COLS - 1;
       return col;
   }

   public int getGridRow(int y) {
       int row = y / CELL_HEIGHT;
       if (row >= GRID_ROWS) row = GRID_ROWS - 1;
       return row;
   }

   private void updateGrid() {
      for (int r = 0; r < GRID_ROWS; r++) {
          for (int c = 0; c < GRID_COLS; c++) {
              animalGrid[r][c].clear();
              plantGrid[r][c].clear();
          }
      }

      for (Animals a : animals) {
          int r = getGridRow(a.getY());
          int c = getGridCol(a.getX());
          animalGrid[r][c].add(a);
      }

      for (Plant p : plants) {
          int r = getGridRow(p.getY());
          int c = getGridCol(p.getX());
          plantGrid[r][c].add(p);
      }
   }
  
   // Steps in simulation
   public void tick() {
      // Fish functions
      for (Fish f : fishs) {
         f.tick();
         f.move();
         waste.increase(f.wasteProduced());
      }
      // Plant functions
      for (Plant p : plants) {
         p.grow();
         p.absorbWaste(waste);
      }
      // If the waste gets above 50 an algae bloom will start
      if (waste.getWasteLevel() > 50) {
         algae.spread();
      }
      // Once the waste reaches all the animals die
      if (waste.isToxic()) {
         for (Animals a : animals) a.setAlive(false);
      }
      // Cleaner functions
      for (Cleaner c : cleaners) {
         c.tick();
         if (c.isAlive()) {
            c.move();
            c.cleanWaste();
         }
         waste.increase(c.wasteProduced());
      }
    
      updateGrid();
   }
   // Feeds the fish in the tank and gives more food the more fish there are in the tank
   public void feedTank() {
      if (waste.getWasteLevel() >= 70) {
         System.out.println("Cannot feed, tank too dirty!");
         return;
      }
      if (animals.isEmpty()) {
         System.out.println("No animals to feed.");
         return;
      }
      Feed f = new Feed(waste);
      f.feedAnimals(new ArrayList<Animals>(fishs), FEED_AMOUNT * (fishs.size() / 2));
   }
   // Reduces the tanks waste down 20
   public void cleanTank() {
      Clean c = new Clean(waste, algae);
      c.cleanTank(20);
   }
   // Add animals to tank
   public void addFish() {
      int x = rand.nextInt(TANK_WIDTH - 200) + 100;
      int y = rand.nextInt(TANK_HEIGHT - SAND_HEIGHT - 200) + 100;
      if (waste.getWasteLevel() < 70) {
         Fish fish = new Fish(x, y);
         fishs.add(fish);
         animals.add(fish);
      }
   }

   public void addSlowFish() {
      int x = rand.nextInt(TANK_WIDTH - 200) + 100;
      int y = rand.nextInt(TANK_HEIGHT - SAND_HEIGHT - 200) + 100;
      if (waste.getWasteLevel() < 70) {
         Slowfish slowfish = new Slowfish(x, y);
         fishs.add(slowfish);
         animals.add(slowfish);
      }
   }

   public void addCleaner() {
      int x = rand.nextInt(TANK_WIDTH - 200) + 100;
      int y = TANK_HEIGHT - SAND_HEIGHT;
      if (waste.getWasteLevel() < 70) {
         Cleaner cleaner = new Cleaner(x, y, waste, algae);
         cleaners.add(cleaner);
         animals.add(cleaner);
      }
   }
   // Add plants to tank
   public void addJavaFern() {
      int x = rand.nextInt(TANK_WIDTH - 10) + 5;
      int y = TANK_HEIGHT - 40;
      if (waste.getWasteLevel() < 70) {
         plants.add(new JavaFern("Java Fern " + (plants.size() + 1), x, y));
      }
   }

   public void addLilyPad() {
      int x = rand.nextInt(TANK_WIDTH - 11);
      int y = 5;
      if (waste.getWasteLevel() < 70) {
         plants.add(new LilyPad("LilyPad " + (plants.size() + 1), x, y));
      }
   }

   public void addWaterWeed() {
      int x = rand.nextInt(TANK_WIDTH - 10) + 5;
      int y = TANK_HEIGHT - 40;
      if (waste.getWasteLevel() < 70) {
         plants.add(new WaterWeed("Water Weed " + (plants.size() + 1), x, y));
      }
   }

   public List<Animals>[][] getAnimalGrid() {
      return animalGrid;
   }
   public List<Plant>[][] getPlantGrid() {
      return plantGrid;
   }
}





