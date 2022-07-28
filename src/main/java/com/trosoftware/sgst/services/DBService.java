package com.trosoftware.sgst.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.trosoftware.sgst.domain.Chamado;
import com.trosoftware.sgst.domain.Cliente;
import com.trosoftware.sgst.domain.Departamentos;
import com.trosoftware.sgst.domain.Tecnico;
import com.trosoftware.sgst.domain.enums.Perfil;
import com.trosoftware.sgst.domain.enums.Prioridade;
import com.trosoftware.sgst.domain.enums.Status;
import com.trosoftware.sgst.repositories.ChamadoRepository;
import com.trosoftware.sgst.repositories.DepartamentosRepository;
import com.trosoftware.sgst.repositories.PessoaRepository;

@Service
public class DBService {

	@Autowired
	private ChamadoRepository chamadoRepository;
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Autowired
	private DepartamentosRepository departamentosRepository;

	public void instanciaDB() {

		Tecnico tec1 = new Tecnico(null, "Administrador", "550.482.150-95", "administrador@ergopride.com", encoder.encode("admin123"));
		tec1.addPerfil(Perfil.ADMIN);

		Cliente cli1 = new Cliente(null, "Albert Einstein", "111.661.890-74", "einstein@mail.com", encoder.encode("123"));
		Cliente cli2 = new Cliente(null, "Marie Curie", "322.429.140-06", "curie@mail.com", encoder.encode("123"));
		Cliente cli3 = new Cliente(null, "Charles Darwin", "792.043.830-62", "darwin@mail.com", encoder.encode("123"));
		Cliente cli4 = new Cliente(null, "Stephen Hawking", "177.409.680-30", "hawking@mail.com", encoder.encode("123"));
		Cliente cli5 = new Cliente(null, "Max Planck", "081.399.300-83", "planck@mail.com", encoder.encode("123"));
		
 
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 1", "Teste chamado 1", tec1, cli1);
		Chamado c2 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 2", "Teste chamado 2", tec1, cli2);
		Chamado c6 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Chamado 7", "Teste chamado 6", tec1, cli5);
		
		//Empresas e1 = new Empresas(null, "Empresa Teste", "00.000.000/0000-00", "0000-000", "Rua Teste, 123", "(00)0000-0000","(00)90000-0000", "teste00@mail.com", "100", "Almoxarifado", "teste");
		//Empresas e2 = new Empresas(null, "Empresa Teste 1", "11.111.111/1111-11", "1111-111", "Rua Teste 1, 345","(11)1111-1111", "(00)91111-1111", "teste01@mail.com", "150", "Producao", "teste");
		
		Departamentos d1 = new Departamentos(null, "escritorio");
		Departamentos d2 = new Departamentos(null, "Marketing");
		Departamentos d3 = new Departamentos(null, "Teste");
		
		pessoaRepository.saveAll(Arrays.asList(tec1, cli1, cli2, cli3, cli4, cli5));
		chamadoRepository.saveAll(Arrays.asList(c1, c2, c6));
		//empresaRepository.saveAll(Arrays.asList(e1, e2));
		departamentosRepository.saveAll(Arrays.asList(d1, d2, d3));
	}
}
