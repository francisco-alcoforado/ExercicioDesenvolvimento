package br.aeso.exercicio.notaFiscal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorNotaFiscal {
	private IRepositorioNotaFiscal repositorio;
	
	public ControladorNotaFiscal() throws ClassNotFoundException, IOException, SQLException {
		this.repositorio = new RepositorioNotaFiscalArrayList();
	}
	
	public IRepositorioNotaFiscal getRepositorio() {
		return repositorio;
	}


	public void setRepositorio(IRepositorioNotaFiscal repositorio) {
		this.repositorio = repositorio;
	}

	public void cadastrar(NotaFiscal notaFiscal) throws IllegalArgumentException, NotaFiscalJaCadastradaException, NotaFiscalNaoEncontradaException, IOException{
		//Imprimir as informações do cliente.
		if(notaFiscal == null){
			throw new IllegalArgumentException();
		}
		
		if(this.procurar(notaFiscal.getCodigo()) != null){
			throw new NotaFiscalJaCadastradaException();
		}
		
		this.repositorio.cadastrar(notaFiscal);
	}
	public void atualizar(NotaFiscal notaFiscal) throws IOException{
		this.repositorio.atualizar(notaFiscal);
	}
	public boolean remover(int codigo) throws NotaFiscalNaoEncontradaException, IOException{
		boolean retorno = this.repositorio.remover(codigo);
		if(retorno == false){
			throw new NotaFiscalNaoEncontradaException();
		}
		return retorno;
	}
	public NotaFiscal procurar(int codigo) throws NotaFiscalNaoEncontradaException{
		NotaFiscal fornecedor = this.repositorio.procurar(codigo);
		if(fornecedor == null){
			throw new NotaFiscalNaoEncontradaException();
		}
		return fornecedor;
	}
	public ArrayList<NotaFiscal> listar(){
		ArrayList<NotaFiscal> lista = this.repositorio.listar();
		return lista;
	}
}
