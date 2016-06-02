package br.aeso.exercicio.fachada;

import java.io.IOException;
import java.util.ArrayList;
import br.aeso.exercicio.cliente.*;
import br.aeso.exercicio.fornecedor.ControladorFornecedor;
import br.aeso.exercicio.fornecedor.Fornecedor;
import br.aeso.exercicio.fornecedor.FornecedorJaCadastradoException;
import br.aeso.exercicio.fornecedor.FornecedorNaoEncontradoException;
import br.aeso.exercicio.notaFiscal.ControladorNotaFiscal;
import br.aeso.exercicio.notaFiscal.NotaFiscal;
import br.aeso.exercicio.notaFiscal.NotaFiscalJaCadastradaException;
import br.aeso.exercicio.notaFiscal.NotaFiscalNaoEncontradaException;
import br.aeso.exercicio.pedido.ControladorPedido;
import br.aeso.exercicio.pedido.Pedido;
import br.aeso.exercicio.pedido.PedidoJaCadastradoException;
import br.aeso.exercicio.pedido.PedidoNaoEncontradoException;
import br.aeso.exercicio.produto.ControladorProduto;
import br.aeso.exercicio.produto.Produto;
import br.aeso.exercicio.produto.ProdutoJaCadastradoException;
import br.aeso.exercicio.produto.ProdutoNaoEncontradoException;
import br.aeso.exercicio.util.CNPJInvalidoException;
import br.aeso.exercicio.util.CPFInvalidoException;

public class Fachada {
	private String type;
	private ControladorCliente controladorCliente;
	private ControladorFornecedor controladorFornecedor;
	private ControladorPedido controladorPedido;
	private ControladorProduto controladorProduto;
	private ControladorNotaFiscal controladorNotaFiscal;
	public Fachada(String type) {
		this.type = type;
	}
	
	public ControladorCliente getControladorCliente() {
		return controladorCliente;
	}
	public void setControladorCliente(ControladorCliente controladorCliente) {
		this.controladorCliente = controladorCliente;
	}
	public ControladorFornecedor getControladorFornecedor() {
		return controladorFornecedor;
	}

	public void setControladorFornecedor(ControladorFornecedor controladorFornecedor) {
		this.controladorFornecedor = controladorFornecedor;
	}
	
	public ControladorPedido getControladorPedido() {
		return controladorPedido;
	}

	public void setControladorPedido(ControladorPedido controladorPedido) {
		this.controladorPedido = controladorPedido;
	}

	public ControladorProduto getControladorProduto() {
		return controladorProduto;
	}

	public void setControladorProduto(ControladorProduto controladorProduto) {
		this.controladorProduto = controladorProduto;
	}

	public ControladorNotaFiscal getControladorNotaFiscal() {
		return controladorNotaFiscal;
	}

	public void setControladorNotaFiscal(ControladorNotaFiscal controladorNotaFiscal) {
		this.controladorNotaFiscal = controladorNotaFiscal;
	}
	

	public void cadastrarCliente(Cliente cliente) throws IllegalArgumentException, CPFInvalidoException, ClienteJaCadastradoException, ClienteNaoExncontradoException, ClassNotFoundException, IOException{
		this.controladorCliente = new ControladorCliente(this.type);
		this.controladorCliente.cadastrar(cliente);
	}
	public void atualizarCliente(Cliente cliente) throws CPFInvalidoException, ClassNotFoundException, IOException{
		this.controladorCliente = new ControladorCliente(this.type);
		this.controladorCliente.atualizar(cliente);
	}
	public boolean removerCliente(int codigo) throws ClienteNaoExncontradoException, ClassNotFoundException, IOException{
		this.controladorCliente = new ControladorCliente(this.type);
		boolean retorno = this.controladorCliente.remover(codigo);
		return retorno;
	}
	public Cliente procurarCliente(int codigo) throws ClienteNaoExncontradoException, ClassNotFoundException, IOException{
		this.controladorCliente = new ControladorCliente(this.type);
		Cliente cliente = this.controladorCliente.procurar(codigo);
		return cliente;
	}
	public ArrayList<Cliente> listarCliente() throws ClassNotFoundException, IOException{
		this.controladorCliente = new ControladorCliente(this.type);
		ArrayList<Cliente> clientes = this.controladorCliente.listar();
		return clientes;
	}
	
	public void cadastrarFornecedor(Fornecedor fornecedor) throws IllegalArgumentException, FornecedorJaCadastradoException, CNPJInvalidoException, FornecedorNaoEncontradoException, ClassNotFoundException, IOException{
		this.controladorFornecedor = new ControladorFornecedor(this.type);
		this.controladorFornecedor.cadastrar(fornecedor);
	}
	public void atualizarFornecedor(Fornecedor fornecedor) throws FornecedorNaoEncontradoException, CNPJInvalidoException, ClassNotFoundException, IOException{
		this.controladorFornecedor = new ControladorFornecedor(this.type);
		this.controladorFornecedor.atualizar(fornecedor);
	}
	public boolean removerFornecedor(String codigo) throws FornecedorNaoEncontradoException, ClassNotFoundException, IOException{
		this.controladorFornecedor = new ControladorFornecedor(this.type);
		boolean retorno = this.controladorFornecedor.remover(codigo);
		return retorno;
	}
	public Fornecedor procurarFornecedor(String codigo) throws FornecedorNaoEncontradoException, ClassNotFoundException, IOException{
		this.controladorFornecedor = new ControladorFornecedor(this.type);
		Fornecedor fornecedor = this.controladorFornecedor.procurar(codigo);
		return fornecedor;
	}
	public ArrayList<Fornecedor> listarFornecedor() throws ClassNotFoundException, IOException{
		this.controladorFornecedor = new ControladorFornecedor(this.type);
		ArrayList<Fornecedor> lista = this.controladorFornecedor.listar();
		return lista;
	}
	
	public void cadastrarProduto(Produto produto) throws IllegalArgumentException, ProdutoJaCadastradoException, ProdutoNaoEncontradoException, ClassNotFoundException, IOException{
		this.controladorProduto = new ControladorProduto(this.type);
		this.controladorProduto.cadastrar(produto);
	}
	public void atualizarProduto(Produto produto) throws ProdutoNaoEncontradoException, ClassNotFoundException, IOException{
		this.controladorProduto = new ControladorProduto(this.type);
		this.controladorProduto.atualizar(produto);
	}
	public boolean removerProduto(String codigo) throws ProdutoNaoEncontradoException, ClassNotFoundException, IOException{
		this.controladorProduto = new ControladorProduto(this.type);
		boolean retorno = this.controladorProduto.remover(codigo);
		return retorno;
	}
	public Produto procurarProduto(String codigo) throws ProdutoNaoEncontradoException, ClassNotFoundException, IOException{
		this.controladorProduto = new ControladorProduto(this.type);
		Produto produto = this.controladorProduto.procurar(codigo);
		return produto;
	}
	public ArrayList<Produto> listarProduto() throws ClassNotFoundException, IOException{
		this.controladorProduto = new ControladorProduto(this.type);
		ArrayList<Produto> lista = this.controladorProduto.listar();
		return lista;
	}
	
	public void cadastrarPedido(Pedido pedido) throws IllegalArgumentException, PedidoJaCadastradoException, PedidoNaoEncontradoException, ClassNotFoundException, IOException{
		this.controladorPedido = new ControladorPedido(this.type);
		this.controladorPedido.cadastrar(pedido);
	}
	public void atualizarPedido(Pedido pedido) throws PedidoNaoEncontradoException, ClassNotFoundException, IOException{
		this.controladorPedido = new ControladorPedido(this.type);
		this.controladorPedido.atualizar(pedido);
	}
	public boolean removerPedido(String codigo) throws PedidoNaoEncontradoException, ClassNotFoundException, IOException{
		this.controladorPedido = new ControladorPedido(this.type);
		boolean retorno = this.controladorPedido.remover(codigo);
		return retorno;
	}
	public Pedido procurarPedido(String codigo) throws PedidoNaoEncontradoException, ClassNotFoundException, IOException{
		this.controladorPedido = new ControladorPedido(this.type);
		Pedido pedido = this.controladorPedido.procurar(codigo);
		return pedido;
	}
	public ArrayList<Pedido> listarPedido() throws ClassNotFoundException, IOException{
		this.controladorPedido = new ControladorPedido(this.type);
		ArrayList<Pedido> lista = this.controladorPedido.listar();
		return lista;
	}
	
	public void cadastrarNotaFiscal(NotaFiscal notaFiscal) throws IllegalArgumentException, NotaFiscalJaCadastradaException, NotaFiscalNaoEncontradaException, ClassNotFoundException, IOException{
		this.controladorNotaFiscal = new ControladorNotaFiscal(this.type);
		this.controladorNotaFiscal.cadastrar(notaFiscal);
	}
	public void atualizarNotaFiscal(NotaFiscal notaFiscal) throws NotaFiscalJaCadastradaException, ClassNotFoundException, IOException{
		this.controladorNotaFiscal = new ControladorNotaFiscal(this.type);
		this.controladorNotaFiscal.atualizar(notaFiscal);
	}
	public boolean removerNotaFiscal(String codigo) throws NotaFiscalNaoEncontradaException, ClassNotFoundException, IOException{
		this.controladorNotaFiscal = new ControladorNotaFiscal(this.type);
		boolean retorno = this.controladorNotaFiscal.remover(codigo);
		return retorno;
	}
	public NotaFiscal procurarNotaFiscal(String codigo) throws NotaFiscalNaoEncontradaException, ClassNotFoundException, IOException{
		this.controladorNotaFiscal = new ControladorNotaFiscal(this.type);
		NotaFiscal notaFiscal = this.controladorNotaFiscal.procurar(codigo);
		return notaFiscal;
	}
	public ArrayList<NotaFiscal> listarNotaFiscal() throws ClassNotFoundException, IOException{
		this.controladorNotaFiscal = new ControladorNotaFiscal(this.type);
		ArrayList<NotaFiscal> lista = this.controladorNotaFiscal.listar();
		return lista;
	}
}
