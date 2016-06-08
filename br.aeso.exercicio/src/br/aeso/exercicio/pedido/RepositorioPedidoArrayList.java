package br.aeso.exercicio.pedido;

import java.io.IOException;
import java.util.ArrayList;

import br.aeso.exercicio.arquivos.ArquivosManager;

public class RepositorioPedidoArrayList implements IRepositorioPedido{
	private ArrayList<Pedido> pedidos;
	private String file = "C:/Users/lab01/git/ExercicioDesenvolvimento/br.aeso.exercicio/arquivos/pedidosArrayList.tmp";
	@SuppressWarnings("unchecked")
	public RepositorioPedidoArrayList() throws ClassNotFoundException, IOException {
		ArquivosManager arquivos = new ArquivosManager();
		if(!arquivos.exists(this.file)){
			arquivos.createFile(this.file);
			this.pedidos = new ArrayList<Pedido>();
		}else{
			this.pedidos = (ArrayList<Pedido>) arquivos.getValores(file);
		}
	}
	public void cadastrar(Pedido pedido) throws IOException{
		if(this.pedidos.contains(pedido)){
			return;
		}
		this.pedidos.add(pedido);
		this.save();
	}
	private void save() throws IOException{
		ArquivosManager arquivos = new ArquivosManager();
		ArrayList<Object> valores = new ArrayList<Object>();
		valores.addAll(this.pedidos);
		arquivos.saveValores(valores, this.file);
	}
	public ArrayList<Pedido> listar(){
		return this.pedidos;
	}
	public boolean remover(Pedido pedido) throws IOException{
		int index = this.pedidos.indexOf(pedido);
		if(index == -1){
			return false;
		}
		this.pedidos.remove(index);
		this.save();
		return true;
	}
	public boolean remover(double codigo) throws IOException{
		for(Pedido pedido : this.pedidos){
			if(pedido.getCodigo() == codigo){
				this.pedidos.remove(pedido);
				this.save();
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
	public void atualizar(Pedido pedido) throws IOException{
		if(!this.pedidos.contains(pedido)){
			this.cadastrar(pedido);
		}
		int index = this.pedidos.indexOf(pedido);
		this.pedidos.set(index, pedido);
		this.save();
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
	public double getNextId(){
		if(this.pedidos.size() == 0){
			return 1;
		}
		Pedido pedido = this.pedidos.get(this.pedidos.size() -1);
		return pedido.getCodigo() + 1;
	}
}
