package br.aeso.exercicio.cliente;

import java.util.Scanner;
import br.aeso.exercicio.fachada.Fachada;
import br.aeso.exercicio.util.CPFInvalidoException;

public class TelaCadastroCliente {
	private static Scanner teclado = new Scanner(System.in);
	public static void main(String args[]) throws IllegalArgumentException, CPFInvalidoException, ClienteJaCadastradoException, ClienteNaoExncontradoException{
		Fachada fachada = new Fachada("ArrayList");
		Cliente cliente = TelaCadastroCliente.cadastrarCliente();
		try{
			fachada.cadastrarCliente(cliente);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	public static Cliente cadastrarCliente(){
		System.out.println("Cadastro de CLiente: ");
		System.out.println("Insira o codigo: ");
		int codigo = teclado.nextInt();
		System.out.println("Insira o Nome: ");
		String nome = teclado.nextLine();
		System.out.println("Insira o cpf: ");
		String cpf = teclado.nextLine();
		String complemento = "";
		int numero = 0;
		String rua = "";
		String bairro= "";
		String cidade = ""; 
		String CEP = "";
		Cliente cliente = new Cliente(codigo, nome, cpf, rua, bairro, cidade, CEP,
				numero, complemento);
		return cliente;
	}
}
