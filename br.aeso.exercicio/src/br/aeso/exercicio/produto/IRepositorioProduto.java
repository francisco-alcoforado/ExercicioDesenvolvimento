package br.aeso.exercicio.produto;

import java.io.IOException;
import java.util.ArrayList;

public interface IRepositorioProduto {
	public void cadastrar(Produto produto) throws IOException;
	public void atualizar(Produto produto) throws IOException;
	public boolean remover(double codigo) throws IOException;
	public Produto procurar(double codigo);
	public ArrayList<Produto> listar();
	public double getNextId();
}
