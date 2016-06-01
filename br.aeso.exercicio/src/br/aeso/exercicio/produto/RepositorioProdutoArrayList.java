package br.aeso.exercicio.produto;

import java.util.ArrayList;

public class RepositorioProdutoArrayList implements IRepositorioProduto{
	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	
		
	public RepositorioProdutoArrayList() {
		// TODO Auto-generated constructor stub
	}
	public void cadastrar(Produto produto){
		if(this.produtos.contains(produto)){
			return;
		}
		this.produtos.add(produto);
	}
	public ArrayList<Produto> listar(){
		return this.produtos;
	}
	public boolean remover(Produto produto){
		int index = this.produtos.indexOf(produto);
		if(index == -1){
			return false;
		}
		this.produtos.remove(index);
		return true;
	}
	public boolean remover(double codigo){
		for(Produto produto : this.produtos){
			if(produto.getCodigo() == codigo){
				this.produtos.remove(produto);
				return true;
			}
		}
		return false;
	}
	public Produto procurar(double codigo){
		for(Produto produto : this.produtos){
			if(produto.getCodigo() == codigo){
				return produto;
			}
		}
		return null;
	}
	public Produto procurar(Produto produto){
		if(!this.produtos.contains(produto)){
			return null;
		}
		int index = this.produtos.indexOf(produto);
		return this.produtos.get(index);
	}
	public void atualizar(Produto produto){
		if(!this.produtos.contains(produto)){
			this.cadastrar(produto);
		}
		int index = this.produtos.indexOf(produto);
		this.produtos.set(index, produto);
	}
}
