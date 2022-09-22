package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entitys.Cotizacion;
import com.example.demo.repository.CotizacionRepository;


@Service
public class CotizacionServices {

	@Autowired
	private CotizacionRepository cotizacionRepository;
	
	public List<Cotizacion> listaCotizacion(){
		
		return cotizacionRepository.findAll();
		
	}
	
	public Cotizacion guardar(Cotizacion cotizacion) {
		
		return cotizacionRepository.save(cotizacion);
	}
	
	public Cotizacion get (Integer id) {
		
		return cotizacionRepository.findById(id).get();
	}
	
	public void delete (Integer id) {
		
		cotizacionRepository.deleteById(id);
	}
}
