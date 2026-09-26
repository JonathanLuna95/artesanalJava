package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.NegocioMejorado;

public class TestClientes {

    public static void main(String[] args) {

        NegocioMejorado negocio = new NegocioMejorado();

        // Registrar clientes
        negocio.registrarCliente("Juan", "1714616123");
        negocio.registrarCliente("Pedro", "1723456789");

        // Validar clientes registrados
        System.out.println("=== CLIENTES REGISTRADOS ===");

        for (Cliente cliente : negocio.getClientes()) {
            System.out.println("Nombre: " + cliente.getNombre());
            System.out.println("Cédula: " + cliente.getCedula());
            System.out.println("Código: " + cliente.getCodigo());
            System.out.println("-------------------------");
        }

        // Buscar cliente por cédula
        System.out.println("=== BÚSQUEDA POR CÉDULA ===");

        Cliente clienteCedula = negocio.buscarClientePorCedula("1714616123");

        if (clienteCedula != null) {
            System.out.println("Cliente encontrado:");
            System.out.println("Nombre: " + clienteCedula.getNombre());
            System.out.println("Cédula: " + clienteCedula.getCedula());
            System.out.println("Código: " + clienteCedula.getCodigo());
        } else {
            System.out.println("Cliente no encontrado");
        }

        // Buscar cliente por código
        System.out.println("=== BÚSQUEDA POR CÓDIGO ===");

        Cliente clienteCodigo = negocio.buscarClientePorCodigo(101);

        if (clienteCodigo != null) {
            System.out.println("Cliente encontrado:");
            System.out.println("Nombre: " + clienteCodigo.getNombre());
            System.out.println("Cédula: " + clienteCodigo.getCedula());
            System.out.println("Código: " + clienteCodigo.getCodigo());
        } else {
            System.out.println("Cliente no encontrado");
        }
    }
}