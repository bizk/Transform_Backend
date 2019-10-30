package com.transform.daos;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.transform.configs.DbConfig;
import com.transform.models.Producto;

public class daoProducto {
	//es solo un test
	//lee json escrito como String
	public List<Producto> getAllProducts() throws FileNotFoundException {
		
		List<Producto> resultadoDeBusqueda=new ArrayList<Producto>();
		//Momento de la conexion con la BD
		
		MongoDatabase db = DbConfig.getConfiguration().getDB();
		MongoCollection<Document> collectionProductos = db.getCollection("productos");
		
		System.out.println("Collection productos selected successfully"); 

		// Getting the iterable object 
		FindIterable<Document> iterDoc = collectionProductos.find(); 
		int i = 1; 

		// Getting the iterator 
		Iterator<Document> it = iterDoc.iterator(); 

		ArrayList<Document> documentos = new ArrayList<Document>();	    
		while (it.hasNext()) {  
			documentos.add(it.next());
			i++; 
		}

		//System.out.println(documentos.get(4).toJson());
		
		Gson gson = new Gson();

				
		for(Document doc : documentos){
			String json = doc.toJson();
			Producto p = gson.fromJson(json, Producto.class);
			resultadoDeBusqueda.add(p);
		}
		
		
		return resultadoDeBusqueda;
		
	}
	
	//lee archivo .json
	public List<Producto> searchByName(String busqueda)  {
		List<Producto> resultadoDeBusqueda=new ArrayList<Producto>();
		try {
		List<Producto> productos = this.getAllProducts();
		for (Producto p : productos) {
			
			//creo que tambien sirve indexOf en lugar de contains
			if (p.getNombre().toLowerCase().contains(busqueda.toLowerCase())) {
				resultadoDeBusqueda.add(p);
			}
			
		}
		
		System.out.println(new Gson().toJson(resultadoDeBusqueda));
		
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return resultadoDeBusqueda;	
	}
	
	public List<Producto> searchByTag(List<String> tags) {
		
		List<Producto> resultadoDeBusqueda=new ArrayList<Producto>();
		try {
		List<Producto> productos = this.getAllProducts();
		
		for (Producto p : productos) {
			boolean alltags=true;
			for (String t:tags) {
				if(!p.getTags().contains(t.toLowerCase())) {
					alltags=false;
				}
				
			}
			if(alltags) {
				resultadoDeBusqueda.add(p);
			}
		}
		System.out.println(new Gson().toJson(resultadoDeBusqueda));
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return resultadoDeBusqueda;
		
	}
	
	//este metodo busca por id pero el gson no guarda ids porque no estan especificados en la clase de productos
	public Producto searchById(String busqueda)  {
		
		Producto resultadoDeBusqueda=null;
		try {
		List<Producto> productos = this.getAllProducts();
		
		for (Producto p : productos) {
			if(p.getID().equals(busqueda)) {
				resultadoDeBusqueda=p;
			}
		}
		
		System.out.println(new Gson().toJson(resultadoDeBusqueda));
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return resultadoDeBusqueda;
		
	}
	
}




