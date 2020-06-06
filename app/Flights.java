package app;

public class Flights {
	
	protected String cityName;
	protected int cod;
	
	public Flights(String city, int cod)
	{
		this.cityName = city;
		this.cod = cod;
	}
	
	public String getCityName()
	{
		return this.cityName;
	}
	
	public int getCod()
	{
		return this.cod;
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
	
	public int hashCode()
	{
		int ret = 3;
		
		ret = ret * 2 + new String(this.cityName)				.hashCode();
		ret = ret * 2 + Integer.valueOf(this.cod)				.hashCode();
		
		if(ret < 0)
			return ret * -1;
		
		return ret;
	}
	
	public Flights clone() {
		return this;
	}
	
}
