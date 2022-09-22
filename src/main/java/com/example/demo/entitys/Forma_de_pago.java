package com.example.demo.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "forma_de_pago")
public class Forma_de_pago {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idforma_de_pago;
	@Column
	private String forma_de_pago;
	
	
	
	public Forma_de_pago() {
		super();
	}
	
	
	public Integer getIdforma_de_pago() {
		return idforma_de_pago;
	}
	public void setIdforma_de_pago(Integer idforma_de_pago) {
		this.idforma_de_pago = idforma_de_pago;
	}
	public String getForma_de_pago() {
		return forma_de_pago;
	}
	public void setForma_de_pago(String forma_de_pago) {
		this.forma_de_pago = forma_de_pago;
	}
	
	
	
	
}
