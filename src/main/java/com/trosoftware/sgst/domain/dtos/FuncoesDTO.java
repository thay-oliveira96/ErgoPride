package com.trosoftware.sgst.domain.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.trosoftware.sgst.domain.Funcoes;

public class FuncoesDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	@NotNull(message = "O campo Nome é requerido")
	private String nome;
	
	public FuncoesDTO() {
		super();	
	}
	
	public FuncoesDTO(Funcoes obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
