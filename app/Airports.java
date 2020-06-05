package app;

public class Airports 
{
	protected String city;
	protected String airportCod;
	protected ListaEncadeadaDesordenadaSemRepeticao<Flights> flights = new ListaEncadeadaDesordenadaSemRepeticao<Flights>();
	
	public Airports(String cityName, String cod)
	{
		this.city = cityName;
		this.airportCod = cod;
	}
		
	public String getCity()
	{
		return this.city;
	}
	
	public void setCity(String name) throws Exception
	{
		if(name == null)
			throw new Exception("Nenhum nome passado");
		
		this.city = name;
	}
	
	public String getAirportCod()
	{
		return this.airportCod;
	}
	
	public void setAirportCod(String code) throws Exception
	{
		if(code == null)
			throw new Exception("Nenhum código passado");
		
		this.airportCod = code;
	}
	
	public String getFlights()
	{
		return flights.toString();
	}
	
	public void addFlight(String cityName, int numFlight) throws Exception
	{
		try 
		{
			if(cityName == null)
				throw new Exception("ID da cidade não informado");
			
			if(numFlight < 0)
				throw new Exception("Número do voo negativo");
			
			flights.inseraNoFim(new Flights(cityName, numFlight));
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
	
	public void removeFlight(String destination, int num) throws Exception
	{
		if(num < 0)
			throw new Exception("Número de voo inválido");
		
		try 
		{
			Flights toRemove = new Flights(destination, num);
			
			if(!flights.tem(toRemove))
			{
				System.out.println("não tem");
				return;
			}
				
			flights.remova(toRemove);
		}
		catch(Exception ex)
		{
			throw new Exception();
		}
	}
	
	public String toString() 
	{
		String ret = "Cidade: " + this.city
					+" Código do aeroporto: " + this.airportCod
					+" Voos deste aeroporto: " + this.flights.toString();
		
		return ret;
	}
	
	public int hashCode()
	{		
		int ret = 3;
		
		ret = ret * 2 + new String(this.city)		.hashCode();
		ret = ret * 2 + new String(this.airportCod)	.hashCode();
		ret = ret * 2 + this.flights				.hashCode();
		// !TODO VERIFICA LINHA DE CIMA
		
		if(ret < 0)
		{
			return ret * -1;
		}
		
		return ret;
		
		
	}
	
	public boolean equals(Object obj)
	{
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(!(obj instanceof Airports))
			return false;
				
		Airports airport = (Airports) obj;
		if(!(this.city.equals(airport.city)))
			return false;
		if(!(this.airportCod.equals(airport.airportCod)))
			return false;
		if(!(this.flights.equals(airport.flights)))
			return false;
		
		return true;
		
	}
	
	public Airports(Airports modelo) throws Exception
	{
		if(modelo == null)
			throw new Exception("modelo ausente");
		
		this.city = modelo.city;
		this.airportCod = modelo.airportCod;
		this.flights = (ListaEncadeadaDesordenadaSemRepeticao<Flights>)modelo.flights.clone();
	}
	
	public Object clone()
	{
		Airports ret = null;
		
		try
		{
			ret = new Airports(this);
		}	
		catch(Exception ex)
		{
			
		}
		
		return ret;
	}
}
