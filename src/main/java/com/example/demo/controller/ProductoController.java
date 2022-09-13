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

import com.example.demo.entitys.Producto;
import com.example.demo.services.ProductoServices;


@RestController
@RequestMapping("/api")
public class ProductoController {
	
	@Autowired
	private ProductoServices productoServices;
	
	@GetMapping("/producto/listar")
	public ResponseEntity <List<Producto>> list(){
		
		return new ResponseEntity<>(productoServices.listaProducto(), HttpStatus.OK);	
	}
	
	
	
	@GetMapping("/producto/listar/{id}")
	public ResponseEntity<Producto> get(@PathVariable Integer id){
		
		try {
			
			Producto producto = productoServices.get(id);
			
			return new ResponseEntity<Producto>(producto, HttpStatus.OK);
			
		} catch (NoSuchElementException e) {
			
			return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	@PostMapping("/producto/guardar")
	public ResponseEntity<Producto> save (@RequestBody Producto producto){
		
		productoServices.guardar(producto);
		return new ResponseEntity<>(productoServices.guardar(producto), HttpStatus.CREATED);
		
	}
	
	
	@PutMapping("/producto/actualizar/{id}")
	public ResponseEntity<?> update(@RequestBody Producto producto, @PathVariable Integer id){
		
		try {
			Producto existeProducto = productoServices.get(id);
			producto.setIdproducto(id);
			productoServices.guardar(producto);
			
			return new ResponseEntity<>(HttpStatus.OK);
			
		} catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
		
		
	}
	
	
	@DeleteMapping("/producto/eliminar/{id}")
	public ResponseEntity<Object> delete(@PathVariable Integer id){
		
		productoServices.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	
}
