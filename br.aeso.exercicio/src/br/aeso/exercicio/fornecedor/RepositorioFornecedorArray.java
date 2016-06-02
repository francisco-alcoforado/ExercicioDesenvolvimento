package br.aeso.exercicio.fornecedor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import br.aeso.exercicio.arquivos.ArquivosManager;

public class RepositorioFornecedorArray implements IRepositorioFornecedor {
	Fornecedor fornecedores[] =  new Fornecedor[1];
	private String file = "";
	public RepositorioFornecedorArray() throws ClassNotFoundException, IOException {
		ArquivosManager arquivos = new ArquivosManager();
		if(arquivos.exists(file)){
			this.fornecedores = new Fornecedor[1];
		}else{
			this.fornecedores = (Fornecedor[]) arquivos.getArray(file);
		}
	}
	public void cadastrar(Fornecedor fornecedor){
		//Imprimir dados do cliente a ser cadastrado
		System.out.println(fornecedor.toString());
		int tamanho = this.fornecedores.length;
		this.fornecedores = Arrays.copyOf(this.fornecedores, this.fornecedores.length + 1);
		this.fornecedores[tamanho - 1] = fornecedor;
	}
	public void atualizar(Fornecedor fornecedor){
		for(int i = 0; i < this.fornecedores.length; i++){
			if(this.fornecedores[i].getCodigo() == fornecedor.getCodigo()){
				this.fornecedores[i] = fornecedor;
				break;
			}
		}
	}
	public boolean remover(double codigo){
		Fornecedor newFornecedores[] = new Fornecedor[this.fornecedores.length - 1];
		int x = 0;
		
		if(this.procurar(codigo) == null){
			return false;
		}
		for(int i = 0; i < this.fornecedores.length; i++){
			if(this.fornecedores[i].getCodigo() != codigo){
				newFornecedores[x++] = this.fornecedores[i];
			}
		}
		return true;
	}
	public Fornecedor procurar(double codigo){
		for(int i = 0; i < this.fornecedores.length; i++){
			if(this.fornecedores[i].getCodigo() == codigo){
				return this.fornecedores[i];
			}
		}
		return null;
	}
	public ArrayList<Fornecedor> listar(){
		ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>(Arrays.asList(this.fornecedores));
		return fornecedores;
	}
}
