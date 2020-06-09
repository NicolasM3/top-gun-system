package app;

public class Airports 
{
	protected String city;
	protected String airportCod;
	protected ListaEncadeadaDesordenadaSemRepeticao<Flights> flights = new ListaEncadeadaDesordenadaSemRepeticao<Flights>();
	
	/**
	 * Construtor da classe
	 * @param cityName			Cidade do aeroporto	
	 * @param cod				C�digo do aeroporto
	 */
	public Airports(String cityName, String cod)
	{
		this.city = cityName;
		this.airportCod = cod;
	}
	
	/**
	 * Retorna a cidade em que o aeroporto esta situado	
	 * @return					Cidade do aeroporto
	 */
	public String getCity()
	{
		return this.city;
	}
	
	/**
	 * Define a cidade em que o aeroporto esta situado
	 * @param name				Nome da cidade
	 * @throws Exception		Se nenhum nome for passado
	 */
	public void setCity(String name) throws Exception
	{
		if(name == null)
			throw new Exception("Nenhum nome passado");
		
		this.city = name;
	}
	
	/**
	 * Retorna o c�digo do aeroporto
	 * @return					C�digo do aeroporto
	 */
	public String getAirportCod()
	{
		return this.airportCod;
	}
	
	/**
	 * Define o c�digo do aeroporto
	 * @param code				C�digo do aeroporto
	 * @throws Exception		Se o c�digo passado for nulo
	 */
	public void setAirportCod(String code) throws Exception
	{
		if(code == null)
			throw new Exception("Nenhum c�digo passado");
		
		this.airportCod = code;
	}
	
	/**
	 * Retrona uma lista contendo todos os voos
	 * @return					Lista com todos os voos	
	 */
	public ListaEncadeadaDesordenadaSemRepeticao<Flights> getFlights()
	{
		return (ListaEncadeadaDesordenadaSemRepeticao) flights.clone();
	}
	
	/**
	 * Adiciona um voo no aeroporto
	 * @param cityName			Cidade de destino do voo
	 * @param numFlight			N�mero do voo
	 * @throws Exception		Se um dos par�metro estiver errado
	 */
	public void addFlight(String cityName, int numFlight) throws Exception
	{
		try 
		{
			if(cityName == null)
				throw new Exception("ID da cidade n�o informado");
			
			if(numFlight < 0)
				throw new Exception("N�mero do voo negativo");
			
			flights.insiraNoFim(new Flights(cityName, numFlight));
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
	
	/**
	 * Remove um voo 
	 * @param destination 		Destino do voo a ser removido
	 * @param num				N�mero do voo a ser removido
	 * @throws Exception		Se um dos par�metro estiver errado
	 */
	public void removeFlight(String destination, int num) throws Exception
	{
		if(num < 0)
			throw new Exception("N�mero de voo inv�lido");
		
		try 
		{
			Flights toRemove = new Flights(destination, num);
			
			if(!flights.tem(toRemove))
			{
				System.out.println("n�o tem");
				return;
			}
				
			flights.remova(toRemove);
		}
		catch(Exception ex)
		{
			throw new Exception();
		}
	}
	
	// GAULES TEM A 5 MELHOR HOWL DO MUNDO
	
	/**
	 * Rotorna os dados da classe em formato de String
	 */
	public String toString() 
	{
		String ret = "Cidade: " + this.city
					+" C�digo do aeroporto: " + this.airportCod
					+" Voos deste aeroporto: " + this.flights.toString();
		
		return ret;
	}
	
	/**
	 * Calcula o hashcode da classe
	 */
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
	
	/**
	 * Verifica se um obj � igual a este objeto
	 * @param obj		Objeto a ser comparado com este objeto
	 */
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
	
	/**
	 * Construtor de c�pia
	 * @param modelo			Objeto original a ser clonado
	 */
	public Airports(Airports modelo) throws Exception
	{
		if(modelo == null)
			throw new Exception("modelo ausente");
		
		this.city = modelo.city;
		this.airportCod = modelo.airportCod;
		this.flights = (ListaEncadeadaDesordenadaSemRepeticao<Flights>)modelo.flights.clone();
	}
	
	/**
	 * Clona o objeto
	 */
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
