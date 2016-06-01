package br.aeso.exercicio.produto;

import java.util.ArrayList;
import java.util.Arrays;

public class RepositorioProdutoArray implements IRepositorioProduto{
	Produto produtos[] =  new Produto[1];
	
	public RepositorioProdutoArray() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void cadastrar(Produto produto){
		//Imprimir dados do cliente a ser cadastrado
		System.out.println(produto.toString());
		int tamanho = this.produtos.length;
		this.produtos = Arrays.copyOf(this.produtos, this.produtos.length + 1);
		this.produtos[tamanho - 1] = produto;
	}
	public void atualizar(Produto produto){
		for(int i = 0; i < this.produtos.length; i++){
			if(this.produtos[i].getCodigo() == produto.getCodigo()){
				this.produtos[i] = produto;
				break;
			}
		}
	}
	public boolean remover(double codigo){
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
}