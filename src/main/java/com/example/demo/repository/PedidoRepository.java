package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entitys.Pedido;


public interface PedidoRepository extends JpaRepository <Pedido, Integer>{

}