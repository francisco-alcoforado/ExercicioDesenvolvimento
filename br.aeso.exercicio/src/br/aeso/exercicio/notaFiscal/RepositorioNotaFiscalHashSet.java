package br.aeso.exercicio.notaFiscal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import br.aeso.exercicio.arquivos.ArquivosManager;

public class RepositorioNotaFiscalHashSet implements IRepositorioNotaFiscal{
	HashSet<NotaFiscal> notaFiscals = new HashSet<NotaFiscal>();
	private String file = "";
	@SuppressWarnings("unchecked")
	public RepositorioNotaFiscalHashSet() throws ClassNotFoundException, IOException {
		ArquivosManager arquivos = new ArquivosManager();
		if(arquivos.exists(file)){
			this.notaFiscals = new HashSet<NotaFiscal>();
		}else{
			this.notaFiscals = (HashSet<NotaFiscal>) arquivos.getValores(file);
		}
	}

	public void cadastrar(NotaFiscal notaFiscal){
		if(this.notaFiscals.contains(notaFiscal)){
			return;
		}
		this.notaFiscals.add(notaFiscal);
	}
	
	public boolean remover(double codigo){
		for(NotaFiscal notaFiscal : this.notaFiscals){
			if(notaFiscal.getCodigo() == codigo){
				this.notaFiscals.remove(notaFiscal);
				return true;
			}
		}
		return false;
	}
	public boolean remover(NotaFiscal notaFiscal){
		if(!this.notaFiscals.contains(notaFiscal)){
			return false;
		}
		return this.notaFiscals.remove(notaFiscal);
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
	public void atualizar(NotaFiscal notaFiscal){
		if(!this.notaFiscals.contains(notaFiscal)){
			this.cadastrar(notaFiscal);
		}
		for(NotaFiscal notaFiscal2 : this.notaFiscals){
			if(notaFiscal2.getCodigo() == notaFiscal.getCodigo()){
				this.notaFiscals.remove(notaFiscal2);
				this.notaFiscals.add(notaFiscal);
			}
		}
	}

}
