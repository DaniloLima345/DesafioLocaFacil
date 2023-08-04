package com.LocaFacil.LocaFacil.dto;

import java.time.LocalDate;

import com.LocaFacil.LocaFacil.model.Cliente;

public record ClienteDTO(Long id, String nome, Long cpf, LocalDate dataNascimento, boolean status) {

	public ClienteDTO(Cliente cliente) {
		this(cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getDataNascimento(), cliente.isStatus());
	}
}
