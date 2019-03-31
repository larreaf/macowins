package com.larreaf.macowins;
// (No es el patron Builder)
public class EstadoBuilder {
	public static Estado crearEstado(String nombreEstado) {
		Estado unEstado = null;
		switch(nombreEstado) {
		case "nuevo":
			unEstado = new Nuevo();
			break;
		case "liquidacion":
			unEstado = new Liquidacion();
			break;
		case "promocion":
			unEstado = new Promocion();
			break;
		}
		return unEstado;
	}
}
