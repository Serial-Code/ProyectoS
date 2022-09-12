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

import com.example.demo.entitys.Pedido;
import com.example.demo.services.PedidoServices;


@RestController
@RequestMapping("/api")
public class PedidoController {
	@Autowired
	private PedidoServices pedidoServices;
	
	@GetMapping("/pedido/listar")
	public ResponseEntity <List<Pedido>> list(){
		
		return new ResponseEntity<>(pedidoServices.listaPedido(), HttpStatus.OK);	
	}
	
	
	
	@GetMapping("/pedido/listar/{id}")
	public ResponseEntity<Pedido> get(@PathVariable Integer id){
		
		try {
			
			Pedido pedido = pedidoServices.get(id);
			
			return new ResponseEntity<Pedido>(pedido, HttpStatus.OK);
			
		} catch (NoSuchElementException e) {
			
			return new ResponseEntity<Pedido>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	@PostMapping("/pedido/guardar")
	public ResponseEntity<Pedido> save (@RequestBody Pedido pedido){
		
		pedidoServices.guardar(pedido);
		return new ResponseEntity<>(pedidoServices.guardar(pedido), HttpStatus.CREATED);
		
	}
	
	
	@PutMapping("/pedido/actualizar/{id}")
	public ResponseEntity<?> update(@RequestBody Pedido pedido, @PathVariable Integer id){
		
		try {
			Pedido existePedido = pedidoServices.get(id);
			pedido.setIdpedido(id);
			pedidoServices.guardar(pedido);
			
			return new ResponseEntity<>(HttpStatus.OK);
			
		} catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
		
		
	}
	
	
	@DeleteMapping("/pedido/eliminar/{id}")
	public ResponseEntity<Object> delete(@PathVariable Integer id){
		
		pedidoServices.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}

}
