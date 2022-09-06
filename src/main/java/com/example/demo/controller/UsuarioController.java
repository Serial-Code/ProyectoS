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

import com.example.demo.entitys.Usuario;
import com.example.demo.services.UsuarioServices;

@RestController
@RequestMapping("/api")
public class UsuarioController {
	
	@Autowired
	private UsuarioServices usuarioServices;
	
	@GetMapping("/usuario/listar")
	public ResponseEntity <List<Usuario>> list(){
		
		return new ResponseEntity<>(usuarioServices.listaUsuarios(), HttpStatus.OK);	
	}
	
	
	
	@GetMapping("/usuario/listar/{id}")
	public ResponseEntity<Usuario> get(@PathVariable Integer id){
		
		try {
			
			Usuario usuario = usuarioServices.get(id);
			
			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
			
		} catch (NoSuchElementException e) {
			
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	@PostMapping("/usuario/guardar")
	public ResponseEntity<Usuario> save (@RequestBody Usuario usuario){
		
		usuarioServices.guardar(usuario);
		return new ResponseEntity<>(usuarioServices.guardar(usuario), HttpStatus.CREATED);
		
	}
	
	
	@PutMapping("/usuario/actualizar/{id}")
	public ResponseEntity<?> update(@RequestBody Usuario usuario, @PathVariable Integer id){
		
		try {
			Usuario existeUsuario = usuarioServices.get(id);
			usuario.setIdusuario(id);
			usuarioServices.guardar(usuario);
			
			return new ResponseEntity<>(HttpStatus.OK);
			
		} catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
		
		
	}
	
	
	@DeleteMapping("/usuario/eliminar/{id}")
	public ResponseEntity<Object> delete(@PathVariable Integer id){
		
		usuarioServices.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	
}