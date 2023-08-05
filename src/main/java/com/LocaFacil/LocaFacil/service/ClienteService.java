package com.LocaFacil.LocaFacil.service;

import java.sql.SQLException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.LocaFacil.LocaFacil.model.Cliente;
import com.LocaFacil.LocaFacil.paginacao.ConfigPagina;
import com.LocaFacil.LocaFacil.paginacao.Pagina;

@Service
public interface ClienteService {
	
	Cliente salvar(Cliente cliente) throws SQLException;
	
	Optional<Cliente> buscarPorId(Long id);
	
	Pagina<Cliente> listarTodos(ConfigPagina configPagina);
}
