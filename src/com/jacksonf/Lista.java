package com.jacksonf;

import java.io.IOException;

public class Lista {

	private Nodo inicio;
	private Nodo fim;

	public Lista() {
		inicio = null;
		fim = null;
	}

	public void loadFromFile() {
		String filePath = "C:\\temp\\dados.txt";
		Arquivo arquivo = new Arquivo(filePath);

		try {

			arquivo.openTextFile();
			while (arquivo.next()) {
				String Linha = arquivo.readLine();

				String[] vDados = Linha.split("#");

				Contato contato = new Contato();
				contato.setNome(vDados[0]);
				contato.setEndereco(vDados[1]);

				if (vDados.length >= 3)
					contato.setTelefone(vDados[2]);

				this.adicionaOrdem(contato);
			}

			arquivo.openTextFileWriter();
			arquivo.closeTextFile();

		} catch (IOException e) {
			System.out.println("ERRO: " + e);
		}
	}

	public boolean vazia() {
		return inicio == null;
	}

	public void adicionaOrdem(Contato contato) {
		if (inicio == null) {
			adicionaInicio(contato);
		} else {
			Nodo tmp = inicio;

			boolean add = false;

			do {
				if (tmp.getRegistro().getNome().compareTo(contato.getNome()) > 0) {
					if (inicio == tmp) {
						adicionaInicio(contato);
					} else {
						Nodo novo = new Nodo(tmp.getAnterior(), contato, tmp);
						tmp.getAnterior().setProximo(novo);
						tmp.setAnterior(novo);
					}

					add = true;
					break;
				}

				tmp = tmp.getProximo();

			} while (tmp != null); // && tmp.getProximo() != null);

			if (!add)
				adicionaFim(contato);
		}
	}

	public void adicionaFim(Contato contato) {

		Nodo tmp = new Nodo(fim, contato, null);
		if (inicio == null) {
			inicio = tmp;
			fim = tmp;
		} else {
			fim.setProximo(tmp);
			fim = tmp;
		}
	}

	public void adicionaInicio(Contato contato) {
		Nodo tmp = new Nodo(null, contato, inicio);
		if (inicio == null) {
			inicio = tmp;
			fim = tmp;
		} else {
			inicio.setAnterior(tmp);
			inicio = tmp;
		}
	}

	public void showConsole() {
		Nodo aux;
		aux = inicio;
		while (aux != null) {
			aux.getRegistro().ShowConsole();
			aux = aux.getProximo();
		}
	}

	public Nodo buscaSimples(Contato elemento) {
		Nodo p = inicio;
		while ((p != null)
				&& (!p.getRegistro().getNome().equals(elemento.getNome()))) {
			p = p.getProximo();
		}
		if ((p != null) && (p.getRegistro() == elemento))
			return p;
		else
			return null;
	}

	private void liberaNodo(Nodo nodo) {
		nodo.setAnterior(null);
		nodo.setProximo(null);
		nodo = null;
	}

	private void removeInicio(Nodo nodo) {
		inicio = nodo.getProximo();
		nodo.getProximo().setAnterior(null);
	}

	private void removeFinal(Nodo nodo) {
		fim = nodo.getAnterior();
		nodo.getAnterior().setProximo(null);
	}

	private void removeMeio(Nodo nodo) {
		nodo.getAnterior().setProximo(nodo.getProximo());
		nodo.getProximo().setAnterior(nodo.getAnterior());
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
					removeInicio(pos);
				} else if (pos == fim)// se for no fim
				{
					removeFinal(pos);
				} else {
					removeMeio(pos);
				}
				liberaNodo(pos);

			} else {
				inicio = null;
				fim = null;
			}
		} else
			System.out.println("Elemento não esta na lista");
	}
}
