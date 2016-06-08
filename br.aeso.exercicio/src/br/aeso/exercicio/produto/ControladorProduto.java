package br.aeso.exercicio.produto;

import java.io.IOException;
import java.util.ArrayList;

public class ControladorProduto {
	private IRepositorioProduto repositorio;
	
	public ControladorProduto(String type) throws ClassNotFoundException, IOException {
		if(type.equals("array")){
			this.repositorio = new RepositorioProdutoArray();
		}else if(type.equals("ArrayList")){
			this.repositorio = new RepositorioProdutoArrayList();
		}else if(type.equals("HashMap")){
			this.repositorio = new RepositorioProdutoHashMap();
		}else if(type.equals("HashSet")){
			this.repositorio = new RepositorioProdutoHashSet();
		}
	}
	
	public IRepositorioProduto getRepositorio() {
		return repositorio;
	}

	public void setRepositorio(IRepositorioProduto repositorio) {
		this.repositorio = repositorio;
	}

	public void cadastrar(Produto produto) throws IllegalArgumentException, ProdutoJaCadastradoException, ProdutoNaoEncontradoException, IOException{
		//Imprimir as informações do cliente.
		if(produto == null){
			throw new IllegalArgumentException();
		}
		
		this.repositorio.cadastrar(produto);
	}
	public void atualizar(Produto produto) throws IOException{
		this.repositorio.atualizar(produto);
	}
	public boolean remover(String codigo) throws ProdutoNaoEncontradoException, IOException{
		double dbCodigo = Double.parseDouble(codigo);
		boolean retorno = this.repositorio.remover(dbCodigo);
		if(retorno == false){
			throw new ProdutoNaoEncontradoException();
		}
		return retorno;
	}
	public Produto procurar(String codigo) throws ProdutoNaoEncontradoException{
		double dbCodigo = Double.parseDouble(codigo);
		Produto fornecedor = this.repositorio.procurar(dbCodigo);
		if(fornecedor == null){
			throw new ProdutoNaoEncontradoException();
		}
		return fornecedor;
	}
	public ArrayList<Produto> listar(){
		ArrayList<Produto> lista = this.repositorio.listar();
		return lista;
	}
	public double getNextId(){
		return this.repositorio.getNextId();
	}
}
