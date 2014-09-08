package com.jacksonf;

public class Nodo {
	private Contato registro;
	private Nodo proximo;
	private Nodo anterior;
	
	
	
	public Nodo(Nodo anterior, Contato registro, Nodo proximo) {
		super();
		this.registro = registro;
		this.proximo = proximo;
		this.anterior = anterior;
	}
	
	public Contato getRegistro() {
		return registro;
	}
	public void setRegistro(Contato registro) {
		this.registro = registro;
	}
	public Nodo getProximo() {
		return proximo;
	}
	public void setProximo(Nodo proximo) {
		this.proximo = proximo;
	}
	public Nodo getAnterior() {
		return anterior;
	}
	public void setAnterior(Nodo anterior) {
		this.anterior = anterior;
	}
	
	
}
