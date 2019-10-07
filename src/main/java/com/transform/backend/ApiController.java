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
	//Aca van los endpoints
	@RequestMapping(value = "/getTest", method = RequestMethod.GET, headers="Accept=application/json")
	//@ResponseBody
	public ResponseEntity<String> testEndpoint_1() {
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Content_Type", "application/json");
//		headers.add("Responded", "hola mundo");
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//				.path("/getTest").buildAndExpand(headers).toUri();
//		return ResponseEntity.created(location).build();
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
