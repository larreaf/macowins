package com.larreaf.macowins;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class NegocioJson {

	public static void toJson(Negocio negocio) throws IOException {
		Writer writer = new FileWriter("negocio.json");
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		gson.toJson(negocio.getVentas(), writer);
		writer.flush(); 
		writer.close(); 
	}

	public static Negocio fromJson() throws FileNotFoundException {
		Negocio negocio = new Negocio();
		JsonReader reader = new JsonReader(new FileReader("negocio.json"));
		JsonParser parser = new JsonParser();
		
		JsonObject negocioJson = parser.parse(reader).getAsJsonObject();
		JsonArray ventasJson = negocioJson.get("ventas").getAsJsonArray();
		negocio.agregarVenta(ventaFromJson(ventasJson));
		
		return negocio;
	}
	
	private static List<Venta> ventaFromJson(JsonArray ventasJson){
		List<Venta> ventas = new ArrayList<Venta>();
		for (JsonElement ventaElement : ventasJson) {
			
			Venta unaVenta;
			
			JsonObject ventaObj = ventaElement.getAsJsonObject();
			JsonObject fechaJson = ventaObj.get("fecha").getAsJsonObject();
			
			LocalDate fecha = LocalDate.of(fechaJson.get("year").getAsInt(), fechaJson.get("month").getAsInt(), fechaJson.get("day").getAsInt());
			
			if (ventaObj.has("coeficiente") && ventaObj.has("cuotas")) {
				unaVenta = new VentaConTarjeta(fecha, ventaObj.get("cuotas").getAsInt(),
						ventaObj.get("coeficiente").getAsDouble());
			} else {
				unaVenta = new Venta(fecha);
			}
			JsonArray itemArray = ventaObj.get("items").getAsJsonArray();
			unaVenta.agregarItem(itemsFromJson(itemArray));
			ventas.add(unaVenta);
		}
		return ventas;
	}
	private static List<Item> itemsFromJson(JsonArray itemArray) {
		List<Item> items = new ArrayList<Item>();
		for (JsonElement itemElement : itemArray) {
			
			JsonObject itemObj = itemElement.getAsJsonObject();
			JsonObject prendaObj = itemObj.get("prenda").getAsJsonObject();
			
			String nombreEstado = prendaObj.get("estado").getAsJsonObject().get("estado").getAsString();
			Prenda prenda = new Prenda(EstadoBuilder.crearEstado(nombreEstado),	prendaObj.get("precioBase").getAsDouble(), prendaObj.get("tipo").getAsString() );
			
			items.add(new Item(prenda, itemObj.get("cantidad").getAsInt()));
		}
		return items;
		
	}
}
