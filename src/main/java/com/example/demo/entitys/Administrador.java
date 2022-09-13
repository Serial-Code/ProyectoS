package com.example.demo.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "administrador")
public class Administrador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idadministrador;
	@Column
	private String rut;
	public Administrador() {
		super();
	
	}
	public Integer getIdadministrador() {
		return idadministrador;
	}
	public void setIdadministrador(Integer idadministrador) {
		this.idadministrador = idadministrador;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
}
