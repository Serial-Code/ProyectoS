package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entitys.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
