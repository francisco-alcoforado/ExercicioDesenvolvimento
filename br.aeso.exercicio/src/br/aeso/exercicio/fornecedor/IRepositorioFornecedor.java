package br.aeso.exercicio.fornecedor;

import java.io.IOException;
import java.util.ArrayList;

public interface IRepositorioFornecedor {
	public void cadastrar(Fornecedor fornecedor) throws IOException;
	public void atualizar(Fornecedor fornecedor) throws IOException;
	public boolean remover(double codigo) throws IOException;
	public Fornecedor procurar(double codigo);
	public ArrayList<Fornecedor> listar();
	public double getNextId();
}
