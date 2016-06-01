package br.aeso.exercicio.cliente;

public class Cliente {
	private int codigo;
	private String nome;
	private String cpf;
	public Cliente(int codigo, String nome, String cpf) {
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", nome=" + nome + ", cpf=" + cpf + "]";
	}
	public String getCpfFormatado(){
		return String.format("xxx.xxx.xxx-xx", this.cpf);
	}
}
