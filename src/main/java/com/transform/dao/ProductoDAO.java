package com.transform.dao;

import java.util.ArrayList;
import java.util.List;

import com.transform.models.Producto;

public class ProductoDAO {
	
	public ProductoDAO() {
		
	}
	
	static public List<Producto> searchByName(String name) {
		List<Producto> productos = new ArrayList<Producto>();
		
		//TODO Conectar con DB
		
		//Mock test of the DAO
		//Producto mock (we should get this from the daos)
		ArrayList tags1 = new ArrayList<String>();
		tags1.add("tag1");
		tags1.add("tag2");
		Producto mockProducto1 = new Producto("botella 1", "estoEsUnaURL", "botella de plastico", tags1);		
		
		ArrayList tags2 = new ArrayList<String>();
		tags2.add("tag1");
		tags2.add("tag3");
		Producto mockProducto2 = new Producto("botella 2", "estoEsUnaURL", "botella de vidrio", tags2);
		
		productos.add(mockProducto1);
		productos.add(mockProducto2);
		
		return productos;
	}

	static public List<Producto> searchByTag(String tag1, String tag2) {
		List<Producto> productos = new ArrayList<Producto>();
		
		//TODO Conectar con DB
		
		return productos;
	}
	
	static public Producto searchById(String id) {
		//TODO Conectar con DB
		
		return null;
	}
}
