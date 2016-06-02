package br.aeso.exercicio.pedido;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import br.aeso.exercicio.arquivos.ArquivosManager;

public class RepositorioPedidoHashSet implements IRepositorioPedido{
	HashSet<Pedido> pedidos = new HashSet<Pedido>();
	private String file = "";
	@SuppressWarnings("unchecked")
	public RepositorioPedidoHashSet() throws ClassNotFoundException, IOException {
		ArquivosManager arquivos = new ArquivosManager();
		if(arquivos.exists(file)){
			this.pedidos = new HashSet<Pedido>();
		}else{
			this.pedidos = (HashSet<Pedido>) arquivos.getValores(file);
		}
	}

	public void cadastrar(Pedido pedido){
		if(this.pedidos.contains(pedido)){
			return;
		}
		this.pedidos.add(pedido);
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
	public boolean remover(Pedido pedido){
		if(!this.pedidos.contains(pedido)){
			return false;
		}
		return this.pedidos.remove(pedido);
	}
	
	public ArrayList<Pedido> listar(){
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>(Arrays.asList((Pedido[])this.pedidos.toArray()));
		return pedidos;
		
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
		for(Pedido forn : this.pedidos){
			if(forn.equals(pedido)){
				return forn;
			}
		}
		return null;
	}
	public void atualizar(Pedido pedido){
		if(!this.pedidos.contains(pedido)){
			this.cadastrar(pedido);
		}
		for(Pedido pedido2 : this.pedidos){
			if(pedido2.getCodigo() == pedido.getCodigo()){
				this.pedidos.remove(pedido2);
				this.pedidos.add(pedido);
			}
		}
	}
	public ArrayList<br.aeso.exercicio.pedido.Pedido> procurar(int codigoNotaFiscal) {
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
