package com.unbosque.info.entidad;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the proyecto database table.
 * 
 */
@Entity
@Table(name="proyecto")
public class Proyecto implements Serializable {
	private static final long serialVersionUID = 1L;

	
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name="id_ciudad")
	private String idCiudad;

	@Column(name="id_dpto")
	private String idDpto;

	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@Column(name = "estado", nullable = false)
	private String estado;

	public Proyecto() {
		super();
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdCiudad() {
		return this.idCiudad;
	}

	public void setIdCiudad(String idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getIdDpto() {
		return this.idDpto;
	}

	public void setIdDpto(String idDpto) {
		this.idDpto = idDpto;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}