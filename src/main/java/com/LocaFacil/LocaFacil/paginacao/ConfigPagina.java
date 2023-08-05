package com.LocaFacil.LocaFacil.paginacao;

public class ConfigPagina {

	private int tamanho = 5;
	private int numero = 1;
	private int primeiroElemento;

	public ConfigPagina(int tamanho, int numero) {
		this.tamanho = tamanho;
		this.numero = numero;

		calcularPrimeiroElemento();
	}

	private void calcularPrimeiroElemento() {
		this.primeiroElemento = this.numero - 1 + (this.tamanho * this.numero - (this.tamanho + (this.numero - 1)));
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getPrimeiroElemento() {
		return primeiroElemento;
	}

	public void setPrimeiroElemento(int primeiroElemento) {
		this.primeiroElemento = primeiroElemento;
	}
}
