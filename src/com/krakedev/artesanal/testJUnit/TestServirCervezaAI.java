package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestServirCervezaAI {


		private static final double TOLERANCIA = 0.0001;

		@Test
		public void testServirCervezaConCantidadSuficiente() {

			// Valida que cuando existe suficiente cerveza:
			// 1. Se entregue la cantidad solicitada.
			// 2. Se reste dicha cantidad de la cantidad actual.
			// 3. Se retorne correctamente el valor a pagar.

			Maquina maquina = new Maquina("Pilsener", "Cerveza rubia", 0.02, 8000, "002");

			maquina.llenarMaquina();

			double valorPagar = maquina.servirCerveza(300);

			assertEquals(6.0, valorPagar, TOLERANCIA);
			assertEquals(7500, maquina.getCantidadActual(), TOLERANCIA);
		}

		@Test
		public void testServirExactamenteTodaLaCervezaDisponible() {

			// Valida el caso límite donde el cliente solicita exactamente
			// la misma cantidad de cerveza que se encuentra disponible.

			Maquina maquina = new Maquina("Porter", "Cerveza oscura", 0.03, "003");

			maquina.recargarCerveza(500);

			double valorPagar = maquina.servirCerveza(500);

			assertEquals(15.0, valorPagar, TOLERANCIA);
			assertEquals(0, maquina.getCantidadActual(), TOLERANCIA);
		}

		@Test
		public void testNoServirCuandoCantidadEsInsuficiente() {

			// Valida que si la máquina no tiene suficiente cerveza:
			// 1. No se sirva cerveza.
			// 2. La cantidad actual permanezca sin cambios.
			// 3. El valor retornado sea 0.

			Maquina maquina = new Maquina("IPA", "Cerveza artesanal", 0.025, "002");

			maquina.recargarCerveza(400);

			double valorPagar = maquina.servirCerveza(500);

			assertEquals(0, valorPagar, TOLERANCIA);
			assertEquals(400, maquina.getCantidadActual(), TOLERANCIA);
		}

		@Test
		public void testServirCantidadCero() {

			// Valida el caso límite de solicitar 0 mililitros.
			// El valor a pagar debe ser 0 y la cantidad actual
			// de cerveza no debe modificarse.

			Maquina maquina = new Maquina("Stout", "Cerveza negra", 0.04, 5000, "002");

			maquina.llenarMaquina();

			double cantidadInicial = maquina.getCantidadActual();

			double valorPagar = maquina.servirCerveza(0);

			assertEquals(0, valorPagar, TOLERANCIA);
			assertEquals(cantidadInicial, maquina.getCantidadActual(), TOLERANCIA);
		}
	}

