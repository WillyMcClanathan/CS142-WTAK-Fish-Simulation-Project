import java.awt.Color;

public class Fish extends Animals {

   private static final int FISH_WASTE_RATE = 2;

   /**
    * Constructs a new Fish at the given position.
    * Initial hunger is 0, waste rate is fixed at 2.
    */
   public Fish(int x, int y) {
      super(x, y, 0, FISH_WASTE_RATE);

      colors.add(Color.RED);
      colors.add(Color.ORANGE);
      colors.add(Color.YELLOW);
      colors.add(Color.GREEN);
      colors.add(Color.CYAN);
      colors.add(Color.MAGENTA);
 
      this.color = colors.get(rand.nextInt(colors.size()));   
   }

   /**
    * Fish only move horizontally (left/right), dead fish float upwards.
    */
   @Override
   public void move() {
      if (!alive && y > 10) {
         y = Math.max(10, y - 5);
         this.x = x;
      }
      int dx = randomStep() * 35;
      int X = dx + this.x;
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
   
   /**
    * Returns visual representation:
    *   "F" = healthy fish
    *   "f" = hungry fish
    *   "x" = dead fish
    */
   @Override
   public String visuals() {
      if (!alive) return "x";      
        else if (isHungry()) return "f";      
        else return "F";      
    }

    /**
      * Fish produce 2 units of waste per tick.
      */
    @Override
    public int wasteProduced() {
        return FISH_WASTE_RATE;
    }
}


