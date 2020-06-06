package test;

import app.Airports;

public class TestAirports {

	public static void main(String[] args) {
			
		try {
			String city = "CidadeTest";
			String code = "123";
			
			System.out.println("Criando aeroporto em " + city + " e código: " + code + "\n");	
			Airports airport = new Airports(city, code);
			
			System.out.println("getCity() " + airport.getCity() + "\n");
			
			city = "TestCidade";
			System.out.println("SetCity(\"" + city + "\")\n");
			airport.setCity(city);
	
			System.out.println("getAirpotyCod() " + airport.getAirportCod() + "\n");
			
			code = "321";
			System.out.println("setAirportCod(\"" + code + "\")\n");
			airport.setAirportCod(code);
			
			System.out.println("getFlights().toString() " + airport.getFlights().toString() + "\n");
			
			System.out.println("addFlight(\"Test\", 123)\n");
			airport.addFlight("Test", 123);
			
			System.out.println("getFlights().toString()" + airport.getFlights().toString()+ "\n");
			
			System.out.println("removeFlights(\"Test\", 123)\n");
			airport.removeFlight("Test", 123);
			
			System.out.println("getFlights().toString()" + airport.getFlights().toString()+ "\n");
			
			System.out.println("toString() " + airport.toString() + "\n");
			
			System.out.println("hashCode() " + airport.hashCode() + "\n");
			
			System.out.println("objTest = clone() \n");
			
			Airports obj = (Airports) airport.clone();
			
			System.out.println("equals(objTest) " + airport.equals(airport.clone()));
			// TA DANDO ERRO AQUI, SOLUÇÃO
		}
		catch(Exception ex)
		{
			System.err.println(ex.getMessage());
		}
		

	}

}
