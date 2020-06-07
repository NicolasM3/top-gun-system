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
			lista.insiraNoFim(new Airports("Brasília", "BSB"));
			lista.insiraNoFim(new Airports("Belo Horizonte", "CNF"));
			lista.insiraNoFim(new Airports("Rio de Janeiro", "GIG"));
			lista.insiraNoFim(new Airports("Salvador", "SSA"));
			lista.insiraNoFim(new Airports("São Paulo", "GRU"));
			
			Airports atual = lista.getPrimeiro();
			atual.addFlight("Rio de Janeiro", 512);
			atual.addFlight("Rio de Janeiro", 234);
			System.out.println(atual.getFlights());
			atual.removeFlight("Rio de Janeiro", 234);
			System.out.println(atual.getFlights());
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		
	}
}
