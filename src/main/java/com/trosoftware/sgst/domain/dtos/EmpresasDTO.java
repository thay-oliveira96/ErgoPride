package com.trosoftware.sgst.domain.dtos;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import com.trosoftware.sgst.domain.Departamentos;
import com.trosoftware.sgst.domain.Empresas;
import com.trosoftware.sgst.domain.Funcoes;

public class EmpresasDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	@NotNull(message = "O campo Nome Empresa é requerido")
	private String nome;
	@NotNull(message = "O campo CNPJ é requerido")
	private String cnpj;
	private String cep;
	private String endereco;
	private String telefone;
	private String celular;
	private String email;
	private String funcionarios;
	private List<DepartamentosDTO> departamentos;
	private List<FuncoesDTO> funcoes;
	private String observacoes;
	//private String nomeDepartamentos;
	
	
	public EmpresasDTO() {
		super();
		
	}
	public EmpresasDTO(Empresas obj, List<Departamentos> dep, List<Funcoes> func) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cnpj = obj.getCnpj();
		this.cep = obj.getCep();
		this.endereco = obj.getEndereco();
		this.telefone = obj.getTelefone();
		this.celular = obj.getCelular();
		this.email = obj.getEmail();
		this.funcionarios = obj.getFuncionarios();
		this.departamentos = dep.stream().map(DepartamentosDTO::new).collect(Collectors.toList());
		this.funcoes = func.stream().map(FuncoesDTO::new).collect(Collectors.toList());
		this.observacoes = obj.getObservacoes();
	}
	public EmpresasDTO(Empresas obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cnpj = obj.getCnpj();
		this.cep = obj.getCep();
		this.endereco = obj.getEndereco();
		this.telefone = obj.getTelefone();
		this.celular = obj.getCelular();
		this.email = obj.getEmail();
		this.funcionarios = obj.getFuncionarios();
		this.departamentos = obj.getDepartamentos().stream().map(DepartamentosDTO::new).collect(Collectors.toList());
		this.funcoes = obj.getFuncoes().stream().map(FuncoesDTO::new).collect(Collectors.toList());
		this.observacoes = obj.getObservacoes();
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
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
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
	
	public List<DepartamentosDTO> getDepartamentos() {
		return departamentos;
	}
	public void setDepartamentos(List<DepartamentosDTO> departamentos) {
		this.departamentos = departamentos;
	}
	public List<FuncoesDTO> getFuncoes() {
		return funcoes;
	}
	public void setFuncoes(List<FuncoesDTO> funcoes) {
		this.funcoes = funcoes;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}


}
