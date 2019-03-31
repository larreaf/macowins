package com.larreaf.macowins;

import java.time.LocalDate;

public class VentaConTarjeta extends Venta {
	private double coeficiente;
	private int cuotas;

	public VentaConTarjeta( LocalDate unaFecha, int cantidadCuotas, double coeficienteTarjeta) {
		super( unaFecha);

		cuotas = cantidadCuotas;
		coeficiente = coeficienteTarjeta;
	}

	@Override
	public double importe() {
		double resultado =  this.getItems().stream()
				.mapToDouble(item -> item.importe() * 1.01)
				.sum();
		return resultado + cuotas * coeficiente;
	}

}
