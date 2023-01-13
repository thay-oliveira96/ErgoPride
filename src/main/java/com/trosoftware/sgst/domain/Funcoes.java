package com.trosoftware.sgst.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.trosoftware.sgst.domain.dtos.FuncoesDTO;

@Entity
public class Funcoes implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	@ManyToMany(mappedBy="cargo")
	private List<AetCargo> aetCargo;
	
	//@ManyToMany(mappedBy="departamentos")
	//private List<Empresas> empresas;
	
	public Funcoes() {
		super();
		
	}
	public Funcoes(FuncoesDTO funcoesDTO) {
		 this(funcoesDTO.getId(), funcoesDTO.getNome());
		}
	
	public Funcoes(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
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
	@Override
	public int hashCode() {
		return Objects.hash(id, nome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcoes other = (Funcoes) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}
	
}
