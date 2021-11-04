package br.org.serratec.projeto02.model;

public enum Combustivel {
	GASOLINA(1,"GASOLINA"), ALCOOL (2, "ÁLCOOL"), FLEX(3, "FLEX"), DIESEL(4, "DIESEL");
	
	private Integer codigo;
	private String tipo;
	private Combustivel(Integer codigo, String tipo) {
		this.codigo = codigo;
		this.tipo = tipo;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public String getTipo() {
		return tipo;
	}
	
}
