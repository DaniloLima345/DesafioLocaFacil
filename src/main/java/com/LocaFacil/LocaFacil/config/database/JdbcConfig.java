package com.LocaFacil.LocaFacil.config.database;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration //Le a classe antes de todas
@ComponentScan("jdbc") //indica o porque o spring scanneia esta classe primeiro
public class JdbcConfig {

	@Bean // Componente que o Spring gerencia
	public DataSource mysqlDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost/locafacil?useTimezone=true&serverTimezone=UTC");
		
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		return dataSource;
	}
	
}
