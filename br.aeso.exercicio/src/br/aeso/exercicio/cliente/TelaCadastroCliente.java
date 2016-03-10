package br.aeso.exercicio.cliente;

import java.util.Scanner;
import br.aeso.exercicio.fachada.Fachada;

public class TelaCadastroCliente {
	private static Scanner teclado = new Scanner(System.in);
	public static void main(String args[]){
		Fachada fachada = new Fachada();
		Cliente cliente = TelaCadastroCliente.cadastrarCliente();
		fachada.cadastrarCliente(cliente);
	}
	public static Cliente cadastrarCliente(){
		System.out.println("Cadastro de CLiente: ");
		System.out.println("Insira o codigo: ");
		String codigo = teclado.nextLine();
		System.out.println("Insira o Nome: ");
		String nome = teclado.nextLine();
		System.out.println("Insira o cpf: ");
		String cpf = teclado.nextLine();
		Cliente cliente = new Cliente(codigo, nome, cpf);
		return cliente;
	}
}
