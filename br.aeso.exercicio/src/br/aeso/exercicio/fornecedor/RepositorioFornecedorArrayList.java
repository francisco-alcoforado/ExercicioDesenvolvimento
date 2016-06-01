package br.aeso.exercicio.fornecedor;

import java.util.ArrayList;

public class RepositorioFornecedorArrayList implements IRepositorioFornecedor{
	private ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
	
	public RepositorioFornecedorArrayList() {
		// TODO Auto-generated constructor stub
	}
	
	public void cadastrar(Fornecedor fornecedor){
		if(this.fornecedores.contains(fornecedor)){
			return;
		}
		this.fornecedores.add(fornecedor);
	}
	public ArrayList<Fornecedor> listar(){
		return this.fornecedores;
	}
	public boolean remover(Fornecedor fornecedor){
		int index = this.fornecedores.indexOf(fornecedor);
		if(index == -1){
			return false;
		}
		this.fornecedores.remove(index);
		return true;
	}
	public boolean remover(double codigo){
		for(Fornecedor fornecedor : this.fornecedores){
			if(fornecedor.getCodigo() == codigo){
				this.fornecedores.remove(fornecedor);
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
	public void atualizar(Fornecedor fornecedor){
		if(!this.fornecedores.contains(fornecedor)){
			this.cadastrar(fornecedor);
		}
		int index = this.fornecedores.indexOf(fornecedor);
		this.fornecedores.set(index, fornecedor);
	}
}
