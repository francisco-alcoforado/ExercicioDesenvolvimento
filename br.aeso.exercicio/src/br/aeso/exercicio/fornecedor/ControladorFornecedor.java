package br.aeso.exercicio.fornecedor;

import java.util.ArrayList;

public class ControladorFornecedor {
	private IRepositorioFornecedor repositorio;
	public ControladorFornecedor() {
	}
	public IRepositorioFornecedor getRepositorio() {
		return repositorio;
	}
	public void setRepositorio(IRepositorioFornecedor repositorio) {
		this.repositorio = repositorio;
	}

	public void cadastrar(Fornecedor fornecedor){
		//Imprimir as informações do cliente.
		this.repositorio = new RepositorioFornecedorArray();
		this.repositorio.cadastrar(fornecedor);
	}
	public void atualizar(Fornecedor fornecedor){
		this.repositorio = new RepositorioFornecedorArray();
		this.repositorio.atualizar(fornecedor);
	}
	public boolean remover(String codigo){
		this.repositorio = new RepositorioFornecedorArray();
		double dbCodigo = Double.parseDouble(codigo);
		boolean retorno = this.repositorio.remover(dbCodigo);
		return retorno;
	}
	public Fornecedor procurar(String codigo){
		this.repositorio = new RepositorioFornecedorArray();
		double dbCodigo = Double.parseDouble(codigo);
		Fornecedor fornecedor = this.repositorio.procurar(dbCodigo);
		return fornecedor;
	}
	public ArrayList<Fornecedor> listar(){
		this.repositorio = new RepositorioFornecedorArray();
		ArrayList<Fornecedor> lista = this.repositorio.listar();
		return lista;
	}
}
