package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestNegocioMejorado {

    @Test
    public void generarCodigoTest() {

        NegocioMejorado negocio = new NegocioMejorado();

        String codigo = negocio.generarCodigo();

        assertNotNull(codigo);
        assertTrue(codigo.startsWith("M-"));

        int numero = Integer.parseInt(codigo.substring(2));

        assertTrue(numero >= 1 && numero <= 100);
    }

    @Test
    public void recuperarMaquinaExistenteTest() {

        NegocioMejorado negocio = new NegocioMejorado();

        negocio.agregarMaquina("Pilsener", "Cerveza rubia", 0.01);

        Maquina maquinaAgregada = negocio.getMaquinas().get(0);
        String codigo = maquinaAgregada.getCodigo();

        Maquina encontrada = negocio.recuperarMaquina(codigo);

        assertNotNull(encontrada);
        assertEquals(codigo, encontrada.getCodigo());
    }

    @Test
    public void recuperarMaquinaNoExistenteTest() {

        NegocioMejorado negocio = new NegocioMejorado();

        Maquina encontrada = negocio.recuperarMaquina("M-999");

        assertNull(encontrada);
    }
    
    @Test
    public void agregarMaquinaTest() {

        NegocioMejorado negocio = new NegocioMejorado();

        boolean resultado = negocio.agregarMaquina(
                "Pilsener",
                "Cerveza rubia",
                0.01
        );

        assertTrue(resultado);
        assertEquals(1, negocio.getMaquinas().size());
    }
}