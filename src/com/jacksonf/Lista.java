package com.jacksonf;

public class Lista {

	private Nodo inicio;
	private Nodo fim;

	public Lista() {
		inicio = null;
		fim = null;
	}

	public void addEnd(Contato contato) {

		Nodo tmp = new Nodo(contato, null, inicio);
		if (inicio == null) {
			inicio = tmp;
			fim = tmp;
		} else {
			fim.setProximo(tmp);
			fim = tmp;
		}
	}

	public void addBegin(Contato contato) {
		Nodo caixa = new Nodo(contato, inicio, null);
		if (inicio == null) {
			inicio = caixa;
			fim = caixa;
		} else {
			inicio.setAnterior(caixa);
			inicio = caixa;
		}
	}

	public void Show() {
		Nodo aux;
		aux = inicio;
		while (aux != null) {
			aux.getRegistro().ShowConsole();
			aux = aux.getProximo();
		}
	}

	public Nodo buscaSimples(Contato elemento) {
		Nodo p = inicio;
		while ((p != null) && (p.getRegistro() != elemento)) {
			p = p.getProximo();
		}
		if ((p != null) && (p.getRegistro() == elemento))
			return p;
		else
			return null;
	}
	
	private void removeListaInicio(Nodo nodo)
	{
		inicio = nodo.getProximo();
		nodo.getProximo().setAnterior(null);
	}
	
	private void removeListaFinal(Nodo nodo)
	{
		fim = nodo.getAnterior();
		nodo.getAnterior().setProximo(null);
	}

	public void removeLista(Contato elemento) {
		Nodo pos;
		pos = buscaSimples(elemento);
		if (pos != null)// se existe o Contato a ser deletado
		{
			if (inicio != fim)// se forem diferentes, há mais q um
			{
				if (pos == inicio)// se for no inicio
				{
					removeListaInicio(pos);
				} else if (pos == fim)// se for no fim
				{
					removeListaFinal(pos);
				} else
				{
					pos.getAnterior().setProximo(pos.getProximo());
					pos.getProximo().setAnterior(pos.getAnterior());
				}
				pos.setAnterior(null);
				pos.setProximo(null);
			} else {
				inicio = null;
				fim = null;
			}
		} else
			System.out.println("Elemento nao encontrado");
	}
}
