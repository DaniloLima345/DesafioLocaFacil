package com.LocaFacil.LocaFacil.paginacao;

import java.util.ArrayList;
import java.util.List;

public class Pagina<T> {

	private ConfigPagina config;
	private List<T> payload = new ArrayList<T>();

	public ConfigPagina getConfig() {
		return config;
	}

	public void setConfig(ConfigPagina config) {
		this.config = config;
	}

	public List<T> getPayload() {
		return payload;
	}

	public void setPayload(List<T> payload) {
		this.payload = payload;
	}
}
