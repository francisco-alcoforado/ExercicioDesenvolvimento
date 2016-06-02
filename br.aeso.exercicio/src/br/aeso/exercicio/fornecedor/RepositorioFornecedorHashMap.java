package br.aeso.exercicio.fornecedor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import br.aeso.exercicio.arquivos.ArquivosManager;

public class RepositorioFornecedorHashMap implements IRepositorioFornecedor{
	HashMap<Integer, Fornecedor> fornecedores;
	private String file = "";
	@SuppressWarnings("unchecked")
	public RepositorioFornecedorHashMap() throws ClassNotFoundException, IOException {
		ArquivosManager arquivos = new ArquivosManager();
		if(arquivos.exists(file)){
			this.fornecedores = new HashMap<Integer, Fornecedor>();
		}else{
			this.fornecedores = (HashMap<Integer, Fornecedor>) arquivos.getValores(file);
		}
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
