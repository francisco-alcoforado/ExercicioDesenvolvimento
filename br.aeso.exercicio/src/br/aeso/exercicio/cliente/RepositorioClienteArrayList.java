package br.aeso.exercicio.cliente;

import java.io.IOException;
import java.util.ArrayList;

import br.aeso.exercicio.arquivos.ArquivosManager;


public class RepositorioClienteArrayList implements IRepositorioCliente{
	private ArrayList<Cliente> clientes;
	private String file = "";
	@SuppressWarnings("unchecked")
	public RepositorioClienteArrayList() throws ClassNotFoundException, IOException {
		ArquivosManager arquivos = new ArquivosManager();
		if(arquivos.exists(file)){
			this.clientes = new ArrayList<Cliente>();
		}else{
			this.clientes = (ArrayList<Cliente>) arquivos.getValores(file);
		}
	}
	
	public void cadastrar(Cliente cliente){
		if(this.clientes.contains(cliente)){
			return;
		}
		this.clientes.add(cliente);
	}
	public ArrayList<Cliente> listar(){
		return this.clientes;
	}
	public boolean remover(Cliente cliente)  throws ClienteNaoExncontradoException{
		int index = this.clientes.indexOf(cliente);
		if(index == -1){
			throw new ClienteNaoExncontradoException();
		}
		this.clientes.remove(index);
		return true;
	}
	public boolean remover(double codigo){
		for(Cliente cliente : this.clientes){
			if(cliente.getCodigo() == codigo){
				this.clientes.remove(cliente);
				return true;
			}
		}
		return false;
	}
	public Cliente procurar(double codigo){
		for(Cliente cliente : this.clientes){
			if(cliente.getCodigo() == codigo){
				return cliente;
			}
		}
		return null;
	}
	public Cliente procurar(Cliente cliente){
		if(!this.clientes.contains(cliente)){
			return null;
		}
		int index = this.clientes.indexOf(cliente);
		return this.clientes.get(index);
	}
	public void atualizar(Cliente cliente){
		if(!this.clientes.contains(clientes)){
			this.cadastrar(cliente);
		}
		int index = this.clientes.indexOf(cliente);
		this.clientes.set(index, cliente);
	}

}
