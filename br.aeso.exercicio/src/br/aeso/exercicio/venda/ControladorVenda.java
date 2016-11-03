package br.aeso.exercicio.venda;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import br.aeso.exercicio.venda.Venda;
import br.aeso.exercicio.venda.VendaJaCadastradaException;
import br.aeso.exercicio.venda.VendaNaoEncontradaException;
import br.aeso.exercicio.venda.IRepositorioVenda;
import br.aeso.exercicio.venda.RepositorioVendaArrayList;

public class ControladorVenda {
	
	private IRepositorioVenda repositorio;
	public ControladorVenda() throws ClassNotFoundException, IOException, SQLException {
		this.repositorio = new RepositorioVendaArrayList();
	}
	public IRepositorioVenda getRepositorio() {
		return repositorio;
	}
	public void setRepositorio(IRepositorioVenda repositorio) {
		this.repositorio = repositorio;
	}

	public void cadastrar(Venda venda) throws IllegalArgumentException, VendaJaCadastradaException, VendaNaoEncontradaException, IOException{
		if(venda == null){
			throw new IllegalArgumentException();
		}
		if(this.procurar(venda.getCodigo()) != null){
			throw new VendaJaCadastradaException();
		}
		
		//Imprimir as informações do venda.
		this.repositorio.cadastrar(venda);
	}
	public void atualizar(Venda venda) throws IOException{
		this.repositorio.atualizar(venda);
	}
	public boolean remover(int codigo) throws VendaNaoEncontradaException, IOException{
		boolean retorno = this.repositorio.remover(codigo);
		if(retorno == false){
			throw new VendaNaoEncontradaException();
		}else{
			return true;
		}
	}
	public Venda procurar(int codigo) throws VendaNaoEncontradaException{
		Venda venda = this.repositorio.procurar(codigo);
		if(venda == null){
			throw new VendaNaoEncontradaException();
		}
		
		return venda;
	}
	public ArrayList<Venda> listar(){
		ArrayList<Venda> lista = new ArrayList<Venda>();
		return lista;
	}
}
