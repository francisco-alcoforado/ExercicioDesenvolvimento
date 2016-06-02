package br.aeso.exercicio.produto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import br.aeso.exercicio.arquivos.ArquivosManager;

public class RepositorioProdutoHashMap implements IRepositorioProduto{
	HashMap<Integer, Produto> produtos;
	private String file = "";
	@SuppressWarnings("unchecked")
	public RepositorioProdutoHashMap() throws ClassNotFoundException, IOException {
		ArquivosManager arquivos = new ArquivosManager();
		if(arquivos.exists(file)){
			this.produtos = new HashMap<Integer, Produto>();
		}else{
			this.produtos = (HashMap<Integer, Produto>) arquivos.getValores(file);
		}
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
