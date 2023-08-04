package com.LocaFacil.LocaFacil.dao;

import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class DataAccessObject<T> {

	@Autowired
	protected JdbcTemplate jdbcTemplate;
	@Autowired
	protected DataSource dataSource;
	
	public abstract T salvar(T object);
	
	public abstract Optional<T> buscarPorId(Long id);
}
