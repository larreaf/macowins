package com.larreaf.macowins;

public class Liquidacion implements Estado {
	private String estado = "liquidacion";
	@Override
	public double precioFinal(double precioBase) {
		return precioBase * 0.5;
	}
	
	@Override
	public String toString() {
		return estado;
	}
}
