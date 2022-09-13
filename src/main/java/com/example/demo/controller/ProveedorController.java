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

import com.example.demo.entitys.Proveedor;
import com.example.demo.services.ProveedorServices;

@RestController
@RequestMapping("/api")
public class ProveedorController {
	
	@Autowired
	private ProveedorServices proveedorServices;
	
	@GetMapping("/proveedor/listar")
	public ResponseEntity <List<Proveedor>> list(){
		
		return new ResponseEntity<>(proveedorServices.listaProveedor(), HttpStatus.OK);	
	}
	
	
	
	@GetMapping("/proveedor/listar/{id}")
	public ResponseEntity<Proveedor> get(@PathVariable Integer id){
		
		try {
			
			Proveedor proveedor = proveedorServices.get(id);
			
			return new ResponseEntity<Proveedor>(proveedor, HttpStatus.OK);
			
		} catch (NoSuchElementException e) {
			
			return new ResponseEntity<Proveedor>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	@PostMapping("/proveedor/guardar")
	public ResponseEntity<Proveedor> save (@RequestBody Proveedor proveedor){
		
		proveedorServices.guardar(proveedor);
		return new ResponseEntity<>(proveedorServices.guardar(proveedor), HttpStatus.CREATED);
		
	}
	
	
	@PutMapping("/proveedor/actualizar/{id}")
	public ResponseEntity<?> update(@RequestBody Proveedor proveedor, @PathVariable Integer id){
		
		try {
			Proveedor existeProveedor = proveedorServices.get(id);
			proveedor.setIdproveedor(id);
			proveedorServices.guardar(proveedor);
			
			return new ResponseEntity<>(HttpStatus.OK);
			
		} catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
		
		
	}
	
	
	@DeleteMapping("/proveedor/eliminar/{id}")
	public ResponseEntity<Object> delete(@PathVariable Integer id){
		
		proveedorServices.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	
}
