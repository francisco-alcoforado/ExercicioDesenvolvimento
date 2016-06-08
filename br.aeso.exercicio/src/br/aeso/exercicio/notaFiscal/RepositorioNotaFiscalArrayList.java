package br.aeso.exercicio.notaFiscal;

import java.io.IOException;
import java.util.ArrayList;

import br.aeso.exercicio.arquivos.ArquivosManager;

public class RepositorioNotaFiscalArrayList implements IRepositorioNotaFiscal{
	private ArrayList<NotaFiscal> notaFiscales;
	private String file = "C:/Users/lab01/git/ExercicioDesenvolvimento/br.aeso.exercicio/arquivos/notaFiscalArrayList.tmp";
	@SuppressWarnings("unchecked")
	public RepositorioNotaFiscalArrayList() throws ClassNotFoundException, IOException {
		ArquivosManager arquivos = new ArquivosManager();
		if(!arquivos.exists(this.file)){
			this.notaFiscales = new ArrayList<NotaFiscal>();
		}else{
			this.notaFiscales = (ArrayList<NotaFiscal>) arquivos.getValores(file);
		}
	}
	
	public void cadastrar(NotaFiscal notaFiscal) throws IOException{
		if(this.notaFiscales.contains(notaFiscal)){
			return;
		}
		this.notaFiscales.add(notaFiscal);
		this.save();
	}
	private void save() throws IOException{
		ArquivosManager arquivos = new ArquivosManager();
		arquivos.createFile(this.file);
		ArrayList<Object> valores = new ArrayList<Object>();
		valores.addAll(this.notaFiscales);
		arquivos.saveValores(valores, this.file);
	}
	public ArrayList<NotaFiscal> listar(){
		return this.notaFiscales;
	}
	public boolean remover(NotaFiscal notaFiscal) throws IOException{
		int index = this.notaFiscales.indexOf(notaFiscal);
		if(index == -1){
			return false;
		}
		this.notaFiscales.remove(index);
		this.save();
		return true;
	}
	public boolean remover(double codigo) throws IOException{
		for(NotaFiscal notaFiscal : this.notaFiscales){
			if(notaFiscal.getCodigo() == codigo){
				this.notaFiscales.remove(notaFiscal);
				this.save();
				return true;
			}
		}
		return false;
	}
	public NotaFiscal procurar(double codigo){
		for(NotaFiscal notaFiscal : this.notaFiscales){
			if(notaFiscal.getCodigo() == codigo){
				return notaFiscal;
			}
		}
		return null;
	}
	public NotaFiscal procurar(NotaFiscal notaFiscal){
		if(!this.notaFiscales.contains(notaFiscal)){
			return null;
		}
		int index = this.notaFiscales.indexOf(notaFiscal);
		return this.notaFiscales.get(index);
	}
	public void atualizar(NotaFiscal notaFiscal) throws IOException{
		if(!this.notaFiscales.contains(notaFiscal)){
			this.cadastrar(notaFiscal);
		}
		int index = this.notaFiscales.indexOf(notaFiscal);
		this.notaFiscales.set(index, notaFiscal);
		this.save();
	}
	public double getNextId(){
		if(this.notaFiscales.size() == 0){
			return 1;
		}
		NotaFiscal notaFiscal = this.notaFiscales.get(this.notaFiscales.size() -1);
		return notaFiscal.getCodigo() + 1;
	}
}
