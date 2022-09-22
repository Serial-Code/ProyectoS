package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entitys.Seguimiento_envio;
import com.example.demo.repository.Seguimiento_envioRepository;

@Service
public class Seguimiento_envioServices {

	@Autowired
	private Seguimiento_envioRepository seguimiento_envioRepository;
	
	public List<Seguimiento_envio> listaSeguimientoEnv(){
		
		return seguimiento_envioRepository.findAll();
	}
	
	public Seguimiento_envio guardar(Seguimiento_envio seguimiento_envio) {
		
		return seguimiento_envioRepository.save(seguimiento_envio);
	}
	
	public Seguimiento_envio get(Integer id) {
		
		return seguimiento_envioRepository.findById(id).get();
	}
	
	public void delete (Integer id) {
		
		seguimiento_envioRepository.deleteById(id);
	}
	
	
	
	
}
