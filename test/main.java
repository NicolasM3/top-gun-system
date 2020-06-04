package test;

import app.ListaEncadeadaDesordenadaSemRepeticao;
import app.Airports;

public class main 
{
	public static void main(String[] args)
	{
		
		ListaEncadeadaDesordenadaSemRepeticao<Airports> lista = new ListaEncadeadaDesordenadaSemRepeticao<Airports> ();
		try 
		{
			lista.inseraNoFim(new Airports("Brasília", "BSB"));
			lista.inseraNoFim(new Airports("Belo Horizonte", "CNF"));
			lista.inseraNoFim(new Airports("Rio de Janeiro", "GIG"));
			lista.inseraNoFim(new Airports("Salvador", "SSA"));
			lista.inseraNoFim(new Airports("São Paulo", "GRU"));
			
			Airports atual = lista.getDoInicio();
			atual.addFlight("1", 512);
			atual.addFlight("1", 234);
			System.out.println(atual.getFlights());
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		
	}
}
