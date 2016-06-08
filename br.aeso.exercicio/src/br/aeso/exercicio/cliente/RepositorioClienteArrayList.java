package br.aeso.exercicio.cliente;

import java.io.IOException;
import java.util.ArrayList;

import br.aeso.exercicio.arquivos.ArquivosManager;


public class RepositorioClienteArrayList implements IRepositorioCliente{
	private ArrayList<Cliente> clientes;
	private String file = "C:/Users/lab01/git/ExercicioDesenvolvimento/br.aeso.exercicio/arquivos/clientesArrayList.tmp";
	@SuppressWarnings("unchecked")
	public RepositorioClienteArrayList() throws ClassNotFoundException, IOException {
		ArquivosManager arquivos = new ArquivosManager();
		if(!arquivos.exists(this.file)){
			this.clientes = new ArrayList<Cliente>();
			arquivos.createFile(this.file);
			this.save();
		}else{
			this.clientes = (ArrayList<Cliente>) arquivos.getValores(file);
		}
	}
	
	public void cadastrar(Cliente cliente) throws IOException{
		if(this.clientes.contains(cliente)){
			return;
		}
		this.clientes.add(cliente);
		this.save();
	}
	private void save() throws IOException{
		ArquivosManager arquivos = new ArquivosManager();
		ArrayList<Object> valores = new ArrayList<Object>();
		valores.addAll(this.clientes);
		arquivos.saveValores(valores, this.file);
	}
	public ArrayList<Cliente> listar(){
		return this.clientes;
	}
	public boolean remover(Cliente cliente)  throws ClienteNaoExncontradoException, IOException{
		int index = this.clientes.indexOf(cliente);
		if(index == -1){
			throw new ClienteNaoExncontradoException();
		}
		this.clientes.remove(index);
		this.save();
		return true;
	}
	public boolean remover(double codigo) throws IOException{
		for(Cliente cliente : this.clientes){
			if(cliente.getCodigo() == codigo){
				this.clientes.remove(cliente);
				this.save();
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
	public void atualizar(Cliente cliente) throws IOException{
		if(!this.clientes.contains(clientes)){
			this.cadastrar(cliente);
		}
		int index = this.clientes.indexOf(cliente);
		this.clientes.set(index, cliente);
		this.save();
	}
	public double getNextId(){
		if(this.clientes.size() == 0){
			return 1;
		}
		return this.clientes.get(this.clientes.size() - 1).getCodigo() + 1;
	}
}
