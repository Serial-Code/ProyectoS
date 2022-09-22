package com.example.demo.entitys;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seguimiento_envio")
public class Seguimiento_envio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer idseguimiento_envio;
	@Column
	public Integer referencia_envio;
	@Column
	public Date fechainicio;
	@Column
	public Date fechafin;
	@Column
	public String destino;
	
	
	
	public Seguimiento_envio() {
		super();
	}
	
	
	public Integer getIdseguimiento_envio() {
		return idseguimiento_envio;
	}
	public void setIdseguimiento_envio(Integer idseguimiento_envio) {
		this.idseguimiento_envio = idseguimiento_envio;
	}
	public Integer getReferencia_envio() {
		return referencia_envio;
	}
	public void setReferencia_envio(Integer referencia_envio) {
		this.referencia_envio = referencia_envio;
	}
	public Date getFechainicio() {
		return fechainicio;
	}
	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}
	public Date getFechafin() {
		return fechafin;
	}
	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	
	
	
	
}
