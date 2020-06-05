package app;

public class Flights {
	
	protected String cityName;
	protected int cod;
	
	public Flights(String city, int cod)
	{
		this.cityName = city;
		this.cod = cod;
	}
	
	public String toString()
	{
		return "(Cidade de destino: " + this.cityName
				+" Codigo do voo: " + this.cod + ")";
	}
	
	public boolean equals(Object obj)
	{
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(!(obj instanceof Flights))
			return false;
		
		Flights flight = (Flights) obj;
		if(!(this.cityName.equals(flight.cityName)))
			return false;
		if(this.cod != flight.cod)
			return false;
		
		return true;
	}
}
