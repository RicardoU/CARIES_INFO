package com.unbosque.info.entidad;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the diente database table.
 * 
 */
@Entity
@Table(name="diente")
public class Diente implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@Column(name = "descripcion", nullable = false)
	private String descripcion;
	
	@Column(name = "id_propiedad", nullable = false)
	private Integer idPropiedad;

	public Diente() {
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getIdPropiedad() {
		return idPropiedad;
	}

	public void setIdPropiedad(Integer idPropiedad) {
		this.idPropiedad = idPropiedad;
	}

}