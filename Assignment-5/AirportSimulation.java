

import java.util.LinkedList;
import java.util.Queue;

public class AirportSimulation
{
   public static void main(String[ ] args)
   {
      final int LANDINGTIME = 4;
      final int DEPARTURETIME = 2;
      final double ARRIVALPROB = 0.1;
      final double DEPARTUREPROB = 0.1;
      final int TOTALTIME = 6000;
      final int MAXTIME = 3;

      Simulate(LANDINGTIME,DEPARTURETIME, ARRIVALPROB, DEPARTUREPROB, TOTALTIME, MAXTIME);
   }

   public static void Simulate
   (int landtime, int departureTime, double arrivalProb, double departureProb, int totalTime, int maxTime)
   {

      Queue<Integer> landingTimes = new LinkedList<Integer>( );
      Queue<Integer> departureTimes = new LinkedList<Integer>( );
      BooleanSource arrival = new BooleanSource(arrivalProb);
      BooleanSource departure = new BooleanSource(departureProb);
      Runway machine = new Runway(landtime, departureTime);
      Averager waitTimesLanding = new Averager( );
      Averager waitTimesDeparture = new Averager( );
      int next;
      int planeCrashes = 0;
      int currentSecond;

      System.out.println("Amount of minutes to land: " + landtime);
      System.out.println("Amount of minutes to take off: " + departureTime);
      System.out.println("Probability of arrival during a minute: " + arrivalProb);
      System.out.println("Average amount of time between planes to land: " + 1/arrivalProb );
      System.out.println("Probability of departure during a minute: " + departureProb );
      System.out.println("Average amount of time between planes to take off: " + 1/departureProb );
      System.out.println("Maximum amount of time in the air before crashing: " + maxTime );
      System.out.println("Total simulation minutes: " + totalTime );

//      // Check the precondition:
//      if (landtime <= 0 || arrivalProb < 0 || arrivalProb > 1 || totalTime < 0)
//         throw new IllegalArgumentException("Values out of range");

      for (currentSecond = 0; currentSecond < totalTime; currentSecond++)
      {  // Simulate the passage of one second of time.
         if (arrival.query( ))
            landingTimes.add(currentSecond);
         if (departure.query( ))
            departureTimes.add(currentSecond);

         if ((!machine.isBusy( ))  &&  (!landingTimes.isEmpty( )))
         {
            next = landingTimes.remove( );
            if(currentSecond - next > maxTime) {
               planeCrashes++;
            }
            else {
               waitTimesLanding.addNumber(currentSecond - next);
               machine.startLanding();
            }
         }

         if ((!machine.isBusy( )) && (!departureTimes.isEmpty( )))
         {
            next = departureTimes.remove( );
            waitTimesDeparture.addNumber(currentSecond - next);
            machine.startTakeoff( );
         }
         machine.reduceRemainingTime( );
      }

      System.out.println();
      System.out.println("Number of planes taken off: " + waitTimesDeparture.howManyNumbers( ));
      System.out.println("Number of planes landed: " + waitTimesLanding.howManyNumbers( ));
      System.out.println("Number of planes crashed: " + planeCrashes);
      System.out.println("Average waiting time for taking off: " + waitTimesDeparture.average());
      System.out.println("Average waiting time for landing: " + waitTimesLanding.average());
   }
}

