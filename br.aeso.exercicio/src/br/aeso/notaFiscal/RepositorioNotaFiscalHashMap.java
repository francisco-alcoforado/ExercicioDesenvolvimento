package br.aeso.notaFiscal;

import java.util.ArrayList;
import java.util.HashMap;

import br.aeso.exercicio.fornecedor.Fornecedor;

public class RepositorioNotaFiscalHashMap implements IRepositorioNotaFiscal{
	HashMap<Integer, NotaFiscal> notaFiscals = new HashMap<Integer, NotaFiscal>();
	
	public RepositorioNotaFiscalHashMap() {
		// TODO Auto-generated constructor stub
	}

	public void cadastrar(NotaFiscal notaFiscal){
		if(this.notaFiscals.containsKey(notaFiscal.getCodigo())){
			return;
		}
		this.notaFiscals.put(notaFiscal.getCodigo(), notaFiscal);
	}
	
	public boolean remover(double codigo){
		if(!this.notaFiscals.containsKey(codigo)){
			return false;
		}
		this.notaFiscals.remove(codigo);
		return false;
	}
	public boolean remover(Fornecedor notaFiscal){
		if(!this.notaFiscals.containsKey(notaFiscal.getCodigo())){
			return false;
		}
		this.notaFiscals.remove(notaFiscal.getCodigo());
		return true;
	}
	public ArrayList<NotaFiscal> listar(){
		ArrayList<NotaFiscal> notaFiscals = new ArrayList<NotaFiscal>(this.notaFiscals.values());
		return notaFiscals;
	}
	public NotaFiscal procurar(double codigo){
		if(!this.notaFiscals.containsKey(codigo)){
			return null;
		}
		return this.notaFiscals.get(codigo); 
	}
	
	public NotaFiscal procurar(NotaFiscal notaFiscal){
		if(!this.notaFiscals.containsKey(notaFiscal.getCodigo())){
			return null;
		}
		return this.notaFiscals.get(notaFiscal.getCodigo());
	}
	public void atualizar(NotaFiscal notaFiscal){
		if(!this.notaFiscals.containsKey(notaFiscal.getCodigo())){
			this.cadastrar(notaFiscal);
		}
		this.notaFiscals.replace(notaFiscal.getCodigo(), notaFiscal);
	}

}
