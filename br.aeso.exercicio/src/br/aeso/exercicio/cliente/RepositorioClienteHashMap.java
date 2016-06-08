package br.aeso.exercicio.cliente;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import br.aeso.exercicio.arquivos.ArquivosManager;

public class RepositorioClienteHashMap implements IRepositorioCliente{
	HashMap<Integer, Cliente> clientes;
	private String file = "C:/Users/lab01/git/ExercicioDesenvolvimento/br.aeso.exercicio/arquivos/clientesHashMap.tmp";
	@SuppressWarnings("unchecked")
	public RepositorioClienteHashMap() throws ClassNotFoundException, IOException {
		ArquivosManager arquivos = new ArquivosManager();
		if(!arquivos.exists(this.file)){
			this.clientes  = new HashMap<Integer, Cliente>();
			arquivos.createFile(this.file);
			this.save();
		}else{
			this.clientes = (HashMap<Integer, Cliente>) arquivos.getValores(file);
		}
	}

	public void cadastrar(Cliente cliente) throws IOException{
		if(this.clientes.containsKey(cliente.getCodigo())){
			return;
		}
		this.clientes.put(cliente.getCodigo(), cliente);
		this.save();
	}
	private void save() throws IOException{
		ArquivosManager arquivos = new ArquivosManager();
		HashMap<Integer, Object> valores = new HashMap<Integer, Object>();
		valores.putAll(this.clientes);
		arquivos.saveValores(valores, this.file);
	}
	public boolean remover(double codigo) throws IOException{
		if(!this.clientes.containsKey(codigo)){
			return false;
		}
		this.clientes.remove(codigo);
		this.save();
		return true;
	}
	public boolean remover(Cliente cliente) throws IOException{
		if(!this.clientes.containsKey(cliente.getCodigo())){
			return false;
		}
		this.clientes.remove(cliente.getCodigo());
		this.save();
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
	public void atualizar(Cliente cliente) throws IOException{
		if(!this.clientes.containsKey(cliente.getCodigo())){
			this.cadastrar(cliente);
		}
		this.clientes.replace(cliente.getCodigo(), cliente);
		this.save();
	}
	public double getNextId(){
		if(this.clientes.size() == 0){
			return 1;
		}
		return this.clientes.size() + 1;
	}
}
