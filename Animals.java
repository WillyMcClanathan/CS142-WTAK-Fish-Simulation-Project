import java.util.*;
import java.awt.Color;
/**
 * This is the Animals class for the Fish Tank Simulation WTAK.
 * @Hierarchy: This is a superclass. Subclasses include Fish and Cleaners.
 * @Description The purpose of this class is to
 *   1. Understand: Am I Alive? How hungry am I? How much waste do I produce?
 *       Where am I in the tank?
 *       Then: the GUI/Tank classes will call these methods.
 *   2. "A thing in the tank with position + hunger
 *       + basic behavior produce waste, return a visual representation"
 *
 * @author Andrew Ramirez
 * @version 1.0.0
 * @see main(), miniMain()
 * @fields int x, int y, int hunger, boolean alive, int baseWasteRate.
 * @constructors (passed down).
 * @methods wasteProduced(), isHungry(), eat(), move(), visuals(), tick().
 */
public abstract class Animals {


    protected int x;
    protected int y;
    protected int hunger; 
    protected boolean alive;                   
    protected int baseWasteRate;
    protected List<Color> colors = new ArrayList<>();
    protected Color color;
    protected final Random rand = new Random();



    protected static final int HUNGRY_THRESHOLD = 40;
    protected static final int STARVATION_LIMIT = 100;


    /**
     * Constructor for Animals.
     */
    public Animals(int x, int y, int initialHunger, int baseWasteRate) {
        this.x = x;
        this.y = y;
        this.hunger = initialHunger;
        this.baseWasteRate = baseWasteRate;
        this.alive = true;
    }


    /**
     * Subclasses must implement how much waste they produce each tick.
     */
    public abstract int wasteProduced();


    /**
     * Returns true if the animal needs food.
     */
    public boolean isHungry() {
        return hunger > HUNGRY_THRESHOLD;
    }


    /**
     * Feeds the animal. Reduces hunger (cannot go below 0).
     *
     * @param foodAmount amount of food given
     */
    public int eat(int foodAmount) {
        int leftoverFood = 0;
        if (!alive) return foodAmount;
        hunger -= foodAmount;
        if (hunger < 0) {
            leftoverFood = hunger * -1;
            hunger = 0;
        }
        return leftoverFood;
    }


    /**
     * Moves the animal randomly by -1, 0, or +1 in both x and y directions.
     * Dead animals do not move.
     */
    public void move() {
        if (!alive) return;
       
        this.x += randomStep();
        this.y += randomStep();
        // Tank class will clamp coordinates if needed
    }


    /**
     * Returns a simple visual representation. Subclasses should override.
     */
    public String visuals() {
        return "A"; // please override this in subclasses!
    }


    /**
     * Called once per simulation tick.
     * Increases hunger and kills the animal if it starves.
     */
    public void tick() {
        if (!alive) return;
        hunger++;
        if (hunger > STARVATION_LIMIT) {
            alive = false;
        }
    }


 
    public int getX()       { return x; }
    public int getY()       { return y; }
    public boolean isAlive(){ return alive; }
    public int getHunger()  { return hunger; }
    public Color getColor(){ return color; }    


    /**
     * Helper for random movement: returns -1, 0, or +1
     */
    protected int randomStep() {
        return rand.nextInt(3) - 1; // -1, 0, 1
    }
    // Set if animal is alive or not
    public void setAlive(boolean alive) {
    this.alive = alive;
    }
   
}



