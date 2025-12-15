/**
 * Program Description: This class represents a Lily Pad.
 * Lily Pads grow slowly and absorb a small amount of waste.
 *
 * @author   Willy McClanathan
 * @version  1.0
 * @since    24 Nov 2025
 */


public class LilyPad extends Plant {


   /**
    * LilyPad: Constructs a Lily Pad plant with a given name.
    *
    * @author   Willy McClanathan
    * @version  1.0
    * @param    name The name of this Lily Pad
    * @return   void
    * @since    24 Nov 2025
    */
   public LilyPad(String name, int x, int y ) {
      super(name, x, y);
      this.plantType = "Lily Pad";
      // after 5 ticks the fern will reach its full size
      this.maxPlantSize = 5;
   } // End of constructor LilyPad




   /**
    * grow: Lily Pads grow slowly over time.
    *
    * @author   Willy McClanathan
    * @version  1.0
    * @param    void
    * @return   void
    * @since    24 Nov 2025
    */
   @Override
   public void grow() {
      if(plantSize < maxPlantSize) {
         plantSize += 1;
      }
      System.out.println(plantName + " (Lily Pad) slowly grew to size " + plantSize);
   } // End of method grow




   /**
    * absorbWaste: Lily Pads absorb only a small amount of waste.
    *
    * @author   Willy McClanathan
    * @version  1.0
    * @param    wasteTank The Waste object representing the tank’s waste level
    * @return   void
    * @since    24 Nov 2025
    */
   @Override
   public void absorbWaste(Waste wasteTank) {
      int absorbAmount = 1;
      wasteTank.decrease(absorbAmount);
      System.out.println(plantName + " (Lily Pad) absorbed " + absorbAmount + " waste.");
   } // End of method absorbWaste


} // End of class LilyPad




