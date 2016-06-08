package br.aeso.exercicio.notaFiscal;

import java.io.IOException;
import java.util.ArrayList;

public interface IRepositorioNotaFiscal {
	public void cadastrar(NotaFiscal notaFiscal) throws IOException;
	public void atualizar(NotaFiscal notaFiscal) throws IOException;
	public boolean remover(double codigo) throws IOException;
	public NotaFiscal procurar(double codigo);
	public ArrayList<NotaFiscal> listar();
	public double getNextId();
}
