package br.aeso.exercicio.venda;

import java.util.ArrayList;

public interface IRepositorioVenda {
	public void cadastrar(Venda venda);
	public void atualizar(Venda venda);
	public boolean remover(double codigo);
	public Venda procurar(double codigo);
	public ArrayList<Venda> listar();
}
