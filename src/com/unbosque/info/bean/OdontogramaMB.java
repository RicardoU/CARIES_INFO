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

import com.unbosque.info.entidad.Odontograma;
import com.unbosque.info.service.OdontogramaService;

@ManagedBean(name = "odontogramaMB")
@SessionScoped
public class OdontogramaMB implements Serializable {

	private static final long serialVersionUID = 5409339568460749463L;

	private OdontogramaMB registroSeleccionado;

	// Spring Customer Service is injected...
	@ManagedProperty(value = "#{OdontogramaService}")
	OdontogramaService odontogramaService;

	List<Odontograma> odontogramaList;

	private int id;
	private int idPaciente;
	private int idDiente;
	private int idPropiedad;
	private int idPropiedad2;

	public void addOdontograma(int p) {
		try {
			

	        RequestContext context = RequestContext.getCurrentInstance();
	        FacesContext contex = FacesContext.getCurrentInstance();
			FacesMessage message = null;
		


			Odontograma odontograma = new Odontograma();
			this.setIdDiente(p);
			odontograma.setIdDiente(getIdDiente());
			odontograma.setIdPaciente(getIdPaciente());
			odontograma.setIdPropiedad(getIdPropiedad());
			odontograma.setIdPropiedad2(getIdPropiedad2());
			getOdontogramaService().addOdontograma(odontograma);
			reset();
			
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
					"Odontograma agregado exitosamente.");
			FacesContext.getCurrentInstance().addMessage(null, message);	
        		
			

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		

	}
	
	public int asignaOdontograma(int id) {
			

	        RequestContext context = RequestContext.getCurrentInstance();
	        FacesContext contex = FacesContext.getCurrentInstance();
			FacesMessage message = null;

			try {
				contex.getExternalContext().redirect("Odontograma.jsf");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.setIdPaciente(id);
			return id;
		

	}

	// Aqui colocamos el de borrado
	//public String deleteTriangulo(Triangulo triangulo) {
		//try {
			//triangulo.setEstado("I");
			//getTrianguloService().updateTriangulo(triangulo);
		//} catch (DataAccessException e) {
			//e.printStackTrace();
		//}

		//return null;

	//}

	public void reset() {
		this.setId(0);
		this.setIdDiente(0);
		this.setIdPaciente(0);
		this.setIdPropiedad(0);
		this.setIdPropiedad2(0);
	}

	public List<Odontograma> getOdontogramasList() {
		odontogramaList = new ArrayList<Odontograma>();
		odontogramaList.addAll(getOdontogramaService().getOdontogramas());
		return odontogramaList;
	}

	public OdontogramaService getOdontogramaService() {
		return odontogramaService;
	}

	public void setOdontogramaService(OdontogramaService odontogramaService) {
		this.odontogramaService = odontogramaService;
	}

	public List<Odontograma> getOdontogramaList() {
		return odontogramaList;
	}

	public void setOdontogramaList(List<Odontograma> odontogramaList) {
		this.odontogramaList = odontogramaList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	public int getIdDiente() {
		return idDiente;
	}

	public void setIdDiente(int idDiente) {
		this.idDiente = idDiente;
	}

	public int getIdPropiedad() {
		return idPropiedad;
	}

	public void setIdPropiedad(int idPropiedad) {
		this.idPropiedad = idPropiedad;
	}

	public int getIdPropiedad2() {
		return idPropiedad2;
	}

	public void setIdPropiedad2(int idPropiedad2) {
		this.idPropiedad2 = idPropiedad2;
	}

	public OdontogramaMB getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(OdontogramaMB registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}

}