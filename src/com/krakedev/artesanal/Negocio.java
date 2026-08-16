package com.krakedev.artesanal;

public class Negocio {

	private String nombre;
	private Maquina MaquinaA;
	private int ultimoCodigo = 100;
	
	
	
	public Negocio() {
		
	}

	public Negocio(String nombre, Maquina maquinaA) {
		this.nombre = nombre;
		MaquinaA = maquinaA;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Maquina getMaquinaA() {
		return MaquinaA;
	}

	public void setMaquinaA(Maquina maquinaA) {
		MaquinaA = maquinaA;
	}
	
	public void asignarCodigoCliente(Cliente cliente) {
		cliente.setCodigo(ultimoCodigo);
		ultimoCodigo ++;
	}
	
	public void cargarMaquinaA() {
		MaquinaA.llenarMaquina();
	}
	
	public void consumirCervezaMaquinaA(Cliente cliente, double ml) {
		double valor=MaquinaA.servirCerveza(ml);
		cliente.setTotalConsumido(cliente.getTotalConsumido()+valor);
	}

}
