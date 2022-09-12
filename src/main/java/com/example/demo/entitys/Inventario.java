package com.example.demo.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "inventario")
public class Inventario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idinventario;
	@Column
	private String categoria;
	@Column
	private int entradas;
	@Column
	private int salidas;
	@Column
	private String descripcion;
	@Column
	private int idproducto;
	public Inventario() {
		super();
	}
	public Integer getIdinventario() {
		return idinventario;
	}
	public void setIdinventario(Integer idinventario) {
		this.idinventario = idinventario;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getEntradas() {
		return entradas;
	}
	public void setEntradas(int entradas) {
		this.entradas = entradas;
	}
	public int getSalidas() {
		return salidas;
	}
	public void setSalidas(int salidas) {
		this.salidas = salidas;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getIdproducto() {
		return idproducto;
	}
	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}
	
}
