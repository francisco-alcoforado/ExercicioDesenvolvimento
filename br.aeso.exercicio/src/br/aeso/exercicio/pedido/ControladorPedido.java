package br.aeso.exercicio.pedido;

import java.util.ArrayList;

import br.aeso.exercicio.util.CNPJInvalidoException;

public class ControladorPedido {
	private IRepositorioPedido repositorio;
	
	public ControladorPedido() {
		// TODO Auto-generated constructor stub
	}
	
	public IRepositorioPedido getRepositorio() {
		return repositorio;
	}

	public void setRepositorio(IRepositorioPedido repositorio) {
		this.repositorio = repositorio;
	}

	public void cadastrar(Pedido pedido) throws IllegalArgumentException, PedidoJaCadastradoException, PedidoNaoEncontradoException{
		//Imprimir as informações do cliente.
		if(pedido == null){
			throw new IllegalArgumentException();
		}
		
		if(this.procurar("" + pedido.getCodigo()) != null){
			throw new PedidoJaCadastradoException();
		}
		
		this.repositorio.cadastrar(pedido);
	}
	public void atualizar(Pedido pedido) throws CNPJInvalidoException{
		this.repositorio.atualizar(pedido);
	}
	public boolean remover(String codigo) throws PedidoNaoEncontradoException{
		double dbCodigo = Double.parseDouble(codigo);
		boolean retorno = this.repositorio.remover(dbCodigo);
		if(retorno == false){
			throw new PedidoNaoEncontradoException();
		}
		return retorno;
	}
	public Pedido procurar(String codigo) throws PedidoNaoEncontradoException{
		double dbCodigo = Double.parseDouble(codigo);
		Pedido pedido = this.repositorio.procurar(dbCodigo);
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
