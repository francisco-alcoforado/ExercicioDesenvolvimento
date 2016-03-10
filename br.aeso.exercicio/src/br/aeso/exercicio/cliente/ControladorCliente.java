package br.aeso.exercicio.cliente;

import java.util.ArrayList;

public class ControladorCliente {
	private IRepositorioCliente repositorio;
	public ControladorCliente() {
	}
	public IRepositorioCliente getRepositorio() {
		return repositorio;
	}
	public void setRepositorio(IRepositorioCliente repositorio) {
		this.repositorio = repositorio;
	}

	public void cadastrar(Cliente cliente){
		//Imprimir as informações do cliente.
		this.repositorio = new RepositorioClienteArray();
		this.repositorio.cadastrar(cliente);
	}
	public void atualizar(Cliente cliente){
		
	}
	public boolean remover(String codigo){
		return false;
	}
	public Cliente procurar(String codigo){
		Cliente cliente = new Cliente("", "", "");
		return cliente;
	}
	public ArrayList<Cliente> listar(){
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		return lista;
	}
}
