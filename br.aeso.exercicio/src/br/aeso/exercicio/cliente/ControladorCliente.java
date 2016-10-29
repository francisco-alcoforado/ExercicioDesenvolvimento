package br.aeso.exercicio.cliente;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import br.aeso.exercicio.util.CPFInvalidoException;
import br.aeso.exercicio.util.ValidarCPF;

public class ControladorCliente {
	private IRepositorioCliente repositorio;
	public ControladorCliente() throws ClassNotFoundException, IOException, SQLException {
		this.repositorio = new RepositorioClienteArrayList();
	}
	public IRepositorioCliente getRepositorio() {
		return repositorio;
	}
	public void setRepositorio(IRepositorioCliente repositorio) {
		this.repositorio = repositorio;
	}

	public void cadastrar(Cliente cliente) throws IllegalArgumentException, CPFInvalidoException, ClienteJaCadastradoException, ClienteNaoExncontradoException, IOException{
		if(cliente == null){
			throw new IllegalArgumentException();
		}
		if(this.procurar(cliente.getCodigo()) != null){
			throw new ClienteJaCadastradoException();
		}
		if(ValidarCPF.CPF(cliente.getCpf()) == false){
			throw new CPFInvalidoException();
		}
		//Imprimir as informa��es do cliente.
		this.repositorio.cadastrar(cliente);
	}
	public void atualizar(Cliente cliente) throws CPFInvalidoException, IOException{
		if(ValidarCPF.CPF(cliente.getCpf()) == false){
			throw new CPFInvalidoException();
		}
		this.repositorio.atualizar(cliente);
	}
	public boolean remover(int codigo) throws ClienteNaoExncontradoException, IOException{
		boolean retorno = this.repositorio.remover(codigo);
		if(retorno == false){
			throw new ClienteNaoExncontradoException();
		}else{
			return true;
		}
	}
	public Cliente procurar(int codigo) throws ClienteNaoExncontradoException{
		Cliente cliente = this.repositorio.procurar(codigo);
		if(cliente == null){
			throw new ClienteNaoExncontradoException();
		}
		
		return cliente;
	}
	public ArrayList<Cliente> listar(){
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		return lista;
	}
}
