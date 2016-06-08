package br.aeso.exercicio.cliente;

import java.io.IOException;
import java.util.ArrayList;

public interface IRepositorioCliente {
	public void cadastrar(Cliente cliente) throws IOException;
	public void atualizar(Cliente cliente) throws IOException;
	public boolean remover(double codigo) throws IOException;
	public Cliente procurar(double codigo);
	public ArrayList<Cliente> listar();
	public double getNextId();
}
