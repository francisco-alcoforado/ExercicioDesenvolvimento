package br.aeso.exercicio.produto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import br.aeso.exercicio.arquivos.ArquivosManager;

public class RepositorioProdutoArray implements IRepositorioProduto{
	Produto produtos[] =  new Produto[1];
	private String file = "C:/Users/lab01/git/ExercicioDesenvolvimento/br.aeso.exercicio/arquivos/produtosArray.tmp";
	public RepositorioProdutoArray() throws ClassNotFoundException, IOException {
		ArquivosManager arquivos = new ArquivosManager();
		if(!arquivos.exists(this.file)){
			this.produtos = new Produto[1];
		}else{
			this.produtos = (Produto[]) arquivos.getArray(file);
		}
	}
	public void cadastrar(Produto produto) throws IOException{
		//Imprimir dados do cliente a ser cadastrado
		System.out.println(produto.toString());
		int tamanho = this.produtos.length;
		this.produtos = Arrays.copyOf(this.produtos, this.produtos.length + 1);
		this.produtos[tamanho - 1] = produto;
		this.save();
	}
	private void save() throws IOException{
		ArquivosManager arquivos = new ArquivosManager();
		arquivos.createFile(this.file);
		arquivos.saveArray(this.produtos, this.file);
	}
	public void atualizar(Produto produto) throws IOException{
		for(int i = 0; i < this.produtos.length; i++){
			if(this.produtos[i].getCodigo() == produto.getCodigo()){
				this.produtos[i] = produto;
				this.save();
				break;
			}
		}
	}
	public boolean remover(double codigo) throws IOException{
		Produto newProdutos[] = new Produto[this.produtos.length - 1];
		int x = 0;
		
		if(this.procurar(codigo) == null){
			return false;
		}
		for(int i = 0; i < this.produtos.length; i++){
			if(this.produtos[i].getCodigo() != codigo){
				newProdutos[x++] = this.produtos[i];
			}
		}
		this.save();
		return true;
	}
	public Produto procurar(double codigo){
		for(int i = 0; i < this.produtos.length; i++){
			if(this.produtos[i].getCodigo() == codigo){
				return this.produtos[i];
			}
		}
		return null;
	}
	public ArrayList<Produto> listar(){
		ArrayList<Produto> produtos = new ArrayList<Produto>(Arrays.asList(this.produtos));
		return produtos;
	}
	public double getNextId(){
		if(this.produtos.length == 0){
			return 1;
		}
		Produto produto = this.produtos[this.produtos.length - 1];
		return produto.getCodigo() + 1;
	}
}
