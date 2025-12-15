// Class Algae extends Waste
public class Algae extends Waste {
   private int algae;                   // current algae level
   private final int maxAlgae = 100;    // maximum algae level

   public Algae() {
      super();  // tank starts with 0 waste
      this.algae = 0;
   }

   // spreads algae, increasing the level and tank waste
   public int spread() {
      if (algae < maxAlgae) {
         algae += 5;
         if (algae > maxAlgae) algae = maxAlgae;
      }
      this.increase(5); 
      return algae;
   }

   // decrease algae when tank is cleaned
   public int decreaseAlgae(int remove) {
      algae -= remove;
      if (algae < 0) algae = 0;
      return algae;
   }

   public String toString() {
      return "Algae Level: " + algae;
   }
   // gets algae level
   public int getLevel() {
      return algae;
   }
  
}




