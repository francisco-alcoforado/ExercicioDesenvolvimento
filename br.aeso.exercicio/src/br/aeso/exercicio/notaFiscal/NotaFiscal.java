package br.aeso.exercicio.notaFiscal;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import br.aeso.exercicio.cliente.Cliente;
import br.aeso.exercicio.cliente.ClienteNaoExncontradoException;
import br.aeso.exercicio.cliente.ControladorCliente;
import br.aeso.exercicio.pedido.ControladorPedido;
import br.aeso.exercicio.pedido.Pedido;
import br.aeso.exercicio.pedido.PedidoNaoEncontradoException;

public class NotaFiscal implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String dataEmissao;
	private Cliente cliente;
	private ArrayList<Pedido> pedidos;
	private int codigoCliente;
	
	public NotaFiscal(int codigo, String dataEmissao, int codigoCliente) {
		super();
		this.codigo = codigo;
		this.dataEmissao = dataEmissao;
		this.codigoCliente = codigoCliente;
	}
	
	public int getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDataEmissao() {
		return dataEmissao;
	}
	public void setDataEmissao(String dataEmissao) {
		this.dataEmissao = dataEmissao;
	}
	
	public Cliente getCliente() throws ClienteNaoExncontradoException, ClassNotFoundException, IOException {
		if(this.cliente == null){
			this.setCliente();
		}
		return cliente;
	}
	public void setCliente() throws ClienteNaoExncontradoException, ClassNotFoundException, IOException {
		ControladorCliente control = new ControladorCliente("ArrayList");
		this.cliente = control.procurar(this.codigoCliente);
	}
	public ArrayList<Pedido> getPedidos() throws PedidoNaoEncontradoException, ClassNotFoundException, IOException {
		if(!this.pedidos.isEmpty()){
			this.setPedidos();
		}
		return pedidos;
	}
	public void setPedidos() throws PedidoNaoEncontradoException, ClassNotFoundException, IOException{
		ControladorPedido control = new ControladorPedido("ArrayList");
		this.pedidos = control.procurar(this.codigo);
	}
	@Override
	public String toString() {
		return "NotaFiscal [codigo=" + codigo + ", dataEmissao=" + dataEmissao + "]";
	}
}
