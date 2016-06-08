package br.aeso.exercicio.notaFiscal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import br.aeso.exercicio.arquivos.ArquivosManager;

public class RepositorioNotaFiscalHashSet implements IRepositorioNotaFiscal{
	HashSet<NotaFiscal> notaFiscals = new HashSet<NotaFiscal>();
	private String file = "C:/Users/lab01/git/ExercicioDesenvolvimento/br.aeso.exercicio/arquivos/notaFiscalHashSet.tmp";
	@SuppressWarnings("unchecked")
	public RepositorioNotaFiscalHashSet() throws ClassNotFoundException, IOException {
		ArquivosManager arquivos = new ArquivosManager();
		if(!arquivos.exists(this.file)){
			arquivos.createFile(this.file);
			this.notaFiscals = new HashSet<NotaFiscal>();
		}else{
			this.notaFiscals = (HashSet<NotaFiscal>) arquivos.getValores(file);
		}
	}

	public void cadastrar(NotaFiscal notaFiscal) throws IOException{
		if(this.notaFiscals.contains(notaFiscal)){
			return;
		}
		this.notaFiscals.add(notaFiscal);
		this.save();
	}
	
	private void save() throws IOException{
		ArquivosManager arquivos = new ArquivosManager();
		HashSet<Object> valores = new HashSet<Object>();
		valores.addAll(this.notaFiscals);
		arquivos.saveValores(valores, this.file);
	}
	public boolean remover(double codigo) throws IOException{
		for(NotaFiscal notaFiscal : this.notaFiscals){
			if(notaFiscal.getCodigo() == codigo){
				this.notaFiscals.remove(notaFiscal);
				this.save();
				return true;
			}
		}
		return false;
	}
	public boolean remover(NotaFiscal notaFiscal) throws IOException{
		if(!this.notaFiscals.contains(notaFiscal)){
			return false;
		}
		this.notaFiscals.remove(notaFiscal);
		this.save();
		return true;
	}
	
	public ArrayList<NotaFiscal> listar(){
		ArrayList<NotaFiscal> notaFiscals = new ArrayList<NotaFiscal>(Arrays.asList((NotaFiscal[])this.notaFiscals.toArray()));
		return notaFiscals;
		
	}
	public NotaFiscal procurar(double codigo){
		for(NotaFiscal notaFiscal : this.notaFiscals){
			if(notaFiscal.getCodigo() == codigo){
				return notaFiscal;
			}
		}
		return null;
	}
	public NotaFiscal procurar(NotaFiscal notaFiscal){
		if(!this.notaFiscals.contains(notaFiscal)){
			return null;
		}
		for(NotaFiscal forn : this.notaFiscals){
			if(forn.equals(notaFiscal)){
				return forn;
			}
		}
		return null;
	}
	public void atualizar(NotaFiscal notaFiscal) throws IOException{
		if(!this.notaFiscals.contains(notaFiscal)){
			this.cadastrar(notaFiscal);
		}
		for(NotaFiscal notaFiscal2 : this.notaFiscals){
			if(notaFiscal2.getCodigo() == notaFiscal.getCodigo()){
				this.notaFiscals.remove(notaFiscal2);
				this.notaFiscals.add(notaFiscal);
			}
		}
		this.save();
	}
	public double getNextId(){
		if(this.notaFiscals.size() == 0){
			return 1;
		}
		return this.notaFiscals.size() + 1;
	}

}
