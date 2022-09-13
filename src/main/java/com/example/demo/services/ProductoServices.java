package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entitys.Producto;
import com.example.demo.repository.ProductoRepository;


@Service
public class ProductoServices {
	
	@Autowired
	private ProductoRepository productoRepository;
	
	public List<Producto> listaProducto(){
		
		return productoRepository.findAll();
		
	}
	
	public Producto guardar(Producto producto) {
		
		return productoRepository.save(producto);
	}
	
	public Producto get (Integer id) {
		
		return productoRepository.findById(id).get();
	}
	
	public void delete (Integer id) {
		
		productoRepository.deleteById(id);
	}
}
