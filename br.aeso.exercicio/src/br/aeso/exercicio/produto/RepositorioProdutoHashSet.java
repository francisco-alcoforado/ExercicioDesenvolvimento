package br.aeso.exercicio.produto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import br.aeso.exercicio.arquivos.ArquivosManager;

public class RepositorioProdutoHashSet implements IRepositorioProduto{
	HashSet<Produto> produtos;
	private String file = "";
	@SuppressWarnings("unchecked")
	public RepositorioProdutoHashSet() throws ClassNotFoundException, IOException {
		ArquivosManager arquivos = new ArquivosManager();
		if(arquivos.exists(file)){
			this.produtos = new HashSet<Produto>();
		}else{
			this.produtos = (HashSet<Produto>) arquivos.getValores(file);
		}
	}

	public void cadastrar(Produto produto){
		if(this.produtos.contains(produto)){
			return;
		}
		this.produtos.add(produto);
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
	public boolean remover(Produto produto){
		if(!this.produtos.contains(produto)){
			return false;
		}
		return this.produtos.remove(produto);
	}
	
	public ArrayList<Produto> listar(){
		ArrayList<Produto> produtos = new ArrayList<Produto>(Arrays.asList((Produto[])this.produtos.toArray()));
		return produtos;
		
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
		for(Produto forn : this.produtos){
			if(forn.equals(produto)){
				return forn;
			}
		}
		return null;
	}
	public void atualizar(Produto produto){
		if(!this.produtos.contains(produto)){
			this.cadastrar(produto);
		}
		for(Produto produto2 : this.produtos){
			if(produto2.getCodigo() == produto.getCodigo()){
				this.produtos.remove(produto2);
				this.produtos.add(produto);
			}
		}
	}


}
