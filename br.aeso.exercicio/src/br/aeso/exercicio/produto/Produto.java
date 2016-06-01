package br.aeso.exercicio.produto;

public class Produto {
	private int codigo;
	private String nome;
	private double preco;
	private String categoria;
	public Produto(int codigo, String nome, double preco, String categoria) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
		this.categoria = categoria;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", nome=" + nome + ", preco=" + preco + ", categoria=" + categoria + "]";
	}
}
