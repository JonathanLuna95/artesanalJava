package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestConsumo {

    @Test
    public void consumirCervezaTest() {

        NegocioMejorado negocio = new NegocioMejorado();

        // Agregar una máquina
        negocio.agregarMaquina("Pilsener", "Cerveza rubia", 0.01);

        // Obtener la máquina creada
        Maquina maquina = negocio.getMaquinas().get(0);

        // Llenar las máquinas
        negocio.cargarMaquinas();

        // Registrar un cliente
        negocio.registrarCliente("Juan", "1714616123");

        // Obtener el cliente
        Cliente cliente = negocio.buscarClientePorCodigo(100);

        // Consumir 500 ml
        negocio.consumirCerveza(100, maquina.getCodigo(), 500);

        // 500 ml x $0.01 = $5.00
        assertEquals(5.0, cliente.getTotalConsumido(), 0.001);
    }
    
    @Test
    public void consultarValorVendidoTest() {

        NegocioMejorado negocio = new NegocioMejorado();

        // Agregar una máquina
        negocio.agregarMaquina("Pilsener", "Cerveza rubia", 0.01);

        // Obtener la máquina creada
        Maquina maquina = negocio.getMaquinas().get(0);

        // Llenar las máquinas
        negocio.cargarMaquinas();

        // Registrar dos clientes
        negocio.registrarCliente("Juan", "1714616123");
        negocio.registrarCliente("Pedro", "1723456789");

        // Juan consume 500 ml = $5.00
        negocio.consumirCerveza(100, maquina.getCodigo(), 500);

        // Pedro consume 300 ml = $3.00
        negocio.consumirCerveza(101, maquina.getCodigo(), 300);

        // Total vendido = $8.00
        double totalVendido = negocio.consultarValorVendido();

        assertEquals(8.0, totalVendido, 0.001);
    }
}