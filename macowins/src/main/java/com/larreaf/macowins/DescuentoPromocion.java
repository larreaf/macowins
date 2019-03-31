package com.larreaf.macowins;

public class DescuentoPromocion {
	private static DescuentoPromocion descuentoPromocion_instancia;
	private double valorDescuento;
	
	private DescuentoPromocion() {}
	
	public static DescuentoPromocion getDescuento() {
		if (descuentoPromocion_instancia == null) {
			descuentoPromocion_instancia =  new DescuentoPromocion();
		}
		return descuentoPromocion_instancia;
	}

	public double getValorDescuento() {
		return valorDescuento;
	}

	public void setValorDescuento(double valorDescuento) {
		this.valorDescuento = valorDescuento;
	}
	
}
