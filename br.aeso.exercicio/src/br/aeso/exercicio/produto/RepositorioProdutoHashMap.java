package br.aeso.exercicio.produto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import br.aeso.exercicio.arquivos.ArquivosManager;

public class RepositorioProdutoHashMap implements IRepositorioProduto{
	HashMap<Integer, Produto> produtos;
	private String file = "C:/Users/lab01/git/ExercicioDesenvolvimento/br.aeso.exercicio/arquivos/produtosHashMap.tmp";
	@SuppressWarnings("unchecked")
	public RepositorioProdutoHashMap() throws ClassNotFoundException, IOException {
		ArquivosManager arquivos = new ArquivosManager();
		if(!arquivos.exists(this.file)){
			this.produtos = new HashMap<Integer, Produto>();
		}else{
			this.produtos = (HashMap<Integer, Produto>) arquivos.getValores(file);
		}
	}

	public void cadastrar(Produto produto) throws IOException{
		if(this.produtos.containsKey(produto.getCodigo())){
			return;
		}
		this.produtos.put(produto.getCodigo(), produto);
		this.save();
	}
	private void save() throws IOException{
		ArquivosManager arquivos = new ArquivosManager();
		arquivos.createFile(this.file);
		HashMap<Integer, Object> valores = new HashMap<Integer, Object>();
		valores.putAll(this.produtos);
		arquivos.saveValores(valores, this.file);
	}
	public boolean remover(double codigo) throws IOException{
		if(!this.produtos.containsKey(codigo)){
			return false;
		}
		this.produtos.remove(codigo);
		this.save();
		return true;
	}
	public boolean remover(Produto produto) throws IOException{
		if(!this.produtos.containsKey(produto.getCodigo())){
			return false;
		}
		this.produtos.remove(produto.getCodigo());
		this.save();
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
	public void atualizar(Produto produto) throws IOException{
		if(!this.produtos.containsKey(produto.getCodigo())){
			this.cadastrar(produto);
		}
		this.produtos.replace(produto.getCodigo(), produto);
		this.save();
	}
	public double getNextId(){
		if(this.produtos.size() == 0){
			return 1;
		}
		return this.produtos.size() + 1;
	}
}
