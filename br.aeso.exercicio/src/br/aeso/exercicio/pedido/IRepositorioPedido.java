package br.aeso.exercicio.pedido;

import java.util.ArrayList;

public interface IRepositorioPedido {
	public void cadastrar(Pedido pedido);
	public void atualizar(Pedido pedido);
	public boolean remover(double codigo);
	public Pedido procurar(double codigo);
	public ArrayList<Pedido> listar();
}
