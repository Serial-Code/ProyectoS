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

import com.example.demo.entitys.Cotizacion;
import com.example.demo.services.CotizacionServices;



@RestController
@RequestMapping("/api")
public class CotizacionController {
	
	@Autowired
	private CotizacionServices cotizacionServices;
	
	@GetMapping("/cotizacion/listar")
	public ResponseEntity <List<Cotizacion>> list(){
		
		return new ResponseEntity<>(cotizacionServices.listaCotizacion(), HttpStatus.OK);	
	}
	
	@GetMapping("/cotizacion/listar/{id}")
	public ResponseEntity<Cotizacion> get(@PathVariable Integer id){
		
		try {
			
			Cotizacion cotizacion = cotizacionServices.get(id);
			
			return new ResponseEntity<Cotizacion>(cotizacion, HttpStatus.OK);
			
		} catch (NoSuchElementException e) {
			
			return new ResponseEntity<Cotizacion>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	@PostMapping("/cotizacion/guardar")
	public ResponseEntity<Cotizacion> save (@RequestBody Cotizacion cotizacion){
		
		cotizacionServices.guardar(cotizacion);
		return new ResponseEntity<>(cotizacionServices.guardar(cotizacion), HttpStatus.CREATED);
		
	}

	@PutMapping("/cotizacion/actualizar/{id}")
	public ResponseEntity<?> update(@RequestBody Cotizacion cotizacion, @PathVariable Integer id){
		
		try {
			Cotizacion existeCotizacion = cotizacionServices.get(id);
			cotizacion.setIdcotizacion(id);
			cotizacionServices.guardar(cotizacion);
			
			return new ResponseEntity<>(HttpStatus.OK);
			
		} catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
		
	}
	
	@DeleteMapping("/Cotizacion/eliminar/{id}")
	public ResponseEntity<Object> delete(@PathVariable Integer id){
		
		cotizacionServices.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
}
