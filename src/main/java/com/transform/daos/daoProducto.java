package com.transform.daos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.transform.models.Producto;

public class daoProducto {
	//es solo un test
	//lee json escrito como String
	public List<Producto> getObjetosString() throws FileNotFoundException {
		
		List<Producto> resultadoDeBusqueda=new ArrayList<Producto>();
		
		JsonParser parser = new JsonParser();
		
		String js= ("[{\"id\":\"1-1\",\"nombre\":\"botella de plastico\",\"urlImg\":\"url_imagen\",\"descripcion\":\"botella de plastico\",\"tags\":[\"botella\",\"plastico\"],\"materiales\":[{\"id\":\"0-1\",\"nombre\":\"plastico\",\"logo\":\"url_logo\",\"es reciclable\":true,\"texto\":\"plastico\",\"como reciclar\":\"limpiar y secar\"}],\"posteos\":[\"2-1\",\"2-2\",\"2-3\",\"2-4\"]}]");
		
		JsonArray gsonArchivo=parser.parse(js).getAsJsonArray();
			
		Gson gson = new Gson();
			
		Producto[] productos=gson.fromJson(gsonArchivo, Producto[].class);
		System.out.println(new Gson().toJson(productos));
			
		for (Producto p:productos) {
			
			//no es necesario por ahora pero puede servir para buscar dentro de los nombres
			/*if (p.getNombre().contains(busqueda)) {
			}*/
			
			//muestra los productos
			System.out.println(p);
			
			resultadoDeBusqueda.add(p);
		}
		
		return resultadoDeBusqueda;
		
	}
	//lee archivo .json
	public List<Producto> getObjetosArchNombre(String busqueda) throws FileNotFoundException {
		
		List<Producto> resultadoDeBusqueda=new ArrayList<Producto>();
		
		JsonParser parser = new JsonParser();
		//para la obtener la direccion abrir las propiedades del archivo json y copiar direccion "location"
		JsonArray gsonArchivo=parser.parse(new FileReader(new File("C:\\Users\\fedej\\Locales\\seminario\\Transform_Backend\\src\\main\\java\\com\\transform\\daos\\datos.json"))).getAsJsonArray();
			
		Gson gson = new Gson();
			
		Producto[] productos=gson.fromJson(gsonArchivo, Producto[].class);
		
		for (Producto p:productos) {
			
			//creo que tambien sirve indexOf en lugar de contains
			if (p.getNombre().contains(busqueda)) {
				resultadoDeBusqueda.add(p);
			}
			
		}
		
		System.out.println(new Gson().toJson(resultadoDeBusqueda));
		
		return resultadoDeBusqueda;
		
	}
	
	public List<Producto> getObjetosArchTags(List<String> tags) throws FileNotFoundException {
		
		List<Producto> resultadoDeBusqueda=new ArrayList<Producto>();
		
		JsonParser parser = new JsonParser();
		//para la obtener la direccion abrir las propiedades del archivo json y copiar direccion "location"
		JsonArray gsonArchivo=parser.parse(new FileReader(new File("C:\\Users\\fedej\\Locales\\seminario\\Transform_Backend\\src\\main\\java\\com\\transform\\daos\\datos.json"))).getAsJsonArray();
			
		Gson gson = new Gson();
			
		Producto[] productos=gson.fromJson(gsonArchivo, Producto[].class);
		
		for (Producto p:productos) {
			boolean alltags=true;
			for (String t:tags) {
				if(!p.getTags().contains(t)) {
					alltags=false;
				}
				
			}
			if(alltags) {
				resultadoDeBusqueda.add(p);
			}
		}
		System.out.println(new Gson().toJson(resultadoDeBusqueda));
		return resultadoDeBusqueda;
		
	}
	
	//este metodo busca por id pero el gson no guarda ids porque no estan especificados en la clase de productos
	public Producto getObjetosArchID(String busqueda) throws FileNotFoundException {
		
		Producto resultadoDeBusqueda=null;
		
		JsonParser parser = new JsonParser();
		//para la obtener la direccion abrir las propiedades del archivo json y copiar direccion "location"
		JsonArray gsonArchivo=parser.parse(new FileReader(new File("C:\\Users\\fedej\\Locales\\seminario\\Transform_Backend\\src\\main\\java\\com\\transform\\daos\\datos.json"))).getAsJsonArray();
			
		Gson gson = new Gson();
			
		Producto[] productos=gson.fromJson(gsonArchivo, Producto[].class);
		
		for (Producto p:productos) {
			if(p.getID().equals(busqueda)) {
				resultadoDeBusqueda=p;
			}
		}
		
		System.out.println(new Gson().toJson(resultadoDeBusqueda));
		
		return resultadoDeBusqueda;
		
	}
	
}




