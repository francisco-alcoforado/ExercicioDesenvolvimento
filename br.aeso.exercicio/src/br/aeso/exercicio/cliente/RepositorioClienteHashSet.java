package br.aeso.exercicio.cliente;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import br.aeso.exercicio.arquivos.ArquivosManager;
import br.aeso.exercicio.fornecedor.Fornecedor;

public class RepositorioClienteHashSet implements IRepositorioCliente{
	HashSet<Cliente> clientes;
	private String file = "";
	@SuppressWarnings("unchecked")
	public RepositorioClienteHashSet() throws ClassNotFoundException, IOException {
		ArquivosManager arquivos = new ArquivosManager();
		if(arquivos.exists(file)){
			this.clientes = new HashSet<Cliente>();
		}else{
			this.clientes = (HashSet<Cliente>) arquivos.getValores(file);
		}
	}

	public void cadastrar(Cliente cliente){
		if(this.clientes.contains(cliente)){
			return;
		}
		this.clientes.add(cliente);
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
	public boolean remover(Cliente cliente){
		if(!this.clientes.contains(cliente)){
			return false;
		}
		return this.clientes.remove(cliente);
	}
	
	public ArrayList<Cliente> listar(){
		ArrayList<Cliente> clientes = new ArrayList<Cliente>(Arrays.asList((Cliente[])this.clientes.toArray()));
		return clientes;
		
	}
	public Cliente procurar(double codigo){
		for(Cliente cliente : this.clientes){
			if(cliente.getCodigo() == codigo){
				return cliente;
			}
		}
		return null;
	}
	public Cliente procurar(Fornecedor cliente){
		if(!this.clientes.contains(cliente)){
			return null;
		}
		for(Cliente forn : this.clientes){
			if(forn.equals(cliente)){
				return forn;
			}
		}
		return null;
	}
	public void atualizar(Cliente cliente){
		if(!this.clientes.contains(cliente)){
			this.cadastrar(cliente);
		}
		for(Cliente cliente2 : this.clientes){
			if(cliente2.getCodigo() == cliente.getCodigo()){
				this.clientes.remove(cliente2);
				this.clientes.add(cliente);
			}
		}
	}


}
