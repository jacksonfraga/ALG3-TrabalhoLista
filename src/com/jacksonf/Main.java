package com.jacksonf;

public class Main {

	public static void main(String[] args) {
		
		Lista lista = new Lista();
		lista.loadFromFile();
		
		lista.showConsole();
		
		
		System.out.println("APLICAÇÃO ENCERRADA!!!");
	}

}
