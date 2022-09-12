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

import com.example.demo.entitys.Venta;
import com.example.demo.services.VentaServices;

@RestController
@RequestMapping("/api")
public class VentaController {
	
		@Autowired
		private VentaServices ventaServices;
		
		@GetMapping("/venta/listar")
		public ResponseEntity <List<Venta>> list(){
			
			return new ResponseEntity<>(ventaServices.listaVentas(), HttpStatus.OK);	
		}
		
		
		
		@GetMapping("/venta/listar/{id}")
		public ResponseEntity<Venta> get(@PathVariable Integer id){
			
			try {
				
				Venta venta = ventaServices.get(id);
				
				return new ResponseEntity<Venta>(venta, HttpStatus.OK);
				
			} catch (NoSuchElementException e) {
				
				return new ResponseEntity<Venta>(HttpStatus.NOT_FOUND);
			}
			
		}
		
		
		@PostMapping("/venta/guardar")
		public ResponseEntity<Venta> save (@RequestBody Venta venta){
			
			ventaServices.guardar(venta);
			return new ResponseEntity<>(ventaServices.guardar(venta), HttpStatus.CREATED);
			
		}
		
		
		@PutMapping("/venta/actualizar/{id}")
		public ResponseEntity<?> update(@RequestBody Venta venta, @PathVariable Integer id){
			
			try {
				Venta existeVenta = ventaServices.get(id);
				venta.setIdventa(id);
			    ventaServices.guardar(venta);
				
				return new ResponseEntity<>(HttpStatus.OK);
				
			} catch(NoSuchElementException e) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			
			
			
		}
		
		
		@DeleteMapping("/venta/eliminar/{id}")
		public ResponseEntity<Object> delete(@PathVariable Integer id){
			
			ventaServices.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
			
		}
		
}
