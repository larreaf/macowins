package com.larreaf.macowins;

public class Nuevo implements Estado {
	private String estado = "nuevo";
	
	public double precioFinal(double precioBase) {

		return precioBase;
	}
	
	@Override
	public String toString() {
		return estado;
	}
}
