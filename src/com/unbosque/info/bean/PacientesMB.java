package com.unbosque.info.bean;


import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
 

import org.primefaces.context.RequestContext;
 
@ManagedBean (name = "pacientesMB")
@SessionScoped
public class PacientesMB implements Serializable {
	
private static final long serialVersionUID = 2563448963468460743L;
	
	private PacientesMB registroSeleccionado;
   
	private String nompa;
    private String apepa;
    private String idepa;
    private String edadpa;
    private String generopa;
    private String ciudadpa;
    private String csaludpa;
    private String denticionpa;
    private String proyectospa;

	public String getNompa() {
		return nompa;
	}

	public void setNompa(String nompa) {
		this.nompa = nompa;
	}

	public String getApepa() {
		return apepa;
	}

	public void setApepa(String apepa) {
		this.apepa = apepa;
	}

	public String getEdadpa() {
		return edadpa;
	}

	public void setEdadpa(String edadpa) {
		this.edadpa = edadpa;
	}

	public String getGeneropa() {
		return generopa;
	}

	public void setGeneropa(String generopa) {
		this.generopa = generopa;
	}

	public String getCiudadpa() {
		return ciudadpa;
	}

	public void setCiudadpa(String ciudadpa) {
		this.ciudadpa = ciudadpa;
	}

	public String getCsaludpa() {
		return csaludpa;
	}

	public void setCsaludpa(String csaludpa) {
		this.csaludpa = csaludpa;
	}

	public String getDenticionpa() {
		return denticionpa;
	}

	public void setDenticionpa(String denticionpa) {
		this.denticionpa = denticionpa;
	}

	public String getIdepa() {
		return idepa;
	}

	public void setIdepa(String idepa) {
		this.idepa = idepa;
	}

	public String getProyectospa() {
		return proyectospa;
	}

	public void setProyectospa(String proyectospa) {
		this.proyectospa = proyectospa;
	}

	public PacientesMB getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(PacientesMB registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}

	public void crearPa(ActionEvent event) {
	        RequestContext context = RequestContext.getCurrentInstance();
	        FacesContext contex = FacesContext.getCurrentInstance();
	        
	        FacesMessage message = null;
	        boolean loggedIn = false;
	         
	        if(nompa != null && apepa != null && edadpa != null && generopa != null && ciudadpa != null && csaludpa != null && denticionpa != null
	        		&& idepa != null && proyectospa != null) {
	        	

	            loggedIn = true;
	            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "creado", nompa);
	        	}
	        	
	         else {
	            loggedIn = false;
	            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "crear Error", "Invalid credentials");
	        }
	         
	        FacesContext.getCurrentInstance().addMessage(null, message);
	        //context.addCallbackParam("loggedIn", loggedIn);
	    }
	
	public void crearOdon(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesContext contex = FacesContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedOff = false;
        
        loggedOff = false;
             message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sesión cerrada", "Invalid credentials");
        
            try {
				contex.getExternalContext().redirect("Odontograma.jsf");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedOff", loggedOff);
    }  
	
	public void consultar(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesContext contex = FacesContext.getCurrentInstance();
        
        FacesMessage message = null;
        boolean loggedIn = false;
         
        if(idepa != null ) {
        	

            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "consulta", idepa);
        	}
        	
         else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error consulta", "Invalid credentials");
        }
         
        FacesContext.getCurrentInstance().addMessage(null, message);
        //context.addCallbackParam("loggedIn", loggedIn);
    }
	
}