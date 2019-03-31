package com.larreaf.macowins;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;

import com.google.gson.JsonIOException;
/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws JsonIOException, IOException {
		
		DescuentoPromocion descuento = DescuentoPromocion.getDescuento();
		descuento.setValorDescuento(10);
		
		Negocio elNegocio = new Negocio();
		
		LocalDate fecha = LocalDate.now();
		
		Prenda remeraVerde = new Prenda(new Promocion(), 20, "remera verde");
		Prenda remera = new Prenda(new Liquidacion(), 80, "remera");
		Prenda campera = new Prenda(new Nuevo(), 180, "campera");
		Prenda saco = new Prenda(new Nuevo(), 200, "saco");
		
		Venta venta1 = new VentaConTarjeta(LocalDate.now(), 10, (float) 1);
		Venta venta2 = new Venta(LocalDate.parse("2018-05-23"));
		Venta venta3 = new Venta(LocalDate.now());
		Venta venta4 = new Venta(LocalDate.parse("2019-01-20"));
		
		venta1.agregarItem(new Item(campera, 10), new Item(remera, 40));
		venta2.agregarItem(new Item(remera, 10), new Item(remera, 50), new Item(campera, 15));
		venta3.agregarItem( new Item(saco, 7));
		venta4.agregarItem(new Item(remeraVerde,1));
		elNegocio.agregarVenta(venta1, venta2, venta3, venta4);
		
		
		System.out.println("Ganancias del negocio el día "+ fecha + ": $" + elNegocio.gananciasDeUnDia(fecha));
		System.out.println(elNegocio);
		
		
		//NegocioJson.toJson(elNegocio);
		/*
		Negocio negocio = NegocioJson.fromJson();
		System.out.println(negocio);
		*/
		
	}
}
