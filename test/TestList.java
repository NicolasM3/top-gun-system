package test;

import app.ListaEncadeadaDesordenadaSemRepeticao;

public class TestList
{
    public static void main(String[] args)
    {
        try
        {
            ListaEncadeadaDesordenadaSemRepeticao<String> lista = new ListaEncadeadaDesordenadaSemRepeticao<String> ();

            System.out.println("Metodo inseraNoInicio()" + lista.inseraNoInicio("abc"));

            System.out.println("Metodo insiraNoFim()" + lista.insiraNoFim("xyz"));

            System.out.println("Metodo toString() : " + lista.toString());
        }
        catch (Exception ex)
        {
            System.err.println(ex.getMessage());
        }
    }
}