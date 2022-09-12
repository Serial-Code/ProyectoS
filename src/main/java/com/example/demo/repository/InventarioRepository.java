package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entitys.Inventario;

public interface InventarioRepository extends JpaRepository <Inventario, Integer>{

}
