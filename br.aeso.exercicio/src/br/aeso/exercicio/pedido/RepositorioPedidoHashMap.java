package br.aeso.exercicio.pedido;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import br.aeso.exercicio.arquivos.ArquivosManager;

public class RepositorioPedidoHashMap implements IRepositorioPedido{
	HashMap<Integer, Pedido> pedidos;
	private String file = "";
	@SuppressWarnings("unchecked")
	public RepositorioPedidoHashMap() throws ClassNotFoundException, IOException {
		ArquivosManager arquivos = new ArquivosManager();
		if(arquivos.exists(file)){
			this.pedidos = new HashMap<Integer, Pedido>();
		}else{
			this.pedidos = (HashMap<Integer, Pedido>) arquivos.getValores(file);
		}
	}

	public void cadastrar(Pedido pedido){
		if(this.pedidos.containsKey(pedido.getCodigo())){
			return;
		}
		this.pedidos.put(pedido.getCodigo(), pedido);
	}
	
	public boolean remover(double codigo){
		if(!this.pedidos.containsKey(codigo)){
			return false;
		}
		this.pedidos.remove(codigo);
		return false;
	}
	public boolean remover(Pedido pedido){
		if(!this.pedidos.containsKey(pedido.getCodigo())){
			return false;
		}
		this.pedidos.remove(pedido.getCodigo());
		return true;
	}
	public ArrayList<Pedido> listar(){
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>(this.pedidos.values());
		return pedidos;
	}
	public Pedido procurar(double codigo){
		if(!this.pedidos.containsKey(codigo)){
			return null;
		}
		return this.pedidos.get(codigo); 
	}
	
	public Pedido procurar(Pedido pedido){
		if(!this.pedidos.containsKey(pedido.getCodigo())){
			return null;
		}
		return this.pedidos.get(pedido.getCodigo());
	}
	public void atualizar(Pedido pedido){
		if(!this.pedidos.containsKey(pedido.getCodigo())){
			this.cadastrar(pedido);
		}
		this.pedidos.replace(pedido.getCodigo(), pedido);
	}
	public ArrayList<Pedido> procurar(int codigoNotaFiscal){
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		ArrayList<Pedido> todos = this.listar();
		for(Pedido pedido : todos){
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
