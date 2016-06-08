package br.aeso.exercicio.fornecedor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import br.aeso.exercicio.arquivos.ArquivosManager;

public class RepositorioFornecedorArray implements IRepositorioFornecedor {
	Fornecedor fornecedores[] =  new Fornecedor[1];
	private String file = "C:/Users/lab01/git/ExercicioDesenvolvimento/br.aeso.exercicio/arquivos/fornecedoresArray.tmp";
	public RepositorioFornecedorArray() throws ClassNotFoundException, IOException {
		ArquivosManager arquivos = new ArquivosManager();
		if(!arquivos.exists(this.file)){
			this.fornecedores = new Fornecedor[1];
			arquivos.createFile(this.file);
			this.save();
		}else{
			this.fornecedores = (Fornecedor[]) arquivos.getArray(file);
		}
	}
	public void cadastrar(Fornecedor fornecedor) throws IOException{
		//Imprimir dados do cliente a ser cadastrado
		System.out.println(fornecedor.toString());
		int tamanho = this.fornecedores.length;
		this.fornecedores = Arrays.copyOf(this.fornecedores, this.fornecedores.length + 1);
		this.fornecedores[tamanho - 1] = fornecedor;
		this.save();
	}
	private void save() throws IOException{
		ArquivosManager arquivos = new ArquivosManager();
		arquivos.saveArray(this.fornecedores, this.file);
	}
	public void atualizar(Fornecedor fornecedor) throws IOException{
		for(int i = 0; i < this.fornecedores.length; i++){
			if(this.fornecedores[i].getCodigo() == fornecedor.getCodigo()){
				this.fornecedores[i] = fornecedor;
				break;
			}
		}
		this.save();
	}
	public boolean remover(double codigo) throws IOException{
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
		this.save();
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
	public double getNextId(){
		if(this.fornecedores.length == 0){
			return 1;
		}
		Fornecedor fornecedor = this.fornecedores[this.fornecedores.length -1];
		return fornecedor.getCodigo() + 1;
	}
}
