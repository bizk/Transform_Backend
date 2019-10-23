package com.transform.daos;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class testDAO {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("buscar objetos con palabra botella:");
		new daoProducto().getObjetosArchNombre("botella");
		System.out.println("buscar objetos por tags:");
		List<String> tags= Stream.of("papel").collect(Collectors.toList());
		new daoProducto().getObjetosArchTags(tags);
		System.out.println("buscar objetos por id:");
		new daoProducto().getObjetosArchID("1-5");
		
	}

}
