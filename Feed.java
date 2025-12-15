import java.util.List;

public class Feed {
   private Waste tankWaste;
 
   public Feed(Waste waste) {
      this.tankWaste = waste;
   }
 
   // The first animals get to eat first until they are full
   // the leftoverFood will make its way down till all the food gets eatten or all the animals are full
   // if there is leftoverFood the tank waste will increase by half it's value
   public void feedAnimals(List<Animals> animals, int givenFood) {
      int leftoverFood = givenFood;
      for (Animals a : animals) {
         if (!a.isAlive()) continue;
         leftoverFood = a.eat(leftoverFood); 
         if (leftoverFood <= 0) break;
      }

      if (leftoverFood > 0) {
         System.out.println("Leftover food: " + leftoverFood + " becomes waste.");
         tankWaste.increase(leftoverFood / 2);
      }
   }
}


