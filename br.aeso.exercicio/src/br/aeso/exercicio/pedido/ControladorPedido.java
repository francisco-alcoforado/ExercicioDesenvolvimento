package br.aeso.exercicio.pedido;

import java.io.IOException;
import java.util.ArrayList;

public class ControladorPedido {
	private IRepositorioPedido repositorio;
	
	public ControladorPedido(String type) throws ClassNotFoundException, IOException {
		if(type.equals("array")){
			this.repositorio = new RepositorioPedidoArray();
		}else if(type.equals("ArrayList")){
			this.repositorio = new RepositorioPedidoArrayList();
		}else if(type.equals("HashMap")){
			this.repositorio = new RepositorioPedidoHashMap();
		}else if(type.equals("HashSet")){
			this.repositorio = new RepositorioPedidoHashSet();
		}
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
	public void atualizar(Pedido pedido){
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
	public ArrayList<Pedido> procurar(int codigoNotaFiscal) throws PedidoNaoEncontradoException{
		ArrayList<Pedido> pedidos = this.repositorio.procurar(codigoNotaFiscal);
		if(pedidos == null){
			throw new PedidoNaoEncontradoException();
		}
		return pedidos;
	}
	public ArrayList<Pedido> listar(){
		ArrayList<Pedido> lista = this.repositorio.listar();
		return lista;
	}
}
