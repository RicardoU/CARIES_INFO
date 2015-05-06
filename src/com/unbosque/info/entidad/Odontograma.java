package com.unbosque.info.entidad;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the odontograma database table.
 * 
 */
@Entity
@Table(name="odontograma")
public class Odontograma implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name="id_diente")
	private Integer idDiente;

	@Column(name="id_paciente")
	private Integer idPaciente;

	@Column(name="id_propiedad")
	private Integer idPropiedad;
	
	@Column(name="id_propiedad2")
	private Integer idPropiedad2;

	public Odontograma() {
		super();
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdDiente() {
		return this.idDiente;
	}

	public void setIdDiente(Integer idDiente) {
		this.idDiente = idDiente;
	}

	public Integer getIdPaciente() {
		return this.idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}

	public Integer getIdPropiedad() {
		return this.idPropiedad;
	}

	public void setIdPropiedad(Integer idPropiedad) {
		this.idPropiedad = idPropiedad;
	}

	public Integer getIdPropiedad2() {
		return idPropiedad2;
	}

	public void setIdPropiedad2(Integer idPropiedad2) {
		this.idPropiedad2 = idPropiedad2;
	}

}