package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entitys.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioServices {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> listaUsuarios(){
		
		return usuarioRepository.findAll();
		
	}
	
	public Usuario guardar(Usuario usuario) {
		
		return usuarioRepository.save(usuario);
	}
	
	public Usuario get (Integer id) {
		
		return usuarioRepository.findById(id).get();
	}
	
	public void delete (Integer id) {
		
		usuarioRepository.deleteById(id);
	}
	
}
