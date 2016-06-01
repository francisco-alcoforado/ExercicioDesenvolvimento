package br.aeso.exercicio.pedido;

import java.util.ArrayList;

public class RepositorioPedidoArrayList implements IRepositorioPedido{
	private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	
	public RepositorioPedidoArrayList() {
	// TODO Auto-generated constructor stub
	}
	public void cadastrar(Pedido pedido){
		if(this.pedidos.contains(pedido)){
			return;
		}
		this.pedidos.add(pedido);
	}
	public ArrayList<Pedido> listar(){
		return this.pedidos;
	}
	public boolean remover(Pedido pedido){
		int index = this.pedidos.indexOf(pedido);
		if(index == -1){
			return false;
		}
		this.pedidos.remove(index);
		return true;
	}
	public boolean remover(double codigo){
		for(Pedido pedido : this.pedidos){
			if(pedido.getCodigo() == codigo){
				this.pedidos.remove(pedido);
				return true;
			}
		}
		return false;
	}
	public Pedido procurar(double codigo){
		for(Pedido pedido : this.pedidos){
			if(pedido.getCodigo() == codigo){
				return pedido;
			}
		}
		return null;
	}
	public Pedido procurar(Pedido pedido){
		if(!this.pedidos.contains(pedido)){
			return null;
		}
		int index = this.pedidos.indexOf(pedido);
		return this.pedidos.get(index);
	}
	public void atualizar(Pedido pedido){
		if(!this.pedidos.contains(pedido)){
			this.cadastrar(pedido);
		}
		int index = this.pedidos.indexOf(pedido);
		this.pedidos.set(index, pedido);
	}
}
