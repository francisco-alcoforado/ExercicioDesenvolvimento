package br.aeso.notaFiscal;

import java.util.ArrayList;

public class RepositorioNotaFiscalArrayList implements IRepositorioNotaFiscal{
	private ArrayList<NotaFiscal> notaFiscales = new ArrayList<NotaFiscal>();
	
	public RepositorioNotaFiscalArrayList() {
		// TODO Auto-generated constructor stub
	}
	
	public void cadastrar(NotaFiscal notaFiscal){
		if(this.notaFiscales.contains(notaFiscal)){
			return;
		}
		this.notaFiscales.add(notaFiscal);
	}
	public ArrayList<NotaFiscal> listar(){
		return this.notaFiscales;
	}
	public boolean remover(NotaFiscal notaFiscal){
		int index = this.notaFiscales.indexOf(notaFiscal);
		if(index == -1){
			return false;
		}
		this.notaFiscales.remove(index);
		return true;
	}
	public boolean remover(double codigo){
		for(NotaFiscal notaFiscal : this.notaFiscales){
			if(notaFiscal.getCodigo() == codigo){
				this.notaFiscales.remove(notaFiscal);
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
	public void atualizar(NotaFiscal notaFiscal){
		if(!this.notaFiscales.contains(notaFiscal)){
			this.cadastrar(notaFiscal);
		}
		int index = this.notaFiscales.indexOf(notaFiscal);
		this.notaFiscales.set(index, notaFiscal);
	}
}
