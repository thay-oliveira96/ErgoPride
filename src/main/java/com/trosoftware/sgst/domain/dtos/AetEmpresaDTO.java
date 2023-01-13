package com.trosoftware.sgst.domain.dtos;

import com.trosoftware.sgst.domain.AetEmpresa;

public class AetEmpresaDTO {
	
	private Integer id;
	private Integer empresa;
	private String cod;
	private String idAetCargo;
	private String idAetSetor;
	private String status;
	private String nomeEmpresa;
	
	
	public AetEmpresaDTO() {
		super();
	}
	
	public AetEmpresaDTO(AetEmpresa obj) {
		super();
		this.id = obj.getId();
		this.cod = obj.getCod();
		this.empresa = obj.getEmpresa().getId();
		this.idAetCargo = obj.getIdAetCargo();
		this.idAetSetor = obj.getIdAetSetor();
		this.status = obj.getStatus();
		this.nomeEmpresa = obj.getEmpresa().getNome();
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getEmpresa() {
		return empresa;
	}


	public void setEmpresa(Integer empresa) {
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
	
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

}
