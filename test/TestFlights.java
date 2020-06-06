package test;

import app.Flights;


public class TestFlights {

	public static void main(String[] args) {
		
		String city = "CidadeTest";
		int numFlight = 123;
		
		System.out.println("new Flights(\"" + city+"\", " + numFlight + " )");
		Flights flight =  new Flights(city, numFlight);
		
		System.out.println("getCityName() " + flight.getCityName() + "\n");
		
		System.out.println("getCod() " + flight.getCod() + "\n");
		
		System.out.println("toString() " + flight.toString() + "\n");
		
		System.out.println("hashCode() " + flight.hashCode() + "\n");
		
		System.out.println("obsFlight = clone() \n");
		Flights obj = (Flights) flight.clone(); 
		System.out.println("equals(obsFlight) " + flight.equals(obj));

	}

}
