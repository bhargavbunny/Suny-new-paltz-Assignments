

public class Runway
{
   private int secondsForTakeOff; // Seconds for a single wash
   //
   private int secondsForLanding;
   private int timeLeft;   // Seconds until this washer is no longer busy

   public Runway(int s, int l)
   {
      secondsForTakeOff = s;
      //
      secondsForLanding = l;
      timeLeft = 0;
   }

   public boolean isBusy( )
   {
      return (timeLeft > 0);
   }

   public void reduceRemainingTime( )
   {
      if (timeLeft > 0)
         timeLeft--;
   } 

   public void startLanding( )
   {
      if (timeLeft > 0)
         throw new IllegalStateException("Washer is already busy.");
      timeLeft = secondsForLanding;
   }

   public void startTakeoff( )
   {
      if (timeLeft > 0)
         throw new IllegalStateException("Washer is already busy.");
      timeLeft = secondsForTakeOff;
   }
}

