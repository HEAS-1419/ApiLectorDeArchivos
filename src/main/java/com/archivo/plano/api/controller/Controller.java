package com.archivo.plano.api.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.archivo.plano.api.service.ArchivoPlano;

@RestController
public class Controller {
	
	@Autowired
	private ArchivoPlano archivoPlano;
	
	@PostMapping("/Prueba")
	public List<String> getText(String request) throws IOException {
		return archivoPlano.readFile(request);
	}
	
}
