package com.trosoftware.sgst.domain.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.trosoftware.sgst.domain.Objeto;

public class ObjetoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	@NotNull(message = "O campo Nome é requerido")
	private String descricao;
	
	public ObjetoDTO() {
		super();
	}
	public ObjetoDTO(Objeto obj) {
		super();
		this.id = obj.getId();
		this.descricao = obj.getDescricao();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
