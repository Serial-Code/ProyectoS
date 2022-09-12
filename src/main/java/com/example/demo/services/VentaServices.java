package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entitys.Venta;
import com.example.demo.repository.VentaRepository;

public class VentaServices {
	
	@Autowired
	private VentaRepository ventaRepository;
	
	public List<Venta> listaVentas(){
		
		return ventaRepository.findAll();
		
	}
	
	public Venta guardar(Venta venta) {
		
		return ventaRepository.save(venta);
	}
	
	public Venta get (Integer id) {
		
		return ventaRepository.findById(id).get();
	}
	
	public void delete (Integer id) {
		
		ventaRepository.deleteById(id);
	}
}
