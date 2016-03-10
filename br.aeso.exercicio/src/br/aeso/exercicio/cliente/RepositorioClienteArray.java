package br.aeso.exercicio.cliente;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

public class RepositorioClienteArray implements IRepositorioCliente{
	Cliente clientes[] =  new Cliente[1];
	public RepositorioClienteArray() {
		// TODO Auto-generated constructor stub
	}
	
	public void cadastrar(Cliente cliente){
		//Imprimir dados do cliente a ser cadastrado
		System.out.println(cliente.toString());
		int tamanho = this.clientes.length;
		this.clientes = Arrays.copyOf(this.clientes, this.clientes.length + 1);
		this.clientes[tamanho - 1] = cliente;
	}
	public void atualizar(Cliente cliente){
		for(int i = 0; i < this.clientes.length; i++){
			if(this.clientes[i].getCodigo().equals(cliente.getCodigo())){
				this.clientes[i] = cliente;
				break;
			}
		}
	}
	public boolean remover(double codigo){
		Cliente newClientes[] = new Cliente[this.clientes.length - 1];
		int x = 0;
		for(int i = 0; i < this.clientes.length; i++){
			double dbCodigo = Double.parseDouble(this.clientes[i].getCodigo());
			if(dbCodigo != codigo){
				newClientes[x++] = this.clientes[i];
			}
		}
		return true;
	}
	public Cliente procurar(double codigo){
		for(int i = 0; i < this.clientes.length; i++){
			double dbCodigo = Double.parseDouble(this.clientes[i].getCodigo());
			if(dbCodigo == codigo){
				return this.clientes[i];
			}
		}
		return null;
	}
	public ArrayList<Cliente> listar(){
		ArrayList<Cliente> Clientes = new ArrayList<Cliente>(Arrays.asList(this.clientes));
		return Clientes;
	}
}
