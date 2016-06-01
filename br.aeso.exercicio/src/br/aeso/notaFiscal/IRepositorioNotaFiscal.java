package br.aeso.notaFiscal;

import java.util.ArrayList;

public interface IRepositorioNotaFiscal {
	public void cadastrar(NotaFiscal notaFiscal);
	public void atualizar(NotaFiscal notaFiscal);
	public boolean remover(double codigo);
	public NotaFiscal procurar(double codigo);
	public ArrayList<NotaFiscal> listar();
}
