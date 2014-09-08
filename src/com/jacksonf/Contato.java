package com.jacksonf;

public class Contato {
	private String nome;
	private String endereco;
	private String telefone;
	
	public void ShowConsole()
	{
		System.out.printf("Nome: %s\tEndereco: %s\tTelefone: %s\r\n", this.getNome(), this.getEndereco(), this.getTelefone());
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}
