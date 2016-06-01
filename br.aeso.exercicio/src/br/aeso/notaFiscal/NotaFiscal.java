package br.aeso.notaFiscal;

public class NotaFiscal {
	private int codigo;
	private String dataEmissao;
	public NotaFiscal(int codigo, String dataEmissao) {
		super();
		this.codigo = codigo;
		this.dataEmissao = dataEmissao;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDataEmissao() {
		return dataEmissao;
	}
	public void setDataEmissao(String dataEmissao) {
		this.dataEmissao = dataEmissao;
	}
	@Override
	public String toString() {
		return "NotaFiscal [codigo=" + codigo + ", dataEmissao=" + dataEmissao + "]";
	}
}
