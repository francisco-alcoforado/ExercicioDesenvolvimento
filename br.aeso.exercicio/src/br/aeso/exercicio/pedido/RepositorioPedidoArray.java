package br.aeso.exercicio.pedido;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import br.aeso.exercicio.arquivos.ArquivosManager;

public class RepositorioPedidoArray implements IRepositorioPedido{
	Pedido pedidos[];
	private String file = "C:/Users/lab01/git/ExercicioDesenvolvimento/br.aeso.exercicio/arquivos/pedidosArray.tmp";
	public RepositorioPedidoArray() throws ClassNotFoundException, IOException {
		ArquivosManager arquivos = new ArquivosManager();
		if(!arquivos.exists(this.file)){
			arquivos.createFile(this.file);
			this.pedidos = new Pedido[1];
		}else{
			this.pedidos = (Pedido[]) arquivos.getArray(file);
		}
	}
	public void cadastrar(Pedido pedido) throws IOException{
		//Imprimir dados do cliente a ser cadastrad
		int tamanho = this.pedidos.length;
		this.pedidos = Arrays.copyOf(this.pedidos, this.pedidos.length + 1);
		this.pedidos[tamanho - 1] = pedido;
		this.save();
	}
	private void save() throws IOException{
		ArquivosManager arquivos = new ArquivosManager();
		arquivos.saveArray(this.pedidos, this.file);
	}
	public void atualizar(Pedido pedido) throws IOException{
		for(int i = 0; i < this.pedidos.length; i++){
			if(this.pedidos[i].getCodigo() == pedido.getCodigo()){
				this.pedidos[i] = pedido;
				break;
			}
		}
		this.save();
	}
	public boolean remover(double codigo) throws IOException{
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
		this.save();
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
	public double getNextId(){
		if(this.pedidos.length == 0){
			return 1;
		}
		Pedido pedido = this.pedidos[this.pedidos.length -1];
		return pedido.getCodigo() + 1;
	}
}
