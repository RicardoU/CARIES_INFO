package com.unbosque.info.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.springframework.dao.DataAccessException;

import com.unbosque.info.entidad.Diente;
import com.unbosque.info.service.DienteService;

@ManagedBean(name = "dienteMB")
@SessionScoped
public class DienteMB implements Serializable {

	private static final long serialVersionUID = 5439568460749463L;

	private DienteMB registroSeleccionado;

	// Spring Customer Service is injected...
	@ManagedProperty(value = "#{DienteService}")
	DienteService dienteService;

	List<Diente> dienteList;

	private int id;
	private int idPropiedad;
	private String descripcion;
	private String nombre;

	public void addDiente() {
		try {
			

	        RequestContext context = RequestContext.getCurrentInstance();
	        FacesContext contex = FacesContext.getCurrentInstance();
			FacesMessage message = null;
		


			Diente diente = new Diente();

			diente.setDescripcion(getDescripcion());
			diente.setNombre(getNombre());
			diente.setIdPropiedad(getIdPropiedad());
			
			getDienteService().addDiente(diente);
			reset();
			
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
					"Diente agregado exitosamente.");
			FacesContext.getCurrentInstance().addMessage(null, message);	
        		
			

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		

	}



	public void reset() {
		this.setId(0);
		this.setNombre("");
		this.setDescripcion("");
		this.setIdPropiedad(0);
	}

	public List<Diente> getDientesList() {
		dienteList = new ArrayList<Diente>();
		dienteList.addAll(getDienteService().getDientes());
		return dienteList;
	}

	public DienteService getDienteService() {
		return dienteService;
	}

	public void setDienteService(DienteService dienteService) {
		this.dienteService = dienteService;
	}

	public List<Diente> getDienteList() {
		return dienteList;
	}

	public void setDienteList(List<Diente> dienteList) {
		this.dienteList = dienteList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public int getIdPropiedad() {
		return idPropiedad;
	}

	public void setIdPropiedad(int idPropiedad) {
		this.idPropiedad = idPropiedad;
	}

	public DienteMB getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(DienteMB registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}

}