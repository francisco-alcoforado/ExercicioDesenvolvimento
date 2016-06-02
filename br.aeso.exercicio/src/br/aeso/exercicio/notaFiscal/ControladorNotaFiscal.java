package br.aeso.exercicio.notaFiscal;

import java.io.IOException;
import java.util.ArrayList;

public class ControladorNotaFiscal {
	private IRepositorioNotaFiscal repositorio;
	
	public ControladorNotaFiscal(String type) throws ClassNotFoundException, IOException {
		if(type.equals("array")){
			this.repositorio = new RepositorioNotaFiscalArray();
		}else if(type.equals("ArrayList")){
			this.repositorio = new RepositorioNotaFiscalArrayList();
		}else if(type.equals("HashMap")){
			this.repositorio = new RepositorioNotaFiscalHashMap();
		}else if(type.equals("HashSet")){
			this.repositorio = new RepositorioNotaFiscalHashSet();
		}
	}
	
	public IRepositorioNotaFiscal getRepositorio() {
		return repositorio;
	}


	public void setRepositorio(IRepositorioNotaFiscal repositorio) {
		this.repositorio = repositorio;
	}

	public void cadastrar(NotaFiscal notaFiscal) throws IllegalArgumentException, NotaFiscalJaCadastradaException, NotaFiscalNaoEncontradaException{
		//Imprimir as informações do cliente.
		if(notaFiscal == null){
			throw new IllegalArgumentException();
		}
		
		if(this.procurar("" + notaFiscal.getCodigo()) != null){
			throw new NotaFiscalJaCadastradaException();
		}
		
		this.repositorio.cadastrar(notaFiscal);
	}
	public void atualizar(NotaFiscal notaFiscal){
		this.repositorio.atualizar(notaFiscal);
	}
	public boolean remover(String codigo) throws NotaFiscalNaoEncontradaException{
		double dbCodigo = Double.parseDouble(codigo);
		boolean retorno = this.repositorio.remover(dbCodigo);
		if(retorno == false){
			throw new NotaFiscalNaoEncontradaException();
		}
		return retorno;
	}
	public NotaFiscal procurar(String codigo) throws NotaFiscalNaoEncontradaException{
		double dbCodigo = Double.parseDouble(codigo);
		NotaFiscal fornecedor = this.repositorio.procurar(dbCodigo);
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
