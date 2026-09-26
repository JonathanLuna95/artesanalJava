package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {
	
	private ArrayList<Maquina> maquinas = new ArrayList<Maquina>();
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private int ultimoCodigo = 100;
	
	public ArrayList<Cliente> getClientes() {
	    return clientes;
	}

	public ArrayList<Maquina> getMaquinas() {
		return maquinas;
	}

	public void setMaquinas(ArrayList<Maquina> maquinas) {
		this.maquinas = maquinas;
	}
	
	public String generarCodigo() {
		int numero = (int) (Math.random() * 100) + 1;
		return "M-" + numero;
	}
	
	
	public boolean agregarMaquina(String nombreCerveza, String descripcion, double precioPorMl) {

	    String codigo = generarCodigo();

	    Maquina encontrada = recuperarMaquina(codigo);

	    if (encontrada == null) {
	        Maquina maquina = new Maquina(nombreCerveza, descripcion, precioPorMl, codigo);
	        maquinas.add(maquina);
	        return true;
	    } else {
	        return false;
	    }
	}
	
	public void cargarMaquinas() {
	    for (Maquina maquina : maquinas) {
	        maquina.llenarMaquina();
	    }
	}
	
	public Maquina recuperarMaquina(String codigo) {

	    for (Maquina maquina : maquinas) {
	        if (maquina.getCodigo().equals(codigo)) {
	            return maquina;
	        }
	    }

	    return null;
	}
	
	public void registrarCliente(String nombre, String cedula) {

	    Cliente cliente = new Cliente(nombre, cedula);

	    cliente.setCodigo(ultimoCodigo);
	    ultimoCodigo++;

	    clientes.add(cliente);
	}
	
	public Cliente buscarClientePorCedula(String cedula) {

	    for (Cliente cliente : clientes) {

	        if (cliente.getCedula().equals(cedula)) {
	            return cliente;
	        }
	    }

	    return null;
	}
	
	public Cliente buscarClientePorCodigo(int codigo) {

	    for (Cliente cliente : clientes) {

	        if (cliente.getCodigo() == codigo) {
	            return cliente;
	        }
	    }

	    return null;
	}

}
