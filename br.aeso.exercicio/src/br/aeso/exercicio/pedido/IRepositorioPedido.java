package br.aeso.exercicio.pedido;

import java.io.IOException;
import java.util.ArrayList;

public interface IRepositorioPedido {
	public void cadastrar(Pedido pedido) throws IOException;
	public void atualizar(Pedido pedido) throws IOException;
	public boolean remover(double codigo) throws IOException;
	public Pedido procurar(double codigo);
	public ArrayList<Pedido> listar();
	public ArrayList<Pedido> procurar(int codigoNotaFiscal);
	public double getNextId();
}
