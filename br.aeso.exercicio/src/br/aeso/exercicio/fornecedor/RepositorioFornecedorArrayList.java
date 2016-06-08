package br.aeso.exercicio.fornecedor;

import java.io.IOException;
import java.util.ArrayList;

import br.aeso.exercicio.arquivos.ArquivosManager;

public class RepositorioFornecedorArrayList implements IRepositorioFornecedor{
	private ArrayList<Fornecedor> fornecedores;
	private String file = "C:/Users/lab01/git/ExercicioDesenvolvimento/br.aeso.exercicio/arquivos/fornecedoresArrayList.tmp";
	@SuppressWarnings("unchecked")
	public RepositorioFornecedorArrayList() throws ClassNotFoundException, IOException {
		ArquivosManager arquivos = new ArquivosManager();
		if(!arquivos.exists(this.file)){
			this.fornecedores = new ArrayList<Fornecedor>();
			arquivos.createFile(this.file);
			this.save();
		}else{
			this.fornecedores = (ArrayList<Fornecedor>) arquivos.getValores(file);
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
		ArrayList<Object> valores = new ArrayList<Object>();
		valores.addAll(this.fornecedores);
		arquivos.saveValores(valores, this.file);
	}
	public ArrayList<Fornecedor> listar(){
		return this.fornecedores;
	}
	public boolean remover(Fornecedor fornecedor) throws IOException{
		int index = this.fornecedores.indexOf(fornecedor);
		if(index == -1){
			return false;
		}
		this.fornecedores.remove(index);
		this.save();
		return true;
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
		int index = this.fornecedores.indexOf(fornecedor);
		return this.fornecedores.get(index);
	}
	public void atualizar(Fornecedor fornecedor) throws IOException{
		if(!this.fornecedores.contains(fornecedor)){
			this.cadastrar(fornecedor);
		}
		int index = this.fornecedores.indexOf(fornecedor);
		this.fornecedores.set(index, fornecedor);
		this.save();
	}
	public double getNextId(){
		if(this.fornecedores.size() == 0){
			return 1;
		}
		Fornecedor fornecedor = this.fornecedores.get(this.fornecedores.size() -1);
		return fornecedor.getCodigo() + 1;
	}
}
