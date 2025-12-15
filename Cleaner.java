import java.awt.Color;

public class Cleaner extends Animals {
    // Cleaner is an animal that can remove waste and algae from the tank
    // Cleaner can also not die from hunger
    private Clean clean;
    private static final int CLEANER_WASTE_RATE = 1;
    private static final int CLEANING_POWER = 3;


   public Cleaner(int x, int y, Waste waste, Algae algae) {
       super(x, y, 0, CLEANER_WASTE_RATE);
  
       colors.add(Color.PINK);
       colors.add(Color.LIGHT_GRAY);
       this.color = colors.get(rand.nextInt(colors.size()));
  
       this.clean = new Clean(waste, algae);    
    }

    // cleans the tank if alive
    public void cleanWaste() {
        if (!alive) return;
            clean.cleanTank(CLEANING_POWER);
    }

    // slimalre to fish can only move horizontally but moves the slowest
    @Override
    public void move() {
        if (!alive) return;
        int dx = randomStep() * 10;
        int X = dx + x;
        this.y += y;
        if(X > 940) {
         this.x = 940;
        }
        else if(X < 10) {
         this.x = 10;
        }
        else {
         this.x = X;
        }
    }


    @Override
    public String visuals() {
        if (!alive) {
            return "x";
        } else if (isHungry()) {
            return "c";
        } else {
            return "C";
        }
    }


    @Override
    public int wasteProduced() {
        return CLEANER_WASTE_RATE;
    }
}




