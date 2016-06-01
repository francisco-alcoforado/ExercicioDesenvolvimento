package br.aeso.exercicio.pedido;

import java.util.ArrayList;
import java.util.Arrays;

public class RepositorioPedidoArray implements IRepositorioPedido{
	Pedido pedidos[] =  new Pedido[1];
	public RepositorioPedidoArray() {
		// TODO Auto-generated constructor stub
	}
	public void cadastrar(Pedido pedido){
		//Imprimir dados do cliente a ser cadastrad
		int tamanho = this.pedidos.length;
		this.pedidos = Arrays.copyOf(this.pedidos, this.pedidos.length + 1);
		this.pedidos[tamanho - 1] = pedido;
	}
	public void atualizar(Pedido pedido){
		for(int i = 0; i < this.pedidos.length; i++){
			if(this.pedidos[i].getCodigo() == pedido.getCodigo()){
				this.pedidos[i] = pedido;
				break;
			}
		}
	}
	public boolean remover(double codigo){
		Pedido newPedidos[] = new Pedido[this.pedidos.length - 1];
		int x = 0;
		
		if(this.procurar(codigo) == null){
			return false;
		}
		for(int i = 0; i < this.pedidos.length; i++){
			if(this.pedidos[i].getCodigo() != codigo){
				newPedidos[x++] = this.pedidos[i];
			}
		}
		return true;
	}
	public Pedido procurar(double codigo){
		for(int i = 0; i < this.pedidos.length; i++){
			if(this.pedidos[i].getCodigo() == codigo){
				return this.pedidos[i];
			}
		}
		return null;
	}
	public ArrayList<Pedido> listar(){
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>(Arrays.asList(this.pedidos));
		return pedidos;
	}
}
