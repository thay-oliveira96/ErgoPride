package com.trosoftware.sgst.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AetPosto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String cod; 
	
	@ManyToOne
	@JoinColumn(name = "funcoes_id")
	private Funcoes cargo; 
	
	private String fatoresRisco;
	private String grauRisco; 
	
	@ManyToOne
	@JoinColumn(name = "SegmentoPrinc_id")
	private SegCorpoPrinc segCorpPrinc;
	
	@ManyToOne
	@JoinColumn(name = "DemaisSegment_id")
	private SegCorpoPrinc demSegm; 	
	
	private String diagnosticoGlobal; 
	private String recomendacoes; 
	
	
	public AetPosto() {
		super();
	}
	
	
	public AetPosto(Integer id, String cod, Funcoes cargo, String fatoresRisco, String grauRisco, 
			SegCorpoPrinc segCorpoPrinc,
			SegCorpoPrinc demSegm, String diagnosticoGlobal, String recomendacoes) {
		super();
		this.id = id;
		this.cargo = cargo;
		this.cod = cod;
		this.fatoresRisco = fatoresRisco;
		this.grauRisco = grauRisco;
		this.segCorpPrinc = segCorpoPrinc;
		this.demSegm = demSegm;
		this.diagnosticoGlobal = diagnosticoGlobal;
		this.recomendacoes = recomendacoes;
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

	public Funcoes getCargo() {
		return cargo;
	}

	public void setCargo(Funcoes cargo) {
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

	public SegCorpoPrinc getSegCorpoPrinc() {
		return segCorpPrinc;
	}

	public void setSegCorpoPrinc(SegCorpoPrinc segCorpPrinc) {
		this.segCorpPrinc = segCorpPrinc;
	}

	public SegCorpoPrinc getDemSegm() {
		return demSegm;
	}

	public void setDemSegm(SegCorpoPrinc demSegm) {
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

	@Override
	public int hashCode() {
		return Objects.hash(cargo, cod, demSegm, diagnosticoGlobal, fatoresRisco, grauRisco, id, recomendacoes,
				segCorpPrinc);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AetPosto other = (AetPosto) obj;
		return Objects.equals(cod, other.cod) &&
				Objects.equals(cargo, other.cargo) && Objects.equals(demSegm, other.demSegm )
				&& Objects.equals(diagnosticoGlobal, other.diagnosticoGlobal)
				&& Objects.equals(fatoresRisco, other.fatoresRisco) && Objects.equals(grauRisco, other.grauRisco)
				&& Objects.equals(id, other.id) && Objects.equals(recomendacoes, other.recomendacoes)
				&& Objects.equals(segCorpPrinc, other.segCorpPrinc);
	}
	
	

}
