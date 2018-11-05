public class LocationDemo
{

	public static void main (String [] args)
	{
	
		Location a,b,c;
		a = new Location(10,20);
		b =  (Location) a.clone();
		b.shift(3,0);
		System.out.println(a.toString());
		System.out.println(b.toString());

	}

}
