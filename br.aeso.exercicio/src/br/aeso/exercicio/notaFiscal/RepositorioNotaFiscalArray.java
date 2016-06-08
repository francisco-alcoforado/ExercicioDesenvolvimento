package br.aeso.exercicio.notaFiscal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import br.aeso.exercicio.arquivos.ArquivosManager;

public class RepositorioNotaFiscalArray implements IRepositorioNotaFiscal{
	NotaFiscal notaFiscals[] =  new NotaFiscal[1];
	private String file = "C:/Users/lab01/git/ExercicioDesenvolvimento/br.aeso.exercicio/arquivos/notaFiscalArray.tmp";
	public RepositorioNotaFiscalArray() throws ClassNotFoundException, IOException {
		ArquivosManager arquivos = new ArquivosManager();
		if(!arquivos.exists(this.file)){
			arquivos.createFile(this.file);
			this.notaFiscals = new NotaFiscal[1];
		}else{
			this.notaFiscals = (NotaFiscal[]) arquivos.getArray(file);
		}
	}
	public void cadastrar(NotaFiscal notaFiscal) throws IOException{
		//Imprimir dados do cliente a ser cadastrado
		System.out.println(notaFiscal.toString());
		int tamanho = this.notaFiscals.length;
		this.notaFiscals = Arrays.copyOf(this.notaFiscals, this.notaFiscals.length + 1);
		this.notaFiscals[tamanho - 1] = notaFiscal;
		this.save();
	}
	private void save() throws IOException{
		ArquivosManager arquivos = new ArquivosManager();
		arquivos.saveArray(this.notaFiscals, this.file);
	}
	public void atualizar(NotaFiscal notaFiscal) throws IOException{
		for(int i = 0; i < this.notaFiscals.length; i++){
			if(this.notaFiscals[i].getCodigo() == notaFiscal.getCodigo()){
				this.notaFiscals[i] = notaFiscal;
				break;
			}
		}
		this.save();
	}
	public boolean remover(double codigo) throws IOException{
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
		this.save();
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
	public double getNextId(){
		if(this.notaFiscals.length == 0){
			return 1;
		}
		NotaFiscal notaFiscal = this.notaFiscals[this.notaFiscals.length -1];
		return notaFiscal.getCodigo() + 1;
	}
}
