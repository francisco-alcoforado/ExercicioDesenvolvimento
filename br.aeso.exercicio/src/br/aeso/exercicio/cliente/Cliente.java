package br.aeso.exercicio.cliente;

public class Cliente {
	private String codigo;
	private String nome;
	private String cpf;
	public Cliente(String codigo, String nome, String cpf) {
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
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
