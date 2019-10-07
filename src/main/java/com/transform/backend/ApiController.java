package com.transform.backend;

import java.net.URI;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("controller")
public class ApiController {

	//Aca van los endpoints, este es un endpoint de prueba
	//Cuando le pegamos aca nos va a devolver lo que le pidamos
	//value -> link a donde le pegamos en el endpoint
	//method es el method usado .GET para obtener info .POST para mandar
	//headers va a ser el tipo de dato que vamos a recibir
	@RequestMapping(value = "/getTest", method = RequestMethod.GET, headers="Accept=application/json")
	public ResponseEntity<String> testEndpoint_1() {

		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
