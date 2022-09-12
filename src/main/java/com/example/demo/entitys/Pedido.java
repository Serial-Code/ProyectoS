package com.example.demo.entitys;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idpedido;
	@Column
	private int cantidadTotal;
	@Column
	private Date fecha;
	@Column
	private String direccion;
	@Column
	private double descuento;
	@Column
	private int idcliente;
	@Column
	private int idseguimiento_envio;
	@Column
	private int idforma_de_pago;
	public Pedido() {
		super();
	}
	public Integer getIdpedido() {
		return idpedido;
	}
	public void setIdpedido(Integer idpedido) {
		this.idpedido = idpedido;
	}
	public int getCantidadTotal() {
		return cantidadTotal;
	}
	public void setCantidadTotal(int cantidadTotal) {
		this.cantidadTotal = cantidadTotal;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	public int getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}
	public int getIdseguimiento_envio() {
		return idseguimiento_envio;
	}
	public void setIdseguimiento_envio(int idseguimiento_envio) {
		this.idseguimiento_envio = idseguimiento_envio;
	}
	public int getIdforma_de_pago() {
		return idforma_de_pago;
	}
	public void setIdforma_de_pago(int idforma_de_pago) {
		this.idforma_de_pago = idforma_de_pago;
	}
	
}