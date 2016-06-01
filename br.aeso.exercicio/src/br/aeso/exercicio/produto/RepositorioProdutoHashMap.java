package br.aeso.exercicio.produto;

import java.util.ArrayList;
import java.util.HashMap;

public class RepositorioProdutoHashMap implements IRepositorioProduto{
	HashMap<Integer, Produto> produtos = new HashMap<Integer, Produto>();
	
	public RepositorioProdutoHashMap() {
		// TODO Auto-generated constructor stub
	}

	public void cadastrar(Produto produto){
		if(this.produtos.containsKey(produto.getCodigo())){
			return;
		}
		this.produtos.put(produto.getCodigo(), produto);
	}
	
	public boolean remover(double codigo){
		if(!this.produtos.containsKey(codigo)){
			return false;
		}
		this.produtos.remove(codigo);
		return false;
	}
	public boolean remover(Produto produto){
		if(!this.produtos.containsKey(produto.getCodigo())){
			return false;
		}
		this.produtos.remove(produto.getCodigo());
		return true;
	}
	public ArrayList<Produto> listar(){
		ArrayList<Produto> produtos = new ArrayList<Produto>(this.produtos.values());
		return produtos;
	}
	public Produto procurar(double codigo){
		if(!this.produtos.containsKey(codigo)){
			return null;
		}
		return this.produtos.get(codigo); 
	}
	
	public Produto procurar(Produto produto){
		if(!this.produtos.containsKey(produto.getCodigo())){
			return null;
		}
		return this.produtos.get(produto.getCodigo());
	}
	public void atualizar(Produto produto){
		if(!this.produtos.containsKey(produto.getCodigo())){
			this.cadastrar(produto);
		}
		this.produtos.replace(produto.getCodigo(), produto);
	}
}
