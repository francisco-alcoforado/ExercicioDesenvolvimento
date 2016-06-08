package br.aeso.exercicio.fornecedor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import br.aeso.exercicio.arquivos.ArquivosManager;

public class RepositorioFornecedorHashMap implements IRepositorioFornecedor{
	HashMap<Integer, Fornecedor> fornecedores;
	private String file = "C:/Users/lab01/git/ExercicioDesenvolvimento/br.aeso.exercicio/arquivos/fornecedoresHashMap.tmp";
	@SuppressWarnings("unchecked")
	public RepositorioFornecedorHashMap() throws ClassNotFoundException, IOException {
		ArquivosManager arquivos = new ArquivosManager();
		if(!arquivos.exists(this.file)){
			this.fornecedores = new HashMap<Integer, Fornecedor>();
			arquivos.createFile(this.file);
			this.save();
		}else{
			this.fornecedores = (HashMap<Integer, Fornecedor>) arquivos.getValores(file);
		}
	}

	public void cadastrar(Fornecedor fornecedor) throws IOException{
		if(this.fornecedores.containsKey(fornecedor.getCodigo())){
			return;
		}
		this.fornecedores.put(fornecedor.getCodigo(), fornecedor);
		this.save();
	}
	private void save() throws IOException{
		ArquivosManager arquivos = new ArquivosManager();
		HashMap<Integer, Object> valores = new HashMap<Integer, Object>();
		valores.putAll(this.fornecedores);
		arquivos.saveValores(valores, this.file);
	}
	public boolean remover(double codigo) throws IOException{
		if(!this.fornecedores.containsKey(codigo)){
			return false;
		}
		this.fornecedores.remove(codigo);
		this.save();
		return true;
	}
	public boolean remover(Fornecedor fornecedor) throws IOException{
		if(!this.fornecedores.containsKey(fornecedor.getCodigo())){
			return false;
		}
		this.fornecedores.remove(fornecedor.getCodigo());
		this.save();
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
	public void atualizar(Fornecedor fornecedor) throws IOException{
		if(!this.fornecedores.containsKey(fornecedor.getCodigo())){
			this.cadastrar(fornecedor);
		}
		this.fornecedores.replace(fornecedor.getCodigo(), fornecedor);
		this.save();
	}
	public double getNextId(){
		if(this.fornecedores.size() == 0){
			return 1;
		}
		return this.fornecedores.size() + 1;
	}
}
