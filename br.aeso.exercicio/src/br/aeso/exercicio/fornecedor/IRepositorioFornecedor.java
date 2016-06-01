package br.aeso.exercicio.fornecedor;

import java.util.ArrayList;

public interface IRepositorioFornecedor {
	public void cadastrar(Fornecedor fornecedor);
	public void atualizar(Fornecedor fornecedor);
	public boolean remover(double codigo);
	public Fornecedor procurar(double codigo);
	public ArrayList<Fornecedor> listar();
}
