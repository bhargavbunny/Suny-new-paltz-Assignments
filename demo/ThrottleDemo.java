public class ThrottleDemo
{

	public static void main (String [] args)
	{
	
		Throttle x,y,z;
		x = new Throttle(100);
		x.shift(25);
		y = x;
		y.shift(25);
		z = y;
		z.shift(25);
		System.out.println(x.getFlow());
		System.out.println(y.getFlow());
		System.out.println(z.getFlow());
	}
}

