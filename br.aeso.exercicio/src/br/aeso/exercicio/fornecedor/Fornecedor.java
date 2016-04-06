package br.aeso.exercicio.fornecedor;

public class Fornecedor {
	private int codigo;
	private String nome;
	private String cnpj;
	private String Banco;
	private Endereco endereco;
	public Fornecedor(int codigo, String nome, String cnpj, String banco, Endereco endereco) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cnpj = cnpj;
		Banco = banco;
		this.endereco = endereco;
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
	public String getCnpj() {
		return this.cnpj;
	}
	public void setCpf(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getBanco() {
		return Banco;
	}
	public void setBanco(String banco) {
		Banco = banco;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	@Override
	public String toString() {
		return "Fornecedor [codigo=" + codigo + ", nome=" + nome + ", cpf=" + cnpj + ", Banco=" + Banco + ", endereco="
				+ endereco.toString() + "]";
	}
	public String getCpfFormatado(){
		return String.format("xx.xxx.xxx/xxxx-xx", this.cnpj);
	}
}
