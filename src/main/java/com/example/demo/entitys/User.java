package com.example.demo.entitys;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy = "native")
	private long Id;
	
	@Column
	private String nombre;
	
	@Column
	private String apellido;
	
	@Column
	private String email;
	
	@Column
	private String usuario;
	
	@Column
	private String password;
	
	@Transient
	private String confirmarpassword;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="user_roles", joinColumns = @JoinColumn(name="user_id")
	,inverseJoinColumns = @JoinColumn(name = "roles_id"))
	private Set<Roles> roles;

	public User(long id) {
		super();
		Id = id;
	}

	public User() {

	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmarpassword() {
		return confirmarpassword;
	}

	public void setConfirmarpassword(String confirmarpassword) {
		this.confirmarpassword = confirmarpassword;
	}

	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}
	
	
	
	
	
	
	
	
	

	
}
