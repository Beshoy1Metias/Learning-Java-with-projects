
public class SimpleCar{
	// public constants
	/** Initial speed - value is set to 10 km/h */
	public static final double INITIAL_SPEED = 10;

	/** Lower gear - value is set to neutral (0 means neutral) */
	public static final int MIN_GEAR = 0;

	/** Upper gear - value is set to 6 */
	public static final int MAX_GEAR = 6;
	   
	/** percentage of speed increment - value is set to 50% */
	public static final double SPEED_INCREMENT_PERCENT = 50;      

	/** percentage of speed decrement - value is set to 30% */
	public static final double SPEED_DECREMENT_PERCENT = 30;

	public int Gear =0;
	public double speed=0;
	public void brake(){
		if(speed < INITIAL_SPEED){
			speed =0;
		}
		else{
			speed -= speed* SPEED_DECREMENT_PERCENT/100;
		}
		
	}
	
	public void speedUp(){
		if(Gear!=0){
			if(speed==0){
				speed=INITIAL_SPEED;
			}
			else{
				speed += speed * SPEED_INCREMENT_PERCENT/100;
			}
		}
	}
	public void gearDown(){
		if(Gear!=MIN_GEAR){
			Gear--;
		}
	}
	public void gearUp(){
		if(Gear<MAX_GEAR){
			Gear++;
		}
	}

	public String toString(){
		return "SimpleCar: gear =" + Gear+ ", speed =" + speed + " km/h";
	}
	
	
	
	
	
}