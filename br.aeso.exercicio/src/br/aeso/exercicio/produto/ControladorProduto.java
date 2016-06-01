package br.aeso.exercicio.produto;

import java.util.ArrayList;

public class ControladorProduto {
	private IRepositorioProduto repositorio;
	
	public ControladorProduto(IRepositorioProduto repositorio) {
		this.repositorio = repositorio;
	}
	
	public IRepositorioProduto getRepositorio() {
		return repositorio;
	}

	public void setRepositorio(IRepositorioProduto repositorio) {
		this.repositorio = repositorio;
	}

	public void cadastrar(Produto produto) throws IllegalArgumentException, ProdutoJaCadastradoException, ProdutoNaoEncontradoException{
		//Imprimir as informações do cliente.
		if(produto == null){
			throw new IllegalArgumentException();
		}
		
		if(this.procurar("" + produto.getCodigo()) != null){
			throw new ProdutoJaCadastradoException();
		}
		
		this.repositorio.cadastrar(produto);
	}
	public void atualizar(Produto produto){
		this.repositorio.atualizar(produto);
	}
	public boolean remover(String codigo) throws ProdutoNaoEncontradoException{
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
}
