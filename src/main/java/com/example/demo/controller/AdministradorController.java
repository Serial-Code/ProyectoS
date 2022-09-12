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

import com.example.demo.entitys.Administrador;
import com.example.demo.services.AdministradorServices;

@RestController
@RequestMapping("/api")
public class AdministradorController {

	@Autowired
	private AdministradorServices administradorServices;
	
	@GetMapping("/administrador/listar")
	public ResponseEntity <List<Administrador>> list(){
		
		return new ResponseEntity<>(administradorServices.listaAdministrador(), HttpStatus.OK);	
	}
	
	
	
	@GetMapping("/administrador/listar/{id}")
	public ResponseEntity<Administrador> get(@PathVariable Integer id){
		
		try {
			
			Administrador administrador = administradorServices.get(id);
			
			return new ResponseEntity<Administrador>(administrador, HttpStatus.OK);
			
		} catch (NoSuchElementException e) {
			
			return new ResponseEntity<Administrador>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	@PostMapping("/administrador/guardar")
	public ResponseEntity<Administrador> save (@RequestBody Administrador administrador){
		
		administradorServices.guardar(administrador);
		return new ResponseEntity<>(administradorServices.guardar(administrador), HttpStatus.CREATED);
		
	}
	
	
	@PutMapping("/administrador/actualizar/{id}")
	public ResponseEntity<?> update(@RequestBody Administrador administrador, @PathVariable Integer id){
		
		try {
			Administrador existeAdministrador = administradorServices.get(id);
			administrador.setIdadministrador(id);
			administradorServices.guardar(administrador);
			
			return new ResponseEntity<>(HttpStatus.OK);
			
		} catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
		
		
	}
	
	
	@DeleteMapping("/dministrador/eliminar/{id}")
	public ResponseEntity<Object> delete(@PathVariable Integer id){
		
		administradorServices.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
}
