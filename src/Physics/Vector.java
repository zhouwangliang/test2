package Physics;


public class Vector {
	public double x;
	public double y;
	public Vector(double x,double y) {
		// TODO Auto-generated constructor stub
		this.x=x;
		this.y=y;
	}
	
	
	//This function represents the vector  from v1 to v2
	public Vector(Vector v1,Vector v2) {
		this.x=v1.x-v2.x;
		this.y=v1.y-v2.y;
	}
	
	public static Vector getReflectioinRay(Vector IncomingRay,Vector Normal) {
		double magnitude=Math.sqrt(IncomingRay.x*IncomingRay.x+IncomingRay.y*IncomingRay.y);
		double cos1=Normal.x/Math.sqrt(Normal.x*Normal.x+Normal.y*Normal.y);
		double cos2=(Normal.x*IncomingRay.x+Normal.y*IncomingRay.y)/(Math.sqrt(Normal.x*Normal.x+Normal.y*Normal.y)*magnitude);
		Vector result=new Vector(-1*magnitude*(cos2*cos1-Math.sqrt(1-cos2*cos2)*Math.sqrt(1-cos1*cos1)),-1*magnitude*(Math.sqrt(1-cos2*cos2)*cos1+cos2*Math.sqrt(1-cos1*cos1)));
		return result;
	}
	public static double getCosAngle(Vector vector1,Vector vector2) {
		return (vector1.x*vector2.x+vector1.y*vector2.y)/Math.sqrt(vector1.x*vector1.x+vector1.y*vector1.y)/Math.sqrt(vector2.x*vector2.x+vector2.y*vector2.y);
	}
	public static double getSinAngle(Vector vector1,Vector vector2) {
		double cos=getCosAngle(vector1,vector2);
		return Math.sqrt(1-cos*cos);
	}
	//get and set
	public double getMagnitude() {
		return Math.sqrt(x*x+y*y);
	}
	public Vector getUnitVector() {
		return new Vector(x/this.getMagnitude(),y/this.getMagnitude());
	}
}
