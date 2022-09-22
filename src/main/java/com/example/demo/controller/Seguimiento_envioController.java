package com.example.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entitys.Seguimiento_envio;
import com.example.demo.services.Seguimiento_envioServices;

@RestController
@RequestMapping("/api")
public class Seguimiento_envioController {
	
	@Autowired
	private Seguimiento_envioServices seguimiento_envioServices;
	
	@GetMapping("/seguimiento/listar")
	public ResponseEntity<List<Seguimiento_envio>> list(){
		
		return new ResponseEntity<>(seguimiento_envioServices.listaSeguimientoEnv(), HttpStatus.OK);
		
	}
	
	@GetMapping("/seguimiento/listar/{id}")
	public ResponseEntity<Seguimiento_envio> get(@PathVariable Integer id){
		
		try {
			
			Seguimiento_envio seguimiento_envio = seguimiento_envioServices.get(id);
			
			return new ResponseEntity<Seguimiento_envio>(seguimiento_envio, HttpStatus.OK);
			
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Seguimiento_envio>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/seguimiento/guardar")
	public ResponseEntity<Seguimiento_envio> save(@RequestBody Seguimiento_envio seguimiento_envio){
		
		seguimiento_envioServices.guardar(seguimiento_envio);
		return new ResponseEntity<Seguimiento_envio>(seguimiento_envioServices.guardar(seguimiento_envio), HttpStatus.CREATED);
	}
	
	@PutMapping("/seguimiento/actualizar/{id}")
	public ResponseEntity<?> update(@RequestBody Seguimiento_envio seguimiento_envio, @PathVariable Integer id){
		
		try {
			
			Seguimiento_envio existeSeguimiento_envio = seguimiento_envioServices.get(id);
			seguimiento_envio.setIdseguimiento_envio(id);
			seguimiento_envioServices.guardar(seguimiento_envio);
			
			return new ResponseEntity<>(HttpStatus.OK);
			
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("/seguimiento/eliminar/{id}")
	public ResponseEntity<Object> delete(@PathVariable Integer id){
		
		seguimiento_envioServices.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}

	
	
}
