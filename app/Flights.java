package app;

public class Flights {
	
	protected String cityId;
	protected int cod;
	
	public Flights(String city, int cod)
	{
		this.cityId = city;
		this.cod = cod;
	}
	
	public String toString()
	{
		return "(Flight destination ID: " + this.cityId
				+" Flight code: " + this.cod + ")";
	}
}
