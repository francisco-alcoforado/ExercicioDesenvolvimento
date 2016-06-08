package br.aeso.exercicio.notaFiscal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import br.aeso.exercicio.arquivos.ArquivosManager;
import br.aeso.exercicio.fornecedor.Fornecedor;

public class RepositorioNotaFiscalHashMap implements IRepositorioNotaFiscal{
	HashMap<Integer, NotaFiscal> notaFiscals;
	private String file = "C:/Users/lab01/git/ExercicioDesenvolvimento/br.aeso.exercicio/arquivos/notaFiscalHashMap.tmp";
	@SuppressWarnings("unchecked")
	public RepositorioNotaFiscalHashMap() throws ClassNotFoundException, IOException {
		ArquivosManager arquivos = new ArquivosManager();
		if(!arquivos.exists(this.file)){
			arquivos.createFile(this.file);
			this.notaFiscals = new HashMap<Integer, NotaFiscal>();
		}else{
			this.notaFiscals = (HashMap<Integer, NotaFiscal>) arquivos.getValores(file);
		}
	}

	public void cadastrar(NotaFiscal notaFiscal) throws IOException{
		if(this.notaFiscals.containsKey(notaFiscal.getCodigo())){
			return;
		}
		this.notaFiscals.put(notaFiscal.getCodigo(), notaFiscal);
		this.save();
	}
	private void save() throws IOException{
		ArquivosManager arquivos = new ArquivosManager();
		HashMap<Integer, Object> valores = new HashMap<Integer, Object>();
		valores.putAll(this.notaFiscals);
		arquivos.saveValores(valores, this.file);
	}
	public boolean remover(double codigo) throws IOException{
		if(!this.notaFiscals.containsKey(codigo)){
			return false;
		}
		this.notaFiscals.remove(codigo);
		this.save();
		return true;
	}
	public boolean remover(Fornecedor notaFiscal) throws IOException{
		if(!this.notaFiscals.containsKey(notaFiscal.getCodigo())){
			return false;
		}
		this.notaFiscals.remove(notaFiscal.getCodigo());
		this.save();
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
	public void atualizar(NotaFiscal notaFiscal) throws IOException{
		if(!this.notaFiscals.containsKey(notaFiscal.getCodigo())){
			this.cadastrar(notaFiscal);
		}
		this.notaFiscals.replace(notaFiscal.getCodigo(), notaFiscal);
		this.save();
	}
	public double getNextId(){
		if(this.notaFiscals.size() == 0){
			return 1;
		}
		return this.notaFiscals.size() + 1;
	}
}
