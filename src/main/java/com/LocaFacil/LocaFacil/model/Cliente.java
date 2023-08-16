package com.LocaFacil.LocaFacil.model;

import java.time.LocalDate;

import com.LocaFacil.LocaFacil.dto.ClienteDTO;

public class Cliente {

	private Long id;
	private String nome;
	private Long cpf;
	private LocalDate dataNascimento;
	private boolean status;
	
	public Cliente() {
		
	}
	
	public Cliente(ClienteDTO dto) {
		this.id = dto.id();
		this.nome = dto.nome();
		this.cpf = dto.cpf();
		this.dataNascimento = dto.dataNascimento();
		this.status = dto.status();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public boolean isStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
