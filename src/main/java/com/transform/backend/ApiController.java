package com.transform.backend;

import java.io.IOException;
import java.io.StringWriter;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.transform.dao.ProductoDAO;
import com.transform.models.Producto;

@RestController
@RequestMapping("controller")
public class ApiController {

	//Aca van los endpoints, este es un endpoint de prueba
	//Cuando le pegamos aca nos va a devolver lo que le pidamos
	//value -> link a donde le pegamos en el endpoint
	//method es el method usado .GET para obtener info .POST para mandar
	//headers va a ser el tipo de dato que vamos a recibir
	@RequestMapping(value = "/getTest", method = RequestMethod.GET)
	public ResponseEntity<String> testEndpoint_1() {
		HttpHeaders httpHeaders = new HttpHeaders();
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		Producto productoTest = new Producto("prueba","producto de prueba", "", "Esto es un test de producto", new ArrayList<String>());
		//configure Object mapper for pretty print
		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
				
		StringWriter stringProducto = new StringWriter();
		try {
			objectMapper.writeValue(stringProducto, productoTest);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(stringProducto);
		return new ResponseEntity<String>(httpHeaders,HttpStatus.OK);
	}
	
	//EndPoint Example: localhost:8080/controller/searchByName?searchName=botella
	@RequestMapping(value="/searchByName", method = RequestMethod.GET)
	@ResponseBody
	public List<String> searchByNameEndPoint(@RequestParam("name") String name) {
		List<String> jsonList = new ArrayList<String>();

		//We create the Gson consructor
		Gson gson = new Gson();
		
		List<Producto> productos = ProductoDAO.searchByName(name);
		for(Producto pr: productos) {
			String jsonProd = gson.toJson(pr);
			jsonList.add(jsonProd);
		}
		
		// # # # T O D O # # #
		//TODO conect with DAO so we can return non mocked values
		
		return jsonList;
	}

	@RequestMapping(value="/searchByTagEndPoint", method = RequestMethod.GET)
	@ResponseBody
	public List<String> searchByTagEndPoint(@RequestParam("tag1") String tag1, @RequestParam("tag2") String tag2) {
		List<String> jsonList = new ArrayList<String>();
		//Producto mock (we should get this from the daos)
		ArrayList tags1 = new ArrayList<String>();
		tags1.add("tag1");
		tags1.add("tag2");
		Producto mockProducto1 = new Producto("botella1","botella 1", "estoEsUnaURL", "botella de plastico", tags1);		
		//We create the jsonString with gson.toJson(producto)
		String jsonProduct1 = gson.toJson(mockProducto1);
		
		ArrayList tags2 = new ArrayList<String>();
		tags1.add("tag1");
		tags1.add("tag3");
		Producto mockProducto2 = new Producto("botella2","botella 2", "estoEsUnaURL", "botella de vidrio", tags2);
		String jsonProduct2 = gson.toJson(mockProducto2);

		//We create the Gson consructor
		Gson gson = new Gson();
		
		List<Producto> productos = ProductoDAO.searchByTag(tag1, tag2);
		for(Producto pr: productos) {
			String jsonProd = gson.toJson(pr);
			jsonList.add(jsonProd);
		}
				
		// # # # T O D O # # #
		//TODO conect with DAO so we can return non mocked values
		
		return jsonList;
	}

	@RequestMapping(value="/searchById", method = RequestMethod.GET)
	@ResponseBody
	public String searchById(@RequestParam("id") String id) {
		//We create the Gson consructor
		Gson gson = new Gson();
		
		Producto product = ProductoDAO.searchById(id);
		String jsonProduct = gson.toJson(product);
				
		// # # # T O D O # # #
		//TODO conect with DAO so we can return non mocked values
		
		return jsonProduct;
	}

}