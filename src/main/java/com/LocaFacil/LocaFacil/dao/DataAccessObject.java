package com.LocaFacil.LocaFacil.dao;

import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.LocaFacil.LocaFacil.paginacao.ConfigPagina;

public abstract class DataAccessObject<T> {

	@Autowired
	protected JdbcTemplate jdbcTemplate;
	@Autowired
	protected DataSource dataSource;
	
	public abstract T salvar(T object);
	
	public abstract Optional<T> buscarPorId(Long id);

	public abstract List<T> listarTodos(ConfigPagina configPagina);
	
	public abstract void atualizar(T Object, Long id);
	
	public abstract void deletar(Long id);
}
