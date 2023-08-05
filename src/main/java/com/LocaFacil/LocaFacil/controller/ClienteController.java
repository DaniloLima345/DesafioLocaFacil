package com.LocaFacil.LocaFacil.controller;

import java.net.URI;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.LocaFacil.LocaFacil.model.Cliente;
import com.LocaFacil.LocaFacil.paginacao.ConfigPagina;
import com.LocaFacil.LocaFacil.paginacao.Pagina;
import com.LocaFacil.LocaFacil.service.ClienteService;

@RequestMapping("/clientes")
@RestController
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@Transactional
	@PostMapping
	public ResponseEntity<Cliente> salvar (@RequestBody Cliente cliente, UriComponentsBuilder uriBuilder) throws SQLException {
		
		Cliente clienteSalvo = clienteService.salvar(cliente);
		
		URI uri = uriBuilder.path("clientes/{id}").buildAndExpand(clienteSalvo.getId()).toUri();
		
		return ResponseEntity.created(uri).body(clienteSalvo);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) throws SQLException {
		Cliente cliente = clienteService.buscarPorId(id).get();
		
		return ResponseEntity.ok(cliente);
	}
	
	@GetMapping("/listarTodos")
	public ResponseEntity<Pagina<Cliente>> listarTodos(@RequestParam int tamanho, @RequestParam int numeroDaPagina){
		ConfigPagina configPagina = new ConfigPagina(tamanho, numeroDaPagina);
		Pagina<Cliente> cliente = clienteService.listarTodos(configPagina);
		return ResponseEntity.ok(cliente);
	}
}
