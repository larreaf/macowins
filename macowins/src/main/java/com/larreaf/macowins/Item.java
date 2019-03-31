package com.larreaf.macowins;

public class Item {
	private Prenda prenda;
	private int cantidad;
	
	public Item(Prenda unaPrenda, int unaCantidad) {
		prenda = unaPrenda;
		cantidad = unaCantidad;
	}
	
	public double importe() {
		return (prenda.precio() * cantidad);
	}
	
	@Override
	public String toString() {
		return prenda + " - " + Integer.toString(cantidad) + " unidades";
	}
}
