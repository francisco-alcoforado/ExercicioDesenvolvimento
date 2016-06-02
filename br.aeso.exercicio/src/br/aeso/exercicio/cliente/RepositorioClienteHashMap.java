package br.aeso.exercicio.cliente;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import br.aeso.exercicio.arquivos.ArquivosManager;

public class RepositorioClienteHashMap implements IRepositorioCliente{
	HashMap<Integer, Cliente> clientes;
	private String file = "";
	@SuppressWarnings("unchecked")
	public RepositorioClienteHashMap() throws ClassNotFoundException, IOException {
		ArquivosManager arquivos = new ArquivosManager();
		if(arquivos.exists(file)){
			this.clientes  = new HashMap<Integer, Cliente>();
		}else{
			this.clientes = (HashMap<Integer, Cliente>) arquivos.getValores(file);
		}
	}

	public void cadastrar(Cliente cliente){
		if(this.clientes.containsKey(cliente.getCodigo())){
			return;
		}
		this.clientes.put(cliente.getCodigo(), cliente);
	}
	
	public boolean remover(double codigo){
		if(!this.clientes.containsKey(codigo)){
			return false;
		}
		this.clientes.remove(codigo);
		return false;
	}
	public boolean remover(Cliente cliente){
		if(!this.clientes.containsKey(cliente.getCodigo())){
			return false;
		}
		this.clientes.remove(cliente.getCodigo());
		return true;
	}
	public ArrayList<Cliente> listar(){
		ArrayList<Cliente> clientes = new ArrayList<Cliente>(this.clientes.values());
		return clientes;
	}
	public Cliente procurar(double codigo){
		if(!this.clientes.containsKey(codigo)){
			return null;
		}
		return this.clientes.get(codigo); 
	}
	
	public Cliente procurar(Cliente cliente){
		if(!this.clientes.containsKey(cliente.getCodigo())){
			return null;
		}
		return this.clientes.get(cliente.getCodigo());
	}
	public void atualizar(Cliente cliente){
		if(!this.clientes.containsKey(cliente.getCodigo())){
			this.cadastrar(cliente);
		}
		this.clientes.replace(cliente.getCodigo(), cliente);
	}
}
