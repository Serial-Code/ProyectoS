package com.example.demo.entitys;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cotizacion")
public class Cotizacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idcotizacion;
	@Column
	private Date fecha;
	@Column
	private double total;
	
	public Cotizacion() {
		super();

	}
	
	public Integer getIdcotizacion() {
		return idcotizacion;
	}
	public void setIdcotizacion(Integer idcotizacion) {
		this.idcotizacion = idcotizacion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
}
