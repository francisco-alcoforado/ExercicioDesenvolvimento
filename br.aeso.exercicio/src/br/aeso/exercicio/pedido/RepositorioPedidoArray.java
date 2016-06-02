package br.aeso.exercicio.pedido;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import br.aeso.exercicio.arquivos.ArquivosManager;

public class RepositorioPedidoArray implements IRepositorioPedido{
	Pedido pedidos[];
	private String file = "";
	public RepositorioPedidoArray() throws ClassNotFoundException, IOException {
		ArquivosManager arquivos = new ArquivosManager();
		if(arquivos.exists(file)){
			this.pedidos = new Pedido[1];
		}else{
			this.pedidos = (Pedido[]) arquivos.getArray(file);
		}
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
	public ArrayList<Pedido> procurar(int codigoNotaFiscal){
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		for(Pedido pedido : this.pedidos){
			if(pedido.getCodigoNotaFiscal() == codigoNotaFiscal){
				pedidos.add(pedido);
			}
		}
		if(pedidos.isEmpty()){
			return null;
		}
		return pedidos;
	}
}
