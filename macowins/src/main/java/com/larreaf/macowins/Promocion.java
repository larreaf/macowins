package com.larreaf.macowins;

public class Promocion implements Estado {
	private String estado = "promocion";
	
	public double precioFinal(double precioBase) {
		
		return precioBase - DescuentoPromocion.getDescuento().getValorDescuento();
	}
	
	@Override
	public String toString() {
		return estado;
	}
}
