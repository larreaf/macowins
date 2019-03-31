package com.larreaf.macowins;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Negocio {
	private List<Venta> ventas;

	public Negocio() {
		ventas = new ArrayList<Venta>();
	}

	public double gananciasDeUnDia(LocalDate unDia) {
		Predicate<Venta> predicado1 = (Venta venta) -> venta.esDeFecha(unDia);
		double ganancias = ventas.stream().filter(predicado1).mapToDouble(Venta::importe).sum();
		return ganancias;
	}

	public List<Venta> getVentas() {
		List<Venta> ventasCopia;
		ventasCopia = new ArrayList<Venta>();
		ventasCopia.addAll(ventas);
		return ventasCopia;
	}
	
	public void agregarVenta(Venta venta) {
		ventas.add(venta);
	}
	
	public void agregarVenta(List<Venta> ventas) {
		ventas.addAll(ventas);
	}
	
	public void agregarVenta(Venta... variasVentas) {
		Collections.addAll(ventas, variasVentas);
	}
	
	
	@Override
	public String toString() {
		return "Ventas del Negocio: " + ventas.stream()
				.map(a -> a.toString())
				.reduce("\n-------------------------------------------------------------------------\n",
						(a, b) -> "\t"+ a + "\t" + b + "-------------------------------------------------------------------------\n");
	}

}
