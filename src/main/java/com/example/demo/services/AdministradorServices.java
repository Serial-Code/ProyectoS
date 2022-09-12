package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entitys.Administrador;
import com.example.demo.repository.AdministradorRepository;

@Service
public class AdministradorServices {

	@Autowired
	private AdministradorRepository administradorRepository;
	
	public List<Administrador> listaAdministrador(){
		
		return administradorRepository.findAll();
		
	}
	
	public Administrador guardar(Administrador administrador) {
		
		return administradorRepository.save(administrador);
	}
	
	public Administrador get (Integer id) {
		
		return administradorRepository.findById(id).get();
	}
	
	public void delete (Integer id) {
		
		administradorRepository.deleteById(id);
	}
}
