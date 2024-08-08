package com.archivo.plano.api.service;

import java.io.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ArchivoPlano {
	@Value("${urlArchivo}")
	private String urlArchivo;
	
	public List<String> readFile(String request) throws IOException{
		List<String>lector = new ArrayList<>();
		String url = urlArchivo + request;
		try (var buffer = new BufferedReader(new InputStreamReader(new FileInputStream(url),"UTF-8"))) {
			String linea = "";
			while ((linea=buffer.readLine()) != null) {
				lector.add(linea);
			}
		}catch (FileNotFoundException e) {
				System.out.println("Archivo no encontrado " + url);
				e.printStackTrace();
			}
			return lector;
		}
	}

