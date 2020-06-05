package test;

import app.ListaEncadeadaDesordenadaSemRepeticao;

public class TestList
{
    public static void main(String[] args)
    {
        try
        {
            ListaEncadeadaDesordenadaSemRepeticao<String> lista = new ListaEncadeadaDesordenadaSemRepeticao<String> ();

            System.out.println(lista.toString());
            
            System.out.println("insiraNoInicio(\"def\")");
            lista.insiraNoInicio("def");
            
            System.out.println(lista.toString());
            
            System.out.println("insiraNoFim(\"uvw\")");
            lista.insiraNoFim("ghi");
            
            System.out.println(lista.toString());
            
            System.out.println("insiraNoFim(\"xyz\")");
            lista.insiraNoFim("jkl");
            
            System.out.println(lista.toString());

            System.out.println("insiraNoInicio(\"abc\")");
            lista.insiraNoInicio("abc");
            
            System.out.println(lista.toString());
        }
        catch (Exception ex)
        {
            System.err.println(ex.getMessage());
        }
    }
}