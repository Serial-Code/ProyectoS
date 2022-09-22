package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entitys.Forma_de_pago;
import com.example.demo.repository.Forma_de_pagoRepository;

@Service
public class Forma_de_pagoServices {

	@Autowired
	private Forma_de_pagoRepository forma_de_pagoRepository;
	
	public List<Forma_de_pago> listaFormaPago(){
		
		return forma_de_pagoRepository.findAll();
	}
	
	public Forma_de_pago guardar(Forma_de_pago forma_de_pago) {
		
		return forma_de_pagoRepository.save(forma_de_pago);
	}
	
	public Forma_de_pago get(Integer id) {
		
		return forma_de_pagoRepository.findById(id).get();
	}
	
	public void delete(Integer id) {
		
		forma_de_pagoRepository.deleteById(id);
	}
	
	
}
