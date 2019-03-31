package com.larreaf.macowins;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Venta {
	private List<Item> items;

	public List<Item> getItems() {
		return items;
	}

	private LocalDate fecha;

	public Venta( LocalDate unaFecha) {
		items = new ArrayList<Item>();
		fecha = unaFecha;
	}

	public double importe() {
		
		double resultado = items.stream()
				.mapToDouble(Item::importe)
				.sum();
		return resultado;
	}

	public boolean esDeFecha(LocalDate unaFecha) {
		return this.fecha.equals(unaFecha);
	}
	
	public void agregarItem(Item item) {
		items.add(item);
	}
	public void agregarItem(List<Item> items) {
		items.addAll(items);
	}
	public void agregarItem(Item... variosItems) {
		Collections.addAll(items, variosItems);
	}
	
	@Override
	public String toString() {
		return "Venta realizada en la fecha: " + this.fecha.toString() + " se vendió: " + Conversor.itemsToString(items) + "\n\tTotal: $" + this.importe() + "\n";
	}
}
