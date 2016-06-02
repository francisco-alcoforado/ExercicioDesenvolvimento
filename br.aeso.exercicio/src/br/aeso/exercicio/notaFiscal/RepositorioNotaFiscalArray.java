package br.aeso.exercicio.notaFiscal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import br.aeso.exercicio.arquivos.ArquivosManager;

public class RepositorioNotaFiscalArray implements IRepositorioNotaFiscal{
	NotaFiscal notaFiscals[] =  new NotaFiscal[1];
	private String file = "";
	public RepositorioNotaFiscalArray() throws ClassNotFoundException, IOException {
		ArquivosManager arquivos = new ArquivosManager();
		if(arquivos.exists(file)){
			this.notaFiscals = new NotaFiscal[1];
		}else{
			this.notaFiscals = (NotaFiscal[]) arquivos.getArray(file);
		}
	}
	public void cadastrar(NotaFiscal notaFiscal){
		//Imprimir dados do cliente a ser cadastrado
		System.out.println(notaFiscal.toString());
		int tamanho = this.notaFiscals.length;
		this.notaFiscals = Arrays.copyOf(this.notaFiscals, this.notaFiscals.length + 1);
		this.notaFiscals[tamanho - 1] = notaFiscal;
	}
	public void atualizar(NotaFiscal notaFiscal){
		for(int i = 0; i < this.notaFiscals.length; i++){
			if(this.notaFiscals[i].getCodigo() == notaFiscal.getCodigo()){
				this.notaFiscals[i] = notaFiscal;
				break;
			}
		}
	}
	public boolean remover(double codigo){
		NotaFiscal newNotaFiscals[] = new NotaFiscal[this.notaFiscals.length - 1];
		int x = 0;
		
		if(this.procurar(codigo) == null){
			return false;
		}
		for(int i = 0; i < this.notaFiscals.length; i++){
			if(this.notaFiscals[i].getCodigo() != codigo){
				newNotaFiscals[x++] = this.notaFiscals[i];
			}
		}
		return true;
	}
	public NotaFiscal procurar(double codigo){
		for(int i = 0; i < this.notaFiscals.length; i++){
			if(this.notaFiscals[i].getCodigo() == codigo){
				return this.notaFiscals[i];
			}
		}
		return null;
	}
	public ArrayList<NotaFiscal> listar(){
		ArrayList<NotaFiscal> notaFiscals = new ArrayList<NotaFiscal>(Arrays.asList(this.notaFiscals));
		return notaFiscals;
	}
}
