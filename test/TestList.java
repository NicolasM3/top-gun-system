package test;

import app.ListaEncadeadaDesordenadaSemRepeticao;

public class TestList {
	public static void main(String[] args) {
		try {
			ListaEncadeadaDesordenadaSemRepeticao<String> lista = new ListaEncadeadaDesordenadaSemRepeticao<String>();

			System.out.println(lista.toString() + " qtd: " + lista.getQtd() + "\n");

			System.out.println("insiraNoInicio(\"def\")");
			lista.insiraNoInicio("def");

			System.out.println(lista.toString() + " qtd: " + lista.getQtd() + "\n");

			System.out.println("insiraNoFim(\"uvw\")");
			lista.insiraNoFim("ghi");

			System.out.println(lista.toString() + " qtd: " + lista.getQtd() + "\n");

			System.out.println("insiraNoFim(\"xyz\")");
			lista.insiraNoFim("jkl");

			System.out.println(lista.toString() + " qtd: " + lista.getQtd() + "\n");

			System.out.println("insiraNoInicio(\"abc\")");
			lista.insiraNoInicio("abc");
			
			System.out.println(lista.toString() + " qtd: " + lista.getQtd() + "\n");
			
			System.out.print("getInversao(): ");
			System.out.println(lista.getInversao() + "\n");
			
			System.out.println("invertaSe()");
			lista.invertaSe();
			
			System.out.println(lista.toString() + " qtd: " + lista.getQtd() + "\n");

			System.out.println("removaDoFim()");
			lista.removaDoFim();

			System.out.println(lista.toString() + " qtd: " + lista.getQtd() + "\n");

			System.out.println("removaDoInicio()");
			lista.removaDoInicio();

			System.out.println(lista.toString() + " qtd: " + lista.getQtd() + "\n");

			System.out.println();

			System.out.print("getPrimeiro(): ");
			System.out.println(lista.getPrimeiro());

			System.out.print("getUltimo(): ");
			System.out.println(lista.getUltimo());

		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
}