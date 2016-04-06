package br.aeso.exercicio.fachada;

import java.util.ArrayList;
import br.aeso.exercicio.cliente.*;
import br.aeso.exercicio.fornecedor.CNPJInvalidoException;
import br.aeso.exercicio.fornecedor.ControladorFornecedor;
import br.aeso.exercicio.fornecedor.Fornecedor;
import br.aeso.exercicio.fornecedor.FornecedorJaCadastradoException;
import br.aeso.exercicio.fornecedor.FornecedorNaoEncontradoException;

public class Fachada {
	private ControladorCliente controladorCliente;
	private ControladorFornecedor controladorFornecedor;
	public Fachada() {
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
	
	

	public void cadastrarCliente(Cliente cliente) throws IllegalArgumentException, CPFInvalidoException, ClienteJaCadastradoException, ClienteNaoExncontradoException{
		this.controladorCliente = new ControladorCliente();
		this.controladorCliente.cadastrar(cliente);
	}
	public void atualizarCliente(Cliente cliente) throws CPFInvalidoException{
		this.controladorCliente = new ControladorCliente();
		this.controladorCliente.atualizar(cliente);
	}
	public boolean removerCliente(String codigo) throws ClienteNaoExncontradoException{
		this.controladorCliente = new ControladorCliente();
		boolean retorno = this.controladorCliente.remover(codigo);
		return retorno;
	}
	public Cliente procurarCliente(String codigo) throws ClienteNaoExncontradoException{
		this.controladorCliente = new ControladorCliente();
		Cliente cliente = this.controladorCliente.procurar(codigo);
		return cliente;
	}
	public ArrayList<Cliente> listarCliente(){
		this.controladorCliente = new ControladorCliente();
		ArrayList<Cliente> clientes = this.controladorCliente.listar();
		return clientes;
	}
	public void cadastrarFornecedor(Fornecedor fornecedor) throws IllegalArgumentException, FornecedorJaCadastradoException, CNPJInvalidoException, FornecedorNaoEncontradoException{
		this.controladorFornecedor = new ControladorFornecedor();
		this.controladorFornecedor.cadastrar(fornecedor);
	}
	public void atualizarFornecedor(Fornecedor fornecedor) throws FornecedorNaoEncontradoException, CNPJInvalidoException{
		this.controladorFornecedor = new ControladorFornecedor();
		this.controladorFornecedor.atualizar(fornecedor);
	}
	public boolean removerFornecedor(String codigo) throws FornecedorNaoEncontradoException{
		this.controladorFornecedor = new ControladorFornecedor();
		boolean retorno = this.controladorFornecedor.remover(codigo);
		return retorno;
	}
	public Fornecedor procurarFornecedor(String codigo) throws FornecedorNaoEncontradoException{
		this.controladorFornecedor = new ControladorFornecedor();
		Fornecedor fornecedor = this.controladorFornecedor.procurar(codigo);
		return fornecedor;
	}
	public ArrayList<Fornecedor> listarFornecedor(){
		this.controladorFornecedor = new ControladorFornecedor();
		ArrayList<Fornecedor> lista = this.controladorFornecedor.listar();
		return lista;
	}
}
