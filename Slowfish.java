public class Slowfish extends Fish {
   // very similar to Fish just moves slower in the tank
   public Slowfish(int x, int y) {
      super(x, y);
   }
  
   // Slowfish move 15 pixles compared to Fish's 35
   @Override
   public void move() {
      public void move() {
        if (!alive && y > 10) {
         y = Math.max(10, y - 5);
         this.x = x;
        }
        int dx = randomStep() * 15;
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
  
   @Override
   public String visuals() {
      if (!alive) {
         return "x";       
      }
      else if (isHungry()) {
         return "s";       
      }
      else {
         return "S";       
      }
   }
}




