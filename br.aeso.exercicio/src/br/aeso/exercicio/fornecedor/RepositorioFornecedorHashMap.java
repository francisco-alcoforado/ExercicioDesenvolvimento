package br.aeso.exercicio.fornecedor;

import java.util.ArrayList;
import java.util.HashMap;

public class RepositorioFornecedorHashMap implements IRepositorioFornecedor{
	HashMap<Integer, Fornecedor> fornecedores = new HashMap<Integer, Fornecedor>();
	
	public RepositorioFornecedorHashMap() {
		// TODO Auto-generated constructor stub
	}

	public void cadastrar(Fornecedor fornecedor){
		if(this.fornecedores.containsKey(fornecedor.getCodigo())){
			return;
		}
		this.fornecedores.put(fornecedor.getCodigo(), fornecedor);
	}
	
	public boolean remover(double codigo){
		if(!this.fornecedores.containsKey(codigo)){
			return false;
		}
		this.fornecedores.remove(codigo);
		return false;
	}
	public boolean remover(Fornecedor fornecedor){
		if(!this.fornecedores.containsKey(fornecedor.getCodigo())){
			return false;
		}
		this.fornecedores.remove(fornecedor.getCodigo());
		return true;
	}
	public ArrayList<Fornecedor> listar(){
		ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>(this.fornecedores.values());
		return fornecedores;
	}
	public Fornecedor procurar(double codigo){
		if(!this.fornecedores.containsKey(codigo)){
			return null;
		}
		return this.fornecedores.get(codigo); 
	}
	
	public Fornecedor procurar(Fornecedor fornecedor){
		if(!this.fornecedores.containsKey(fornecedor.getCodigo())){
			return null;
		}
		return this.fornecedores.get(fornecedor.getCodigo());
	}
	public void atualizar(Fornecedor fornecedor){
		if(!this.fornecedores.containsKey(fornecedor.getCodigo())){
			this.cadastrar(fornecedor);
		}
		this.fornecedores.replace(fornecedor.getCodigo(), fornecedor);
	}
}
