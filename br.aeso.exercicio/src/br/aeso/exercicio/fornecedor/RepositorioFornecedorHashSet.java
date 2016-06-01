package br.aeso.exercicio.fornecedor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class RepositorioFornecedorHashSet implements IRepositorioFornecedor{
	HashSet<Fornecedor> fornecedores = new HashSet<Fornecedor>();
	
	public void cadastrar(Fornecedor fornecedor){
		if(this.fornecedores.contains(fornecedor)){
			return;
		}
		this.fornecedores.add(fornecedor);
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
	public boolean remover(Fornecedor fornecedor){
		if(!this.fornecedores.contains(fornecedor)){
			return false;
		}
		return this.fornecedores.remove(fornecedor);
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
	public void atualizar(Fornecedor fornecedor){
		if(!this.fornecedores.contains(fornecedor)){
			this.cadastrar(fornecedor);
		}
		for(Fornecedor fornecedor2 : this.fornecedores){
			if(fornecedor2.getCodigo() == fornecedor.getCodigo()){
				this.fornecedores.remove(fornecedor2);
				this.fornecedores.add(fornecedor);
			}
		}
	}

}
