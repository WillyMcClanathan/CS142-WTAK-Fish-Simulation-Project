public class Clean {
   private Waste tankWaste;
   private Algae tankAlgae;

   // constructor accepts Waste and Algae objects
   public Clean(Waste waste, Algae algae) {
      this.tankWaste = waste; 
      this.tankAlgae = algae; 
   }

   // takes away 'amount' of waste and algae
   public void cleanTank(int amount) {
      tankWaste.decrease(amount);     
      tankAlgae.decreaseAlgae(amount);
      System.out.println("Cleaned: -" + amount + " waste/algae. Current waste: " + tankWaste.getWasteLevel());
   }
}


