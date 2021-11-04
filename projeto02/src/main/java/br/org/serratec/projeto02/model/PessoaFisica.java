package br.org.serratec.projeto02.model;

import javax.persistence.Entity;

@Entity
public class PessoaFisica extends Fornecedor{
	private String rg;
	private String orgaoEmissor;
	private String cpf;
	public PessoaFisica(String rg, String orgaoEmissor, String cpf) {
		super();
		this.rg = rg;
		this.orgaoEmissor = orgaoEmissor;
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getOrgaoEmissor() {
		return orgaoEmissor;
	}
	public void setOrgaoEmissor(String orgaoEmissor) {
		this.orgaoEmissor = orgaoEmissor;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	

}
