package br.aeso.exercicio.produto;

import java.io.IOException;
import java.util.ArrayList;

import br.aeso.exercicio.arquivos.ArquivosManager;

public class RepositorioProdutoArrayList implements IRepositorioProduto{
	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	private String file = "C:/Users/lab01/git/ExercicioDesenvolvimento/br.aeso.exercicio/arquivos/produtosArrayList.tmp";
	@SuppressWarnings("unchecked")
	public RepositorioProdutoArrayList() throws ClassNotFoundException, IOException {
		ArquivosManager arquivos = new ArquivosManager();
		if(!arquivos.exists(this.file)){
			this.produtos = new ArrayList<Produto>();
		}else{
			this.produtos = (ArrayList<Produto>) arquivos.getValores(this.file);
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
		ArrayList<Object> valores = new ArrayList<Object>();
		valores.addAll(this.produtos);
		arquivos.saveValores(valores, this.file);
	}
	public ArrayList<Produto> listar(){
		return this.produtos;
	}
	public boolean remover(Produto produto) throws IOException{
		int index = this.produtos.indexOf(produto);
		if(index == -1){
			return false;
		}
		this.produtos.remove(index);
		this.save();
		return true;
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
	public void atualizar(Produto produto) throws IOException{
		if(!this.produtos.contains(produto)){
			this.cadastrar(produto);
		}
		int index = this.produtos.indexOf(produto);
		this.produtos.set(index, produto);
		this.save();
	}
	public double getNextId(){
		if(this.produtos.size() == 0){
			return 1;
		}
		Produto produto = this.produtos.get(this.produtos.size() - 1);
		return produto.getCodigo() + 1;
		
		
	}
}
