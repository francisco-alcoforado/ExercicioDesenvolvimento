package br.aeso.exercicio.pedido;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import br.aeso.exercicio.arquivos.ArquivosManager;

public class RepositorioPedidoHashMap implements IRepositorioPedido{
	HashMap<Integer, Pedido> pedidos;
	private String file = "C:/Users/lab01/git/ExercicioDesenvolvimento/br.aeso.exercicio/arquivos/pedidosHashMap.tmp";
	@SuppressWarnings("unchecked")
	public RepositorioPedidoHashMap() throws ClassNotFoundException, IOException {
		ArquivosManager arquivos = new ArquivosManager();
		if(!arquivos.exists(this.file)){
			arquivos.createFile(this.file);
			this.pedidos = new HashMap<Integer, Pedido>();
		}else{
			this.pedidos = (HashMap<Integer, Pedido>) arquivos.getValores(file);
		}
	}

	public void cadastrar(Pedido pedido) throws IOException{
		if(this.pedidos.containsKey(pedido.getCodigo())){
			return;
		}
		this.pedidos.put(pedido.getCodigo(), pedido);
		this.save();
	}
	private void save() throws IOException{
		ArquivosManager arquivos = new ArquivosManager();
		HashMap<Integer, Object> valores = new HashMap<Integer, Object>();
		valores.putAll(this.pedidos);
		arquivos.saveValores(valores, this.file);
	}
	public boolean remover(double codigo) throws IOException{
		if(!this.pedidos.containsKey(codigo)){
			return false;
		}
		this.pedidos.remove(codigo);
		this.save();
		return true;
	}
	public boolean remover(Pedido pedido) throws IOException{
		if(!this.pedidos.containsKey(pedido.getCodigo())){
			return false;
		}
		this.pedidos.remove(pedido.getCodigo());
		this.save();
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
	public void atualizar(Pedido pedido) throws IOException{
		if(!this.pedidos.containsKey(pedido.getCodigo())){
			this.cadastrar(pedido);
		}
		this.pedidos.replace(pedido.getCodigo(), pedido);
		this.save();
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
	public double getNextId(){
		if(this.pedidos.size() == 0){
			return 1;
		}
		return this.pedidos.size() + 1;
	}
}
