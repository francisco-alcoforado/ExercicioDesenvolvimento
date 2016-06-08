package br.aeso.exercicio.fornecedor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import br.aeso.exercicio.arquivos.ArquivosManager;

public class RepositorioFornecedorHashSet implements IRepositorioFornecedor{
	HashSet<Fornecedor> fornecedores = new HashSet<Fornecedor>();
	private String file = "C:/Users/lab01/git/ExercicioDesenvolvimento/br.aeso.exercicio/arquivos/fornecedoresHashSet.tmp";
	@SuppressWarnings("unchecked")
	public RepositorioFornecedorHashSet() throws ClassNotFoundException, IOException {
		ArquivosManager arquivos = new ArquivosManager();
		if(!arquivos.exists(this.file)){
			this.fornecedores = new HashSet<Fornecedor>();
			arquivos.createFile(this.file);
			this.save();
		}else{
			this.fornecedores = (HashSet<Fornecedor>) arquivos.getValores(file);
		}
	}

	public void cadastrar(Fornecedor fornecedor) throws IOException{
		if(this.fornecedores.contains(fornecedor)){
			return;
		}
		this.fornecedores.add(fornecedor);
		this.save();
	}
	private void save() throws IOException{
		ArquivosManager arquivos = new ArquivosManager();
		HashSet<Object> valores = new HashSet<Object>();
		valores.addAll(this.fornecedores);
		arquivos.saveValores(valores, this.file);
	}
	public boolean remover(double codigo) throws IOException{
		for(Fornecedor fornecedor : this.fornecedores){
			if(fornecedor.getCodigo() == codigo){
				this.fornecedores.remove(fornecedor);
				this.save();
				return true;
			}
		}
		return false;
	}
	public boolean remover(Fornecedor fornecedor) throws IOException{
		if(!this.fornecedores.contains(fornecedor)){
			return false;
		}
		this.fornecedores.remove(fornecedor);
		this.save();
		return true;
	}
	
	public ArrayList<Fornecedor> listar(){
		ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>(Arrays.asList((Fornecedor[])this.fornecedores.toArray()));
		return fornecedores;
		
	}
	public Fornecedor procurar(double codigo){
		for(Fornecedor fornecedor : this.fornecedores){
			if(fornecedor.getCodigo() == codigo){
				return fornecedor;
			}
		}
		return null;
	}
	public Fornecedor procurar(Fornecedor fornecedor){
		if(!this.fornecedores.contains(fornecedor)){
			return null;
		}
		for(Fornecedor forn : this.fornecedores){
			if(forn.equals(fornecedor)){
				return forn;
			}
		}
		return null;
	}
	public void atualizar(Fornecedor fornecedor) throws IOException{
		if(!this.fornecedores.contains(fornecedor)){
			this.cadastrar(fornecedor);
		}
		for(Fornecedor fornecedor2 : this.fornecedores){
			if(fornecedor2.getCodigo() == fornecedor.getCodigo()){
				this.fornecedores.remove(fornecedor2);
				this.fornecedores.add(fornecedor);
			}
		}
		this.save();
	}
	public double getNextId(){
		if(this.fornecedores.size() == 0){
			return 1;
		}
		return this.fornecedores.size() + 1;
	}

}
