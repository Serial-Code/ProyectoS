package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entitys.Pedido;
import com.example.demo.repository.PedidoRepository;

@Service
public class PedidoServices {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public List<Pedido> listaPedido(){
		
		return pedidoRepository.findAll();
		
	}
	
	public Pedido guardar(Pedido pedido) {
		
		return pedidoRepository.save(pedido);
	}
	
	public Pedido get (Integer id) {
		
		return pedidoRepository.findById(id).get();
	}
	
	public void delete (Integer id) {
		
		pedidoRepository.deleteById(id);
	}
}
