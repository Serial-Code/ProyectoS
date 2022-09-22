package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entitys.Cliente;
import com.example.demo.repository.ClienteRepository;

@Service
public class ClienteServices {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> listaClientes(){
		
		return clienteRepository.findAll();
	}
	
	public Cliente guardar(Cliente cliente) {
		
		return clienteRepository.save(cliente);
	}
	
	public Cliente get(Integer id) {
		
		return clienteRepository.findById(id).get();
	}
	
	public void delete(Integer id) {
		
		clienteRepository.deleteById(id);
	}
	
	
}
