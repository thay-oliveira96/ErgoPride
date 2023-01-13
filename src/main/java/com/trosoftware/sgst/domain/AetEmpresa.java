package com.trosoftware.sgst.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import com.trosoftware.sgst.domain.dtos.AetEmpresaDTO;

@Entity
public class AetEmpresa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToMany
	@JoinColumn(name = "empresa_id")
	private Empresas empresa;
	
	private String cod;
	
	//relacionamento entre tabelas
	@ManyToMany
	@JoinColumn(name = "lista_aetCargos")
	private List<AetCargo> idAetCargos;
	
	@ManyToMany
	@JoinColumn(name = "lista_aetCargos")
	private List<AetPosto> idAetSetor;
	
	private String status;
	
	
	public AetEmpresa() {
		super();
	}

	public AetEmpresa(Integer id, Empresas empresa, String cod, List<AetCargo> idAetCargo, List<AetPosto> idAetSetor, String status) {
		super();
		this.id = id;
		this.empresa = empresa;
		this.cod = cod;
		this.idAetCargo = idAetCargo.stream().map(AetPosto::new).collect(Collectors.toList());
		this.idAetSetor = idAetSetor;
		this.status = status;
	}
	
	public AetEmpresa(AetEmpresaDTO objDTO) {
		this.id = objDTO.getId();
		this.cod = objDTO.getCod();
		//this.empresa = objDTO.getEmpresa();
		this.idAetCargo = objDTO.getIdAetCargo();
		this.idAetSetor = objDTO.getIdAetSetor();
		this.status = objDTO.getStatus();
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Empresas getEmpresa() {
		return empresa;
	}


	public void setEmpresa(Empresas empresa) {
		this.empresa = empresa;
	}


	public String getCod() {
		return cod;
	}


	public void setCod(String cod) {
		this.cod = cod;
	}


	public String getIdAetCargo() {
		return idAetCargo;
	}


	public void setIdAetCargo(String idAetCargo) {
		this.idAetCargo = idAetCargo;
	}


	public String getIdAetSetor() {
		return idAetSetor;
	}


	public void setIdAetSetor(String idAetSetor) {
		this.idAetSetor = idAetSetor;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public int hashCode() {
		return Objects.hash(status, cod, empresa, id, idAetCargo, idAetSetor);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AetEmpresa other = (AetEmpresa) obj;
		return Objects.equals(status, other.status) && Objects.equals(cod, other.cod)
				&& Objects.equals(empresa, other.empresa) && Objects.equals(id, other.id)
				&& Objects.equals(idAetCargo, other.idAetCargo) && Objects.equals(idAetSetor, other.idAetSetor);
	}
	
	
	

}
