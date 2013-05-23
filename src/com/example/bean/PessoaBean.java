package com.example.bean;

import java.io.Serializable;

public class PessoaBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1648793741515654224L;
	private String nome;
	private int telefone;
	private String Endereco;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
}
