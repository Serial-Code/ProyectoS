package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entitys.Proveedor;
import com.example.demo.repository.ProveedorRepository;


@Service
public class ProveedorServices {
	@Autowired
	private ProveedorRepository proveedorRepository;
	
	public List<Proveedor> listaProveedor(){
		
		return proveedorRepository.findAll();
		
	}
	
	public Proveedor guardar(Proveedor proveedor) {
		
		return proveedorRepository.save(proveedor);
	}
	
	public Proveedor get (Integer id) {
		
		return proveedorRepository.findById(id).get();
	}
	
	public void delete (Integer id) {
		
		proveedorRepository.deleteById(id);
	}
}
