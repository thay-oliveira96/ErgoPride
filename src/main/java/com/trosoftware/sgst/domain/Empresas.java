package com.trosoftware.sgst.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import com.trosoftware.sgst.domain.dtos.DepartamentosDTO;
import com.trosoftware.sgst.domain.dtos.EmpresasDTO;
import com.trosoftware.sgst.domain.dtos.FuncoesDTO;

@Entity
public class Empresas implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	@Column(unique = true)
	private String cnpj;
	private String cnae; //7 digitos
	private String cep;
	private String endereco;
	private String numero;
	private String municipio;
	private String estado;
	private String telefone;
	private String celular;
	private String email;
	private String funcionarios;
	private String atividadePrincipal;
	private String observacoes;
	
	@ManyToMany
	@JoinColumn(name = "lista_dptos")
	private List<Departamentos> departamentos;
	
	@ManyToMany
	@JoinColumn(name = "lista_func")
	private List<Funcoes> funcoes;
	
	public Empresas() {
		super();	
	}
	
	public Empresas(EmpresasDTO empresasDTO, List<DepartamentosDTO> departamentosDTO, List<FuncoesDTO> funcoesDTO) {
		
		this(empresasDTO.getId(), empresasDTO.getNome(),empresasDTO.getCnpj(), empresasDTO.getCnae(), empresasDTO.getCep(),
				empresasDTO.getNumero(), empresasDTO.getMunicipio(), empresasDTO.getEstado(), empresasDTO.getEndereco(), 
				empresasDTO.getTelefone(), empresasDTO.getCelular(), empresasDTO.getEmail(), empresasDTO.getFuncionarios(),
				 departamentosDTO, funcoesDTO, empresasDTO.getAtividadePrincipal(), empresasDTO.getObservacoes());
		}
	
	public Empresas(Integer id, String nome, String cnpj, String cnae, String cep,
			String endereco, String numero, String municipio, String estado, String telefone,
			String celular, String email, String funcionarios, List<DepartamentosDTO> departamentos,
			List<FuncoesDTO> funcoes , String atividadePrincipal,String observacoes) {
		
		super();
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.cnae = cnae;
		this.cep = cep;
		this.endereco = endereco;
		this.numero = numero;
		this.municipio = municipio;
		this.estado = estado;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
		this.funcionarios = funcionarios;
		this.departamentos = departamentos.stream().map(Departamentos::new).collect(Collectors.toList());
		this.funcoes = funcoes.stream().map(Funcoes::new).collect(Collectors.toList());
		this.atividadePrincipal = atividadePrincipal;
		this.observacoes = observacoes;
		
		
	}
	public Empresas(EmpresasDTO objDTO) {
		this.id = objDTO.getId();
		this.nome = objDTO.getNome();
		this.cnpj =objDTO.getCnpj();
		this.cnae = objDTO.getCnae();
		this.cep = objDTO.getCep();
		this.endereco = objDTO.getEndereco();
		this.numero = objDTO.getNumero();
		this.municipio = objDTO.getMunicipio();
		this.estado = objDTO.getEstado();
		this.telefone = objDTO.getTelefone();
		this.celular = objDTO.getCelular();
		this.email = objDTO.getEmail();
		this.funcionarios = objDTO.getFuncionarios();
		this.departamentos = objDTO.getDepartamentos().stream().map(Departamentos::new).collect(Collectors.toList());
		this.atividadePrincipal = objDTO.getAtividadePrincipal();
		//this.funcoes = objDTO.getFuncoes().stream().map(Funcoes::new).collect(Collectors.toList());
		this.observacoes = objDTO.getObservacoes();
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
	
	public String getCnae() {
		return cnae;
	}

	public void setCnae(String cnae) {
		this.cnae = cnae;
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
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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
	
	public List<Departamentos> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(List<Departamentos> departamentos) {
		this.departamentos = departamentos;
	}
	/*public List<Funcoes> getFuncoes() {
		return funcoes;
	}

	public void setFuncoes(List<Funcoes> funcoes) {
		this.funcoes = funcoes;
	} */

	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
	public String getAtividadePrincipal() {
		return atividadePrincipal;
	}

	public void setAtividadePrincipal(String atividadePrincipal) {
		this.atividadePrincipal = atividadePrincipal;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, nome, cnpj, cnae, telefone, celular, email, endereco, cep, 
				numero, municipio, estado, funcionarios, departamentos, atividadePrincipal, observacoes);
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
		return Objects.equals(cep, other.cep) 
				&& Objects.equals(cnpj, other.cnpj)
				&& Objects.equals(cnae, other.cnae) 
				&& Objects.equals(departamentos, other.departamentos) 
				&& Objects.equals(email, other.email)
				&& Objects.equals(endereco, other.endereco)
				&& Objects.equals(numero, other.numero)
				&& Objects.equals(municipio, other.municipio)
				&& Objects.equals(estado, other.estado)
				&& Objects.equals(funcionarios, other.funcionarios)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(telefone, other.telefone)
		        && Objects.equals(celular, other.celular)
		        && Objects.equals(atividadePrincipal, other.atividadePrincipal)
		        && Objects.equals(observacoes, other.observacoes);
	}
	
}
