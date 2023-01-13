package com.trosoftware.sgst.domain.dtos;

import com.trosoftware.sgst.domain.AetPosto;

public class AetPostoDTO {
	
	
	private Integer id;
	
	private String cod;
	private Integer cargo; 
	private String fatoresRisco; 
	private String grauRisco; 
	private Integer segCorpoPrinc; 
	private Integer demSegm; 
	private String diagnosticoGlobal; 
	private String recomendacoes;
	private String nomeCargo;
	private String nomeSegmCorpoPrinc;
	private String nomeOutrosSegm;
	
	public AetPostoDTO() {
		super();
	}
	
	public AetPostoDTO(AetPosto obj) {
		super();
		this.id = obj.getId();
		this.cod = obj.getCod();
		this.cargo = obj.getCargo().getId();
		this.fatoresRisco = obj.getFatoresRisco();
		this.grauRisco = obj.getGrauRisco();
		this.segCorpoPrinc = obj.getSegCorpoPrinc().getId();
		this.demSegm = obj.getDemSegm().getId();
		this.diagnosticoGlobal = obj.getDiagnosticoGlobal();
		this.recomendacoes = obj.getRecomendacoes();
		this.nomeCargo = obj.getCargo().getNome();
		this.nomeSegmCorpoPrinc = obj.getSegCorpoPrinc().getDescricao();
		this.nomeOutrosSegm = obj.getDemSegm().getDescricao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public Integer getCargo() {
		return cargo;
	}

	public void setCargo(Integer cargo) {
		this.cargo = cargo;
	}

	public String getFatoresRisco() {
		return fatoresRisco;
	}

	public void setFatoresRisco(String fatoresRisco) {
		this.fatoresRisco = fatoresRisco;
	}


	public String getGrauRisco() {
		return grauRisco;
	}


	public void setGrauRisco(String grauRisco) {
		this.grauRisco = grauRisco;
	}


	public Integer getSegCorpoPrinc() {
		return segCorpoPrinc;
	}
	public void setSegCorpoPrinc(Integer segCorpoPrinc) {
		this.segCorpoPrinc = segCorpoPrinc;
	}

	public Integer getDemSegm() {
		return demSegm;
	}
	
	public void setDemSegm(Integer demSegm) {
		this.demSegm = demSegm;
	}

	public String getDiagnosticoGlobal() {
		return diagnosticoGlobal;
	}


	public void setDiagnosticoGlobal(String diagnosticoGlobal) {
		this.diagnosticoGlobal = diagnosticoGlobal;
	}


	public String getRecomendacoes() {
		return recomendacoes;
	}


	public void setRecomendacoes(String recomendacoes) {
		this.recomendacoes = recomendacoes;
	}
	
	public String getNomeCargos() {
		return nomeCargo;
	}

	public void setNomeCargos(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}
	
	public String getNomeSegmCorpoPrinc() {
		return nomeSegmCorpoPrinc;
	}

	public void setNomeSegmCorpoPrin(String nomeSegmCorpoPrinc) {
		this.nomeSegmCorpoPrinc = nomeSegmCorpoPrinc;
	}
	
	public String getNomeDemSegm() {
		return nomeOutrosSegm;
	}

	public void setNomeDemSegm(String nomeOutrosSegm) {
		this.nomeOutrosSegm = nomeOutrosSegm;
	}
	
	

}
