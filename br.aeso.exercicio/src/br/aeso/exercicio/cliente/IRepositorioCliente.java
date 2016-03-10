package br.aeso.exercicio.cliente;

import java.util.ArrayList;

public interface IRepositorioCliente {
	public void cadastrar(Cliente cliente);
	public void atualizar(Cliente cliente);
	public boolean remover(double codigo);
	public Cliente procurar(double codigo);
	public ArrayList<Cliente> listar();
}
