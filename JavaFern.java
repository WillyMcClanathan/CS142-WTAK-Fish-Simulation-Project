/**
 * Program Description: This class represents a Java Fern plant.
 * It grows quickly and absorbs a moderate amount of waste each update.
 *
 * @author   Willy McClanathan
 * @version  1.0
 * @since    24 Nov 2025
 */


public class JavaFern extends Plant {


   /**
    * JavaFern: Constructs a Java Fern plant with a given name.
    *
    * @author   Willy McClanathan
    * @version  1.0
    * @param    name The name of this Java Fern
    * @return   void
    * @since    24 Nov 2025
    */
   public JavaFern(String name, int x, int y ) {
      super(name, x, y);
      this.plantType = "Java Fern";
      // after 10 ticks the fern will reach its full size
      this.maxPlantSize = 30;
   } // End of constructor JavaFern




   /**
    * grow: Java Ferns grow faster than generic plants.
    *
    * @author   Willy McClanathan
    * @version  1.0
    * @param    void
    * @return   void
    * @since    24 Nov 2025
    */
   @Override
   public void grow() {
      plantSize += 2;
      if (plantSize > maxPlantSize) {
         plantSize = maxPlantSize;
     }
      System.out.println(plantName + " (Java Fern) grew rapidly to size " + plantSize);
   } // End of method grow




   /**
    * absorbWaste: Java Ferns remove a moderate amount of waste.
    *
    * @author   Willy McClanathan
    * @version  1.0
    * @param    wasteTank The Waste object representing the tank’s waste level
    * @return   void
    * @since    24 Nov 2025
    */
   @Override
   public void absorbWaste(Waste wasteTank) {
      int absorbAmount = 3;
      wasteTank.decrease(absorbAmount);
      System.out.println(plantName + " (Java Fern) absorbed " + absorbAmount + " waste.");
   } // End of method absorbWaste


} // End of class JavaFern




