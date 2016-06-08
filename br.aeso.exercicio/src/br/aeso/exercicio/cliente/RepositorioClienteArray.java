package br.aeso.exercicio.cliente;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import br.aeso.exercicio.arquivos.ArquivosManager;

public class RepositorioClienteArray implements IRepositorioCliente{
	Cliente clientes[];
	private String file = "C:/Users/lab01/git/ExercicioDesenvolvimento/br.aeso.exercicio/arquivos/clientesArray.tmp";
	public RepositorioClienteArray() throws ClassNotFoundException, IOException {
		ArquivosManager arquivos = new ArquivosManager();
		if(!arquivos.exists(this.file)){
			this.clientes = new Cliente[1];
			arquivos.createFile(this.file);
			this.save();
		}else{
			this.clientes = (Cliente[]) arquivos.getArray(file);
		}
	}
	
	public void cadastrar(Cliente cliente) throws IOException{
		//Imprimir dados do cliente a ser cadastrado
		System.out.println(cliente.toString());
		int tamanho = this.clientes.length;
		this.clientes = Arrays.copyOf(this.clientes, this.clientes.length + 1);
		this.clientes[tamanho - 1] = cliente;
		this.save();
	}
	private void save() throws IOException{
		ArquivosManager arquivos = new ArquivosManager();
		arquivos.saveArray(this.clientes, this.file);
	}
	public void atualizar(Cliente cliente) throws IOException{
		for(int i = 0; i < this.clientes.length; i++){
			if(this.clientes[i].getCodigo() == cliente.getCodigo()){
				this.clientes[i] = cliente;
				break;
			}
		}
		this.save();
	}
	public boolean remover(double codigo) throws IOException{
		Cliente newClientes[] = new Cliente[this.clientes.length - 1];
		int x = 0;
		
		if(this.procurar(codigo) == null){
			return false;
		}
		
		for(int i = 0; i < this.clientes.length; i++){
			double dbCodigo = this.clientes[i].getCodigo();
			if(dbCodigo != codigo){
				newClientes[x++] = this.clientes[i];
			}
		}
		this.save();
		return true;
	}
	public Cliente procurar(double codigo){
		for(int i = 0; i < this.clientes.length; i++){
			double dbCodigo = this.clientes[i].getCodigo();
			if(dbCodigo == codigo){
				return this.clientes[i];
			}
		}
		return null;
	}
	public ArrayList<Cliente> listar(){
		ArrayList<Cliente> Clientes = new ArrayList<Cliente>(Arrays.asList(this.clientes));
		return Clientes;
	}
	public double getNextId(){
		if(this.clientes.length == 0){
			return 1;
		}
		Cliente cliente = this.clientes[this.clientes.length - 1];
		return cliente.getCodigo() + 1;
	}
}
