/**
 * Program Description: This class represents a generic plant inside the tank.
 * Plants grow over time and absorb waste from the tank. This class acts as
 * the superclass for all other plant types in the simulation.
 *
 * @author   Willy McClanathan
 * @version  1.0
 * @since    24 Nov 2025
 */


public class Plant {
   protected int x;
   protected int y;
   protected String plantName;
   protected String plantType;
   protected int plantSize;
   protected int maxPlantSize;


   /**
    * Plant: Constructs a new generic plant with a given name.
    *
    * @author   Willy McClanathan
    * @version  1.0
    * @param    name The name of the plant
    * @return   void
    * @since    24 Nov 2025
    */
   public Plant(String name, int X, int Y) {
      this.x = X;
      this.y = Y;
      this.plantName = name;
      this.plantType = "Generic Plant";
      this.plantSize = 1;
   } // End of constructor Plant




   /**
    * grow: Increases the size of the plant as time passes.
    *
    * @author   Willy McClanathan
    * @version  1.0
    * @param    void
    * @return   void
    * @since    24 Nov 2025
    */
   public void grow() {
      if (plantSize < maxPlantSize) {
        plantSize++;
      }     
    System.out.println(plantName + " grew to size " + plantSize);
   } // End of method grow




   /**
    * absorbWaste: Removes a small amount of waste from the tank.
    *
    * @author   Willy McClanathan
    * @version  1.0
    * @param    wasteTank The Waste object representing the tank’s waste level
    * @return   void
    * @since    24 Nov 2025
    */
   public void absorbWaste(Waste wasteTank) {
      int absorbAmount = 2;
      wasteTank.decrease(absorbAmount);
      System.out.println(plantName + " absorbed " + absorbAmount + " waste.");
   } // End of method absorbWaste




   /**
    * visuals: Displays the plant’s visual representation.
    *
    * @author   Willy McClanathan
    * @version  1.0
    * @param    void
    * @return   void
    * @since    24 Nov 2025
    */
   public void visuals() {
      System.out.println(plantName + " (" + plantType + ") is displayed.");
   } // End of method visuals




   /**
    * toString: Returns a string describing the plant.
    *
    * @author   Willy McClanathan
    * @version  1.0
    * @param    void
    * @return   String Description of the plant
    * @since    24 Nov 2025
    */
   public String toString() {
      return plantName + " [" + plantType + ", size=" + plantSize + "]";
   } // End of method toString
  
  
   public int getX() {
      return x;
   }
  
   public int getY() {
      return y;
   }
  
   public String getPlantType() {
      return plantType; 
   }
  
   public int getSize() {
      return plantSize;
   }


} // End of class Plant




