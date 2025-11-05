public class MyCircle
{
	public double x = 0;
	public double y = 0;
	public double radius=0;
	public MyCircle(double xc, double yc, double radius){
		this.x = xc;
		this.y = yc;
		this.radius = radius;
	}
	
	public boolean isCoincident(MyCircle c){
		
		if(c.x ==x && c.y == y && c.radius == radius){
			return true;
		}
		return false;
		
	}
	public boolean isEncircled(MyCircle c){
		double distance = Math.sqrt((Math.pow((this.x - c.x), 2) + Math.pow((this.y - c.y), 2)));
		if(isCoincident(c)){
			return false;
		}
		if(distance <= (Math.abs(c.radius - radius))){
			return true;
			
		}
		return false;
	}
	
	public boolean isSecant(MyCircle c){
		double distance = Math.sqrt((Math.pow((this.x - c.x), 2) + Math.pow((this.y - c.y), 2)));
		if(distance < c.radius+radius && distance > Math.abs(c.radius-radius)){
			return true;
		}
		return false;
		
	}
	
	public boolean isTangential(MyCircle c){
		double distance = Math.sqrt((Math.pow((this.x - c.x), 2) + Math.pow((this.y - c.y), 2)));
		if(isCoincident(c)){
			return false;
		}
		if(distance == (c.radius-radius) || distance == (c.radius+radius)){
			return true;
		}
		return false;
	}
	
	public boolean isExternal(MyCircle c){
		double distance = Math.sqrt((Math.pow((this.x - c.x), 2) + Math.pow((this.y - c.y), 2)));
		if(distance > (radius+ c.radius)){
			return true;
		}
		return false;
		
	}
	public String toString(){
		return "O=("+x+", "+y+") r= "+ radius;
	}
	
	
}