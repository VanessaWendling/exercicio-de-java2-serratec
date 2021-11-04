package br.org.serratec.projeto02.model;

public class Aluno {
	private Long matricula;
	private String nome;
	private String telefone;
	public Aluno(Long matricula, String nome, String telefone) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.telefone = telefone;
	}
	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", nome=" + nome + ", telefone=" + telefone + "]";
	}
	public Long getMatricula() {
		return matricula;
	}
	public String getNome() {
		return nome;
	}
	public String getTelefone() {
		return telefone;
	}
	
	
	//colocamos os sets para podermos atualizar os dados
	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
}
