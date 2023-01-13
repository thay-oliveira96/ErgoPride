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

import com.trosoftware.sgst.domain.dtos.AetCargoDTO;
import com.trosoftware.sgst.domain.dtos.FuncoesDTO;
import com.trosoftware.sgst.domain.dtos.SegCorpoPrincDTO;

@Entity
public class AetCargo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String cod; 
	
	@ManyToMany
	@JoinColumn(name = "lista_cargos")
	private List<Funcoes> cargo; 
	
	private String fatoresRisco;
	private String grauRisco; 
	
	@ManyToMany
	@JoinColumn(name = "lista_segcorpo")
	private List<SegCorpoPrinc> segCorpPrinc;
	
	/*@ManyToMany
	@JoinColumn(name = "lista_demseg")
	private List<DemSegm> demSegm; //Demais segmentos relacionamento com a tabela SegCorpPrinc
	*/
	
	private String diagnosticoGlobal; 
	private String recomendacoes; 
	
	public AetCargo() {
		super();
	}
	
	public AetCargo(AetCargoDTO aetCargoDTO, List<FuncoesDTO> cargoDTO,List<SegCorpoPrincDTO> segCorpPrincDTO/*, List<DemSegmDTO> demSegmDTO*/) {
		this(aetCargoDTO.getId(), aetCargoDTO.getCod(), cargoDTO, aetCargoDTO.getFatoresRisco(),
				aetCargoDTO.getGrauRisco(), segCorpPrincDTO, /*demSegmDTO,*/ aetCargoDTO.getDiagnosticoGlobal(), 
				aetCargoDTO.getRecomendacoes());
	}

	public AetCargo(Integer id, String cod, List<FuncoesDTO> cargo, String fatoresRisco, String grauRisco, 
			List<SegCorpoPrincDTO> segCorpoPrinc,
			/*List<DemSegmDTO> demSegm,*/ String diagnosticoGlobal, String recomendacoes) {
		super();
		this.id = id;
		this.cargo = cargo.stream().map(Funcoes::new).collect(Collectors.toList());
		this.cod = cod;
		this.fatoresRisco = fatoresRisco;
		this.grauRisco = grauRisco;
		this.segCorpPrinc = segCorpoPrinc.stream().map(SegCorpoPrinc::new).collect(Collectors.toList());
		//this.demSegm = demSegm.stream().map(DemSegm::new).collect(Collectors.toList());
		this.diagnosticoGlobal = diagnosticoGlobal;
		this.recomendacoes = recomendacoes;
	}
	
	public AetCargo(AetCargoDTO objDTO) {
		this.id = objDTO.getId();
		this.cod = objDTO.getCod();
		this.cargo = objDTO.getCargo().stream().map(Funcoes::new).collect(Collectors.toList());
		this.fatoresRisco = objDTO.getFatoresRisco();
		this.grauRisco = objDTO.getGrauRisco();
		this.segCorpPrinc = objDTO.getSegCorpoPrinc().stream().map(SegCorpoPrinc::new).collect(Collectors.toList());
		//this.demSegm = objDTO.getDemSegm().stream().map(DemSegm::new).collect(Collectors.toList());
		this.diagnosticoGlobal = objDTO.getDiagnosticoGlobal();
		this.recomendacoes = objDTO.getRecomendacoes();
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

	public List<Funcoes> getCargo() {
		return cargo;
	}

	public void setCargo(List<Funcoes> cargo) {
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

	public List<SegCorpoPrinc> getSegCorpoPrinc() {
		return segCorpPrinc;
	}

	public void setSegCorpoPrinc(List<SegCorpoPrinc> segCorpPrinc) {
		this.segCorpPrinc = segCorpPrinc;
	}

	/*public List<DemSegm> getDemSegm() {
		return demSegm;
	}*/

	/*public void setDemSegm(List<DemSegm> demSegm) {
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

	@Override
	public int hashCode() {
		return Objects.hash(cargo, cod, /*demSegm,*/ diagnosticoGlobal, fatoresRisco, grauRisco, id, recomendacoes,
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
		AetCargo other = (AetCargo) obj;
		return Objects.equals(cod, other.cod) &&
				Objects.equals(cargo, other.cargo)  /*&&Objects.equals(demSegm, other.demSegm )*/
				&& Objects.equals(diagnosticoGlobal, other.diagnosticoGlobal)
				&& Objects.equals(fatoresRisco, other.fatoresRisco) && Objects.equals(grauRisco, other.grauRisco)
				&& Objects.equals(id, other.id) && Objects.equals(recomendacoes, other.recomendacoes)
				&& Objects.equals(segCorpPrinc, other.segCorpPrinc);
	}
	
	

}
