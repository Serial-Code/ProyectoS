package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entitys.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario, Integer>{

}
