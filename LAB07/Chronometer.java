import java.util.NoSuchElementException;
/**   
   implements a stopwatch<br>
   The operating sequence of the chronometer is the follwing: start, stop,
   time readout, reset.
   
   @author A. Luchetta
   @version 25-Nov-2016
 */

public class Chronometer
{
   private static final long NONE = -1L;
   private static final int OFF = 0;     // stopped chronometer
   private static final int RUNNING = 1; // running chronometer
   private static final int DONE = 2;    // time readout ready

   private int state;
   private long startTime;
   private long elapsedTime;

   /**
      constructs a new chronometer in the OFF state and time readout zero
   */
   public Chronometer()
   {
      reset();
   }

   /**
      starts this chronometer<br>      
      if this chronometer is RUNNING, restart the time measurement
   */
   public void start()
   {
      reset();
      state = RUNNING;
      startTime = System.currentTimeMillis();  // returns the number of 
   }                                           // milliseconds elapsed from the 
                                               // Epoch (01-01-1970)   
   /**
      stops this chronometer<br>
      if this chronometer is not RUNNINF, terminates without doing anything
   */
   public void stop()
   {
      if (!isRunning())
      {
         return;
      }

      state = DONE;
      elapsedTime = System.currentTimeMillis() - startTime;
      startTime = NONE;
   }
   
   /**
      resets this chronometer, ie set this chronometer in OFF state with zero
      time measurement
   */
   public void reset()
   {
      state = OFF;
      startTime = NONE;
      elapsedTime = NONE;
   }
   
   /**
      provides the time meaurement or zero if the time measurement has not been
      executed
      @return the time measured by this chronometer      
   */
   public long getElapsedTime()
   {
      if (!hasDone())
      {
         return 0;
      }

      return elapsedTime;
   }

   /**
      checks if this cronometer is OFF
      @return true if this chronometer is OFF, false otherwise
   */
   public boolean isOff()
   {
      return state == OFF;
   }
   
   /**
      checks if this chronometer is running
      @return true if this chronometer is running, false otherwise
   */
   public boolean isRunning()
   {
      return state == RUNNING;
   }
   
   /**
      checks if this chronometer has completed the time measurement sequence
      @return true if this time chronometer has completed a time measurement
              sequence, false otherwise
   */
   public boolean hasDone()
   {
      return state == DONE;
   }

}
