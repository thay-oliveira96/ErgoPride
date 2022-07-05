package com.trosoftware.sgst.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.trosoftware.sgst.domain.dtos.EmpresasDTO;

@Entity
public class Empresas implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	@Column(unique = true)
	private String cnpj;
	
	private String cep;
	private String endereco;
	private String telefone;
	private String email;
	private String funcionarios;
	private String departamentos;
	
	
	public Empresas() {
		super();
		
	}
	
	public Empresas(EmpresasDTO empresasDTO) {
		 this(empresasDTO.getId(), empresasDTO.getNome(), empresasDTO.getCnpj() ,empresasDTO.getCep(),
				 empresasDTO.getEndereco(), empresasDTO.getTelefone(), 
				 empresasDTO.getEmail(), empresasDTO.getFuncionarios(),
				 empresasDTO.getDepartamentos());
		}
	
	public Empresas(Integer id, String nome, String cnpj, String cep, String endereco, String telefone, String email,
			String funcionarios, String departamentos) {
		super();
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.cep = cep;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.funcionarios = funcionarios;
		this.departamentos = departamentos;
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
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(String funcionarios) {
		this.funcionarios = funcionarios;
	}
	public String getDepartamentos() {
		return departamentos;
	}
	public void setDepartamentos(String departamentos) {
		this.departamentos = departamentos;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, nome, cnpj, telefone, email, endereco, cep, funcionarios, departamentos);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresas other = (Empresas) obj;
		return Objects.equals(cep, other.cep) && Objects.equals(cnpj, other.cnpj)
				&& Objects.equals(departamentos, other.departamentos) && Objects.equals(email, other.email)
				&& Objects.equals(endereco, other.endereco)
				&& Objects.equals(funcionarios, other.funcionarios)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(telefone, other.telefone);
	}
	
}
