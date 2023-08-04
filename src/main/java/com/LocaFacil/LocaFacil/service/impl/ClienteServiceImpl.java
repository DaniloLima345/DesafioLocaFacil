package com.LocaFacil.LocaFacil.service.impl;

import java.sql.SQLException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.LocaFacil.LocaFacil.dao.ClienteDAO;
import com.LocaFacil.LocaFacil.model.Cliente;
import com.LocaFacil.LocaFacil.service.ClienteService;

public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteDAO clienteDAO;

	@Override
	public Cliente salvar(Cliente cliente) throws SQLException {
		return clienteDAO.salvar(cliente);
	}

	@Override
	public Optional<Cliente> buscarPorId(Long id) {
		return clienteDAO.buscarPorId(id);
	}

}
