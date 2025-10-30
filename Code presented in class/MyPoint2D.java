public class MyPoint2D{
	
	private double x;
	private double y;
	
	public MyPoint2D(double ax, double ay){
		
		x = ax;
		y = ay;
		
	}
	
	public double getDistanceFrom(MyPoint2D q){
		
		double d2 = (x - q.x)*(x - q.x) + (y-q.y)*(y-q.y);
		
		return Math.sqrt(d2);
		
	}
	
	public MyPoint2D getMidpoint(MyPoint2D q){
		
		double xm = (x+q.x) / 2;
		double ym= (y+q.y) /2;
		MyPoint2D tmp = new MyPoint2D(xm, ym);
		return tmp;
		
		
	}
	
	public String toString(){
		return "MyPoint2D: " + x + ", " +y;
		
	}
	
	
}