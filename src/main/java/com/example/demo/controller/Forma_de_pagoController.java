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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entitys.Forma_de_pago;
import com.example.demo.entitys.Usuario;
import com.example.demo.services.Forma_de_pagoServices;

@RestController
@RequestMapping("/api")
public class Forma_de_pagoController {

	@Autowired
	private Forma_de_pagoServices forma_de_pagoServices;
	
	@GetMapping("/formaPago/listar")
	public ResponseEntity <List<Forma_de_pago>> list(){
		
		return new ResponseEntity<>(forma_de_pagoServices.listaFormaPago(), HttpStatus.OK);	
	}
	
	@GetMapping("/formaPago/listar/{id}")
	public ResponseEntity<Forma_de_pago> get(@PathVariable Integer id){
		
		try {
			
			Forma_de_pago forma_de_pago = forma_de_pagoServices.get(id);
			
			return new ResponseEntity<Forma_de_pago>(forma_de_pago, HttpStatus.OK);
			
			
		} catch(NoSuchElementException e) {
			
			return new ResponseEntity<Forma_de_pago>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	@PostMapping("/formaPago/guardar")
	public ResponseEntity<Forma_de_pago> save (@RequestBody Forma_de_pago forma_de_pago ){
		
		forma_de_pagoServices.guardar(forma_de_pago);
		return new ResponseEntity<>(forma_de_pagoServices.guardar(forma_de_pago), HttpStatus.CREATED);
		
	}
	
	
	@PostMapping("/formaPago/actualizar/{id}")
	public ResponseEntity<?> update(@RequestBody Forma_de_pago forma_de_pago, @PathVariable Integer id){
		try {
			Forma_de_pago existeForma_de_pago = forma_de_pagoServices.get(id);
			forma_de_pago.setIdforma_de_pago(id);
			forma_de_pagoServices.guardar(forma_de_pago);
			
			return new ResponseEntity<>(HttpStatus.OK);
			
		} catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	@DeleteMapping("/formaPago/eliminar/{id}")
	public ResponseEntity<Object> deleted(@PathVariable Integer id){
		
		forma_de_pagoServices.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
}
