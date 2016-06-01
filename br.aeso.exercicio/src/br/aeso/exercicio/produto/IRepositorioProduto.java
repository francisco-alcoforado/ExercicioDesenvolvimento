package br.aeso.exercicio.produto;

import java.util.ArrayList;

public interface IRepositorioProduto {
	public void cadastrar(Produto produto);
	public void atualizar(Produto produto);
	public boolean remover(double codigo);
	public Produto procurar(double codigo);
	public ArrayList<Produto> listar();
}
