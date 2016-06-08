package br.aeso.exercicio.pedido;

import java.io.Serializable;

public class Pedido implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codigo;
	private int quantidade;
	private double valorProduto;
	private double valorTotal;
	private int codigoProduto;
	private int codigoVendedor;
	private int codigoCliente;
	private String dataPedido;
	private int codigoNotaFiscal;
	public Pedido(int codigo, int quantidade, double valorProduto, double valorTotal, int codigoProduto,
			int codigoVendedor, int codigoCliente, String dataPedido, int codigoNotaFiscal) {
		super();
		this.codigo = codigo;
		this.quantidade = quantidade;
		this.valorProduto = valorProduto;
		this.valorTotal = valorTotal;
		this.codigoProduto = codigoProduto;
		this.codigoVendedor = codigoVendedor;
		this.codigoCliente = codigoCliente;
		this.dataPedido = dataPedido;
		this.codigoNotaFiscal = codigoNotaFiscal;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getValorProduto() {
		return valorProduto;
	}
	public void setValorProduto(double valorProduto) {
		this.valorProduto = valorProduto;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public int getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(int codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	public int getCodigoVendedor() {
		return codigoVendedor;
	}
	public void setCodigoVendedor(int codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}
	public int getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public String getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(String dataPedido) {
		this.dataPedido = dataPedido;
	}
	public int getCodigoNotaFiscal() {
		return codigoNotaFiscal;
	}
	public void setCodigoNotaFiscal(int codigoNotaFiscal) {
		this.codigoNotaFiscal = codigoNotaFiscal;
	}
	@Override
	public String toString() {
		return "Pedido [codigo=" + codigo + ", quantidade=" + quantidade + ", valorProduto=" + valorProduto
				+ ", valorTotal=" + valorTotal + ", codigoProduto=" + codigoProduto + ", codigoVendedor="
				+ codigoVendedor + ", codigoCliente=" + codigoCliente + ", dataPedido=" + dataPedido
				+ ", codigoNotaFiscal=" + codigoNotaFiscal + "]";
	}
}
