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

import com.example.demo.entitys.Cliente;
import com.example.demo.services.ClienteServices;

@RestController
@RequestMapping("/api")
public class ClienteController {

	@Autowired
	private ClienteServices clienteServices;
	
	@GetMapping("/cliente/listar")
	public ResponseEntity <List<Cliente>> list(){
		
		return new ResponseEntity<>(clienteServices.listaClientes(), HttpStatus.OK);
	}
	
	@GetMapping("/cliente/listar/{id}")
	public ResponseEntity<Cliente> get(@PathVariable Integer id){
		
		try {
			Cliente cliente = clienteServices.get(id);
			
			return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
			
		} catch(NoSuchElementException e) {
				return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
			
		}
	}
	
	@PostMapping("/cliente/guardar")
	public ResponseEntity<Cliente> save(@RequestBody Cliente cliente){
		
		clienteServices.guardar(cliente);
		return new ResponseEntity<>(clienteServices.guardar(cliente), HttpStatus.CREATED);
		
	}
	
	@PutMapping("/cliente/actualizar/{id}")
	public ResponseEntity<?> update(@RequestBody Cliente cliente, @PathVariable Integer id){
		
		try {
			Cliente existeCliente = clienteServices.get(id);
			cliente.setIdcliente(id);
			clienteServices.guardar(cliente);
			
			return new ResponseEntity<>(HttpStatus.OK);
			
		} catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
		
		
	}
	
	@DeleteMapping("/cliente/eliminar/{id}")
	public ResponseEntity<Object> delete(@PathVariable Integer id){
		
		clienteServices.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
