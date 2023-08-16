package com.LocaFacil.LocaFacil.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import com.LocaFacil.LocaFacil.model.Cliente;
import com.LocaFacil.LocaFacil.paginacao.ConfigPagina;

@Component
public class ClienteDAO extends DataAccessObject<Cliente> {

	@Override
	public Cliente salvar(Cliente cliente) {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(dataSource).usingGeneratedKeyColumns("ID")
				.withTableName("CLIENTE");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("NOME", cliente.getNome());
		parameters.put("CPF", cliente.getCpf());
		parameters.put("DATANASCIMENTO", cliente.getDataNascimento());
		parameters.put("STATUS_CLIENTE", cliente.isStatus());

		return buscarPorId(insert.executeAndReturnKey(parameters).longValue()).get();
	}

	@Override
	public Optional<Cliente> buscarPorId(Long id) {

		String sql = "SELECT * FROM CLIENTE WHERE ID = ?";

		return jdbcTemplate.queryForObject(sql, new RowMapper<Optional<Cliente>>() {
			@Override
			public Optional<Cliente> mapRow(ResultSet rs, int rowNum) throws SQLException {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getLong("ID"));
				cliente.setNome(rs.getString("NOME"));
				cliente.setCpf(rs.getLong("CPF"));
				cliente.setDataNascimento(rs.getDate("DATANASCIMENTO").toLocalDate());
				cliente.setStatus(rs.getBoolean("STATUS_CLIENTE"));
				return Optional.of(cliente);
			}
		}, new Object[] { id });
	}

	@Override
	public List<Cliente> listarTodos(ConfigPagina configPagina) {
		String sql = "SELECT * FROM CLIENTE LIMIT ?, ?";

		return jdbcTemplate.query(sql, new RowMapper<Cliente>() {

			@Override
			public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getLong("ID"));
				cliente.setNome(rs.getString("NOME"));
				cliente.setCpf(rs.getLong("CPF"));
				cliente.setDataNascimento(rs.getDate("DATANASCIMENTO").toLocalDate());
				cliente.setStatus(rs.getBoolean("STATUS_CLIENTE"));
				return cliente;
			}
		}, new Object[] { configPagina.getPrimeiroElemento(), configPagina.getTamanho() });
	}

	@Override
	public void atualizar(Cliente cliente, Long id) {

		Cliente clienteAntigo = buscarPorId(id).get();
		
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("UPDATE CLIENTE SET ");

		if (cliente.getNome() != null)
			if(!clienteAntigo.getNome().equals(cliente.getNome()))
				sqlBuilder.append("NOME = '" + cliente.getNome() + "'");
			else
				throw new RuntimeException();
		if (cliente.getCpf() != null)
			if(!clienteAntigo.getCpf().equals(cliente.getCpf()) )
				sqlBuilder.append("CPF = '" + cliente.getCpf() + "'");
			else
				throw new RuntimeException();
		if (cliente.getDataNascimento() != null)
			if(!clienteAntigo.getDataNascimento().equals(cliente.getDataNascimento()))
				sqlBuilder.append("DATANASCIMENTO = '" + cliente.getDataNascimento() + "'");
			else
				throw new RuntimeException();

		sqlBuilder.append("WHERE ID = " + id);

		String sql = sqlBuilder.toString();
		jdbcTemplate.update(sql);
	}

	public void deletar(Long id) {
		String sql = "DELETE FROM CLIENTE WHERE ID = ?";

		jdbcTemplate.update(sql, new Object[] { id });
	}
}
