package br.aeso.exercicio.fornecedor;

import java.util.ArrayList;

import br.aeso.exercicio.util.ValidarCNPJ;

public class ControladorFornecedor {
	private IRepositorioFornecedor repositorio;
	public ControladorFornecedor() {
		this.repositorio = new RepositorioFornecedorArray();
	}
	public IRepositorioFornecedor getRepositorio() {
		return repositorio;
	}
	public void setRepositorio(IRepositorioFornecedor repositorio) {
		this.repositorio = repositorio;
	}

	public void cadastrar(Fornecedor fornecedor) throws IllegalArgumentException, FornecedorJaCadastradoException, CNPJInvalidoException, FornecedorNaoEncontradoException{
		//Imprimir as informações do cliente.
		if(fornecedor == null){
			throw new IllegalArgumentException();
		}
		
		if(this.procurar("" + fornecedor.getCodigo()) != null){
			throw new FornecedorJaCadastradoException();
		}
		
		if(ValidarCNPJ.CNPJ(fornecedor.getCnpj()) == false){
			throw new CNPJInvalidoException();
		}
		
		this.repositorio.cadastrar(fornecedor);
	}
	public void atualizar(Fornecedor fornecedor) throws CNPJInvalidoException{
		if(ValidarCNPJ.CNPJ(fornecedor.getCnpj()) == false){
			throw new CNPJInvalidoException();
		}
		
		this.repositorio.atualizar(fornecedor);
	}
	public boolean remover(String codigo) throws FornecedorNaoEncontradoException{
		double dbCodigo = Double.parseDouble(codigo);
		boolean retorno = this.repositorio.remover(dbCodigo);
		if(retorno == false){
			throw new FornecedorNaoEncontradoException();
		}
		return retorno;
	}
	public Fornecedor procurar(String codigo) throws FornecedorNaoEncontradoException{
		double dbCodigo = Double.parseDouble(codigo);
		Fornecedor fornecedor = this.repositorio.procurar(dbCodigo);
		if(fornecedor == null){
			throw new FornecedorNaoEncontradoException();
		}
		return fornecedor;
	}
	public ArrayList<Fornecedor> listar(){
		ArrayList<Fornecedor> lista = this.repositorio.listar();
		return lista;
	}
}
