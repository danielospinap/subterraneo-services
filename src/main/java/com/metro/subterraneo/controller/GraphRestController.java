package com.metro.subterraneo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class GraphRestController {

	@GetMapping(value= "/greet")
	public ResponseEntity<String> greet() {
		return new ResponseEntity<>("hello world", HttpStatus.OK);
	}
}
