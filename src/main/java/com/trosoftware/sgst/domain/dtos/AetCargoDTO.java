package com.trosoftware.sgst.domain.dtos;

import java.util.List;
import java.util.stream.Collectors;

import com.trosoftware.sgst.domain.AetCargo;
import com.trosoftware.sgst.domain.Funcoes;
import com.trosoftware.sgst.domain.SegCorpoPrinc;

public class AetCargoDTO {
	
	
	private Integer id;
	
	private String cod;
	private List<FuncoesDTO> cargo; 
	private String fatoresRisco; 
	private String grauRisco; 
	private List<SegCorpoPrincDTO> segCorpoPrinc; 
	//private List<DemSegmDTO> demSegm; 
	private String diagnosticoGlobal; 
	private String recomendacoes; 
	
	public AetCargoDTO() {
		super();
	}

	public AetCargoDTO(AetCargo obj, List<Funcoes> func ,List<SegCorpoPrinc> seg /*, List<DemSegm> dem*/) {
		super();
		this.id = obj.getId();
		this.cod = obj.getCod();
		this.cargo = func.stream().map(FuncoesDTO::new).collect(Collectors.toList());
		this.fatoresRisco = obj.getFatoresRisco();
		this.grauRisco = obj.getGrauRisco();
		this.segCorpoPrinc = seg.stream().map(SegCorpoPrincDTO::new).collect(Collectors.toList());
		//this.demSegm = dem.stream().map(DemSegmDTO::new).collect(Collectors.toList());
		this.diagnosticoGlobal = obj.getDiagnosticoGlobal();
		this.recomendacoes = obj.getRecomendacoes();
	}
	
	public AetCargoDTO(AetCargo obj) {
		super();
		this.id = obj.getId();
		this.cod = obj.getCod();
		this.cargo = obj.getCargo().stream().map(FuncoesDTO::new).collect(Collectors.toList());
		this.fatoresRisco = obj.getFatoresRisco();
		this.grauRisco = obj.getGrauRisco();
		this.segCorpoPrinc = obj.getSegCorpoPrinc().stream().map(SegCorpoPrincDTO::new).collect(Collectors.toList());
		//this.demSegm = obj.getDemSegm().stream().map(DemSegmDTO::new).collect(Collectors.toList());
		this.diagnosticoGlobal = obj.getDiagnosticoGlobal();
		this.recomendacoes = obj.getRecomendacoes();
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

	public List<FuncoesDTO> getCargo() {
		return cargo;
	}

	public void setCargo(List<FuncoesDTO> cargo) {
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


	public List<SegCorpoPrincDTO> getSegCorpoPrinc() {
		return segCorpoPrinc;
	}
	public void setSegCorpoPrinc(List<SegCorpoPrincDTO> segCorpoPrinc) {
		this.segCorpoPrinc = segCorpoPrinc;
	}

	/*public List<DemSegmDTO> getDemSegm() {
		return demSegm;
	}
	
	public void setDemSegm(List<DemSegmDTO> demSegm) {
		this.demSegm = demSegm;
	}*/

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
	
	
	

}
