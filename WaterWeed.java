/**
 * Program Description: This class represents Water Weed.
 * Water Weed filters waste very effectively and grows steadily.
 *
 * @author   Willy McClanathan
 * @version  1.0
 * @since    24 Nov 2025
 */


public class WaterWeed extends Plant {


   /**
    * WaterWeed: Constructs a Water Weed plant with a given name.
    *
    * @author   Willy McClanathan
    * @version  1.0
    * @param    name The name of this Water Weed
    * @return   void
    * @since    24 Nov 2025
    */
    public WaterWeed(String name, int x, int y ) {
      super(name, x, y);
        this.plantType = "Water Weed";
        // after 15 ticks the fern will reach its full size
         this.maxPlantSize = 35;
    } // End of constructor WaterWeed




    /**
     * grow: Water Weed grows at a normal rate.
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
        System.out.println(plantName + " (Water Weed) grew to size " + plantSize);
    } // End of method grow




    /**
     * absorbWaste: Water Weed absorbs a large amount of waste.
     *
     * @author   Willy McClanathan
     * @version  1.0
     * @param    wasteTank The Waste object representing the tank’s waste
     * @return   void
     * @since    24 Nov 2025
     */
    @Override
    public void absorbWaste(Waste wasteTank) {
        int absorbAmount = 5;
        wasteTank.decrease(absorbAmount);
        System.out.println(plantName + " (Water Weed) filtered " + absorbAmount + " waste.");
    } // End of method absorbWaste


} // End of class WaterWeed




