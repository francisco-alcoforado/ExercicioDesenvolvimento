package br.aeso.exercicio.produto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import br.aeso.exercicio.arquivos.ArquivosManager;

public class RepositorioProdutoHashSet implements IRepositorioProduto{
	HashSet<Produto> produtos;
	private String file = "C:/Users/lab01/git/ExercicioDesenvolvimento/br.aeso.exercicio/arquivos/produtosHashSet.tmp";
	@SuppressWarnings("unchecked")
	public RepositorioProdutoHashSet() throws ClassNotFoundException, IOException {
		ArquivosManager arquivos = new ArquivosManager();
		if(!arquivos.exists(this.file)){
			this.produtos = new HashSet<Produto>();
		}else{
			this.produtos = (HashSet<Produto>) arquivos.getValores(file);
		}
	}

	public void cadastrar(Produto produto) throws IOException{
		if(this.produtos.contains(produto)){
			return;
		}
		this.produtos.add(produto);
		this.save();
	}
	private void save() throws IOException{
		ArquivosManager arquivos = new ArquivosManager();
		arquivos.createFile(this.file);
		HashSet<Object> valores = new HashSet<Object>();
		valores.addAll(this.produtos);
		arquivos.saveValores(valores, this.file);
	}
	public boolean remover(double codigo) throws IOException{
		for(Produto produto : this.produtos){
			if(produto.getCodigo() == codigo){
				this.produtos.remove(produto);
				this.save();
				return true;
			}
		}
		return false;
	}
	public boolean remover(Produto produto) throws IOException{
		if(!this.produtos.contains(produto)){
			return false;
		}
		this.produtos.remove(produto);
		this.save();
		return true;
	
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
	public void atualizar(Produto produto) throws IOException{
		if(!this.produtos.contains(produto)){
			this.cadastrar(produto);
		}
		for(Produto produto2 : this.produtos){
			if(produto2.getCodigo() == produto.getCodigo()){
				this.produtos.remove(produto2);
				this.produtos.add(produto);
			}
		}
		this.save();
	}
	public double getNextId(){
		if(this.produtos.size() == 0){
			return 1;
		}
		return this.produtos.size() + 1;
	}


}
