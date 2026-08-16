package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestLlenar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Maquina rubia = new Maquina("pilsener", "Cerveza fría", 0.02, 8000, "002");
		rubia.imprimir();
		
		rubia.llenarMaquina();
		rubia.imprimir();
		
		Maquina negra = new Maquina("Club", "Cereveza buena", 0.03, "003");
		negra.imprimir();
		
		negra.llenarMaquina();
		negra.imprimir();

	}
	
		

}
