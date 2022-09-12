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

import com.example.demo.entitys.Inventario;
import com.example.demo.services.InventarioServices;

@RestController
@RequestMapping("/api")
public class InventarioController {
	@Autowired
	private InventarioServices inventarioServices;
	
	@GetMapping("/inventario/listar")
	public ResponseEntity <List<Inventario>> list(){
		
		return new ResponseEntity<>(inventarioServices.listaInventario(), HttpStatus.OK);	
	}
	
	
	
	@GetMapping("/inventario/listar/{id}")
	public ResponseEntity<Inventario> get(@PathVariable Integer id){
		
		try {
			
			Inventario inventario = inventarioServices.get(id);
			
			return new ResponseEntity<Inventario>(inventario, HttpStatus.OK);
			
		} catch (NoSuchElementException e) {
			
			return new ResponseEntity<Inventario>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	@PostMapping("/inventario/guardar")
	public ResponseEntity<Inventario> save (@RequestBody Inventario inventario){
		
		inventarioServices.guardar(inventario);
		return new ResponseEntity<>(inventarioServices.guardar(inventario), HttpStatus.CREATED);
		
	}
	
	
	@PutMapping("/inventario/actualizar/{id}")
	public ResponseEntity<?> update(@RequestBody Inventario inventario, @PathVariable Integer id){
		
		try {
			Inventario existeInventario = inventarioServices.get(id);
			inventario.setIdinventario(id);
			inventarioServices.guardar(inventario);
			
			return new ResponseEntity<>(HttpStatus.OK);
			
		} catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
		
		
	}
	
	
	@DeleteMapping("/inventario/eliminar/{id}")
	public ResponseEntity<Object> delete(@PathVariable Integer id){
		
		inventarioServices.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
}
