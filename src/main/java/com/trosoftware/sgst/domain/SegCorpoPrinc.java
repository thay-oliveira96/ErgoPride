package com.trosoftware.sgst.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.trosoftware.sgst.domain.dtos.SegCorpoPrincDTO;

@Entity
public class SegCorpoPrinc implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String descricao;
	
	public SegCorpoPrinc() {
		super();
	}
	
	public SegCorpoPrinc(SegCorpoPrincDTO segCorpoPrincDTO) {
		this(segCorpoPrincDTO.getId(), segCorpoPrincDTO.getDescricao());
	}
	
	public SegCorpoPrinc(Integer id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
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
	@Override
	public int hashCode() {
		return Objects.hash(descricao, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SegCorpoPrinc other = (SegCorpoPrinc) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(id, other.id);
	}

}
