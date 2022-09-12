package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entitys.Inventario;
import com.example.demo.repository.InventarioRepository;


@Service
public class InventarioServices {
	
	@Autowired
	private InventarioRepository inventarioRepository;
	
	public List<Inventario> listaInventario(){
		
		return inventarioRepository.findAll();
		
	}
	
	public Inventario guardar(Inventario inventario) {
		
		return inventarioRepository.save(inventario);
	}
	
	public Inventario get (Integer id) {
		
		return inventarioRepository.findById(id).get();
	}
	
	public void delete (Integer id) {
		
		inventarioRepository.deleteById(id);
	}
}
