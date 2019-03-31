package com.larreaf.macowins;

public class Prenda {
	private double precioBase;
	private Estado estado;
	private String tipo;
	
	public Prenda(Estado unEstado, double unPrecio, String unTipo) {
		estado = unEstado;
		precioBase = unPrecio;
		tipo = unTipo;
	}
	
	public double precio() {
		return estado.precioFinal(precioBase);
	}
	
	@Override
	public String toString() {
		return tipo + ": (" + estado + ") a $" + Double.toString(precioBase);
	}
}
