package br.aeso.exercicio.fornecedor;

import java.util.ArrayList;
import java.util.Arrays;

public class RepositorioFornecedorArray implements IRepositorioFornecedor {
	Fornecedor fornecedores[] =  new Fornecedor[1];
	public RepositorioFornecedorArray() {
		// TODO Auto-generated constructor stub
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
