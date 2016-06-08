package br.aeso.exercicio.pedido;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import br.aeso.exercicio.arquivos.ArquivosManager;

public class RepositorioPedidoHashSet implements IRepositorioPedido{
	HashSet<Pedido> pedidos = new HashSet<Pedido>();
	private String file = "C:/Users/lab01/git/ExercicioDesenvolvimento/br.aeso.exercicio/arquivos/pedidosHashSet.tmp";
	@SuppressWarnings("unchecked")
	public RepositorioPedidoHashSet() throws ClassNotFoundException, IOException {
		ArquivosManager arquivos = new ArquivosManager();
		if(!arquivos.exists(this.file)){
			arquivos.createFile(this.file);
			this.pedidos = new HashSet<Pedido>();
		}else{
			this.pedidos = (HashSet<Pedido>) arquivos.getValores(file);
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
		HashSet<Object> valores = new HashSet<Object>();
		valores.addAll(this.pedidos);
		arquivos.saveValores(valores, this.file);
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
	public boolean remover(Pedido pedido) throws IOException{
		if(!this.pedidos.contains(pedido)){
			return false;
		}
		this.pedidos.remove(pedido);
		this.save();
		return true;
		
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
	public void atualizar(Pedido pedido) throws IOException{
		if(!this.pedidos.contains(pedido)){
			this.cadastrar(pedido);
		}
		for(Pedido pedido2 : this.pedidos){
			if(pedido2.getCodigo() == pedido.getCodigo()){
				this.pedidos.remove(pedido2);
				this.pedidos.add(pedido);
			}
		}
		this.save();
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
	public double getNextId(){
		if(this.pedidos.size() == 0){
			return 1;
		}
		return this.pedidos.size() + 1;
	}
}
