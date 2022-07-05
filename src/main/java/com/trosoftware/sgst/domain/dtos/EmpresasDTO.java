package com.trosoftware.sgst.domain.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.trosoftware.sgst.domain.Empresas;

public class EmpresasDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	@NotNull(message = "O campo PRIORIDADE é requerido")
	private String nome;
	@NotNull(message = "O campo PRIORIDADE é requerido")
	private String cnpj;
	private String cep;
	private String endereco;
	private String telefone;
	private String email;
	private String funcionarios;
	private String departamentos;
	
	
	public EmpresasDTO() {
		super();
		
	}
	public EmpresasDTO(Empresas obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cnpj = obj.getCnpj();
		this.cep = obj.getCep();
		this.endereco = obj.getEndereco();
		this.telefone = obj.getTelefone();
		this.email = obj.getEmail();
		this.funcionarios = obj.getFuncionarios();
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


}
