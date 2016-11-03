package br.aeso.exercicio.notaFiscal;

import java.util.ArrayList;

public interface IRepositorioNotaFiscal {
	public void cadastrar(NotaFiscal notaFiscal);
	public void atualizar(NotaFiscal notaFiscal);
	public boolean remover(int codigo);
	public NotaFiscal procurar(int codigo);
	public ArrayList<NotaFiscal> listar();
}
