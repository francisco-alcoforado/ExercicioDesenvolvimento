package br.aeso.exercicio.pedido;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorPedido {
	private IRepositorioPedido repositorio;
	
	public ControladorPedido() throws ClassNotFoundException, IOException, SQLException {
		this.repositorio = new RepositorioPedidoArrayList();
	}
	
	public IRepositorioPedido getRepositorio() {
		return repositorio;
	}

	public void setRepositorio(IRepositorioPedido repositorio) {
		this.repositorio = repositorio;
	}

	public void cadastrar(Pedido pedido) throws IllegalArgumentException, PedidoJaCadastradoException, PedidoNaoEncontradoException, IOException{
		//Imprimir as informações do cliente.
		if(pedido == null){
			throw new IllegalArgumentException();
		}
		
		if(this.procurar(pedido.getCodigo()) != null){
			throw new PedidoJaCadastradoException();
		}
		
		this.repositorio.cadastrar(pedido);
	}
	public void atualizar(Pedido pedido) throws IOException{
		this.repositorio.atualizar(pedido);
	}
	public boolean remover(String codigo) throws PedidoNaoEncontradoException, IOException{
		double dbCodigo = Double.parseDouble(codigo);
		boolean retorno = this.repositorio.remover(dbCodigo);
		if(retorno == false){
			throw new PedidoNaoEncontradoException();
		}
		return retorno;
	}
	public Pedido procurar(int codigo) throws PedidoNaoEncontradoException{
		Pedido pedido = this.repositorio.procurar(codigo);
		if(pedido == null){
			throw new PedidoNaoEncontradoException();
		}
		return pedido;
	}
	public ArrayList<Pedido> listar(){
		ArrayList<Pedido> lista = this.repositorio.listar();
		return lista;
	}
}
