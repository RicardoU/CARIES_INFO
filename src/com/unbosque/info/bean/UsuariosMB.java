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
 
@ManagedBean (name = "usuariosMB")
@SessionScoped
public class UsuariosMB implements Serializable {
	
private static final long serialVersionUID = 5678093963468460743L;
	
	private UsuariosMB registroSeleccionado;
   
	private String nomus;
    private String apeus;
    private String ideus;
    private String us;
    private String passwordus;
    private String mailus;
    private String especus;
    private String telus;
    private String proyectosus;
	
	
	public String getNomus() {
		return nomus;
	}

	public void setNomus(String nomus) {
		this.nomus = nomus;
	}

	public String getApeus() {
		return apeus;
	}

	public void setApeus(String apeus) {
		this.apeus = apeus;
	}

	public String getUs() {
		return us;
	}

	public void setUs(String us) {
		this.us = us;
	}

	public String getPasswordus() {
		return passwordus;
	}

	public void setPasswordus(String passwordus) {
		this.passwordus = passwordus;
	}

	public String getMailus() {
		return mailus;
	}

	public void setMailus(String mailus) {
		this.mailus = mailus;
	}

	public String getProyectosus() {
		return proyectosus;
	}

	public void setProyectosus(String proyectosus) {
		this.proyectosus = proyectosus;
	}
	
	public String getIdeus() {
		return ideus;
	}

	public void setIdeus(String ideus) {
		this.ideus = ideus;
	}

	public String getEspecus() {
		return especus;
	}

	public void setEspecus(String especus) {
		this.especus = especus;
	}

	public String getTelus() {
		return telus;
	}

	public void setTelus(String telus) {
		this.telus = telus;
	}

	public UsuariosMB getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(UsuariosMB registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}

	public void crearUs(ActionEvent event) {
	        RequestContext context = RequestContext.getCurrentInstance();
	        FacesContext contex = FacesContext.getCurrentInstance();
	        
	        FacesMessage message = null;
	        boolean loggedIn = false;
	         
	        if(nomus != null && apeus != null && us != null && passwordus != null && mailus != null && ideus != null && especus != null &&  telus !=null) {
	        	

	        	
	        	String a = passwordus;
	        	a.toCharArray();
	        	String b = nomus;
	        	b.toCharArray();
	        	
	        	int nMay = 0, nMin = 0, nNum = 0, nNum1 = 0, cont = 0;
	        	String t1 = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
	        	String t2 = "abcdefghijklmnñopqrstuvwxyz";
	        	String t3 = "0123456789";
	        		for (int i=0;i<a.length();i++) {
	        			cont++;
	        			if ( t1.indexOf(a.charAt(i)) != -1 ){
	        				nMay++;
	        				}
	        			if ( t2.indexOf(a.charAt(i)) != -1 ) {
	        				nMin++;
	        				}
	        			if ( t3.indexOf(a.charAt(i)) != -1 ) {
	        				nNum++;
	        				}
	        		}
	        		if ( nMay<=0) {
	        			 loggedIn = false;
	     	            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "La contraseña debe contener al menos una letra mayuscula", "Invalid credentials");

	        		}
	        		if ( nMin<=0) {
	        			loggedIn = false;
	    	            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "La contraseña debe contener al menos una letra minuscula", "Invalid credentials");
	        		}
	        		if ( nNum<=0) {
	        			loggedIn = false;
	    	            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "La contraseña debe contener al menos un número", "Invalid credentials");
	        		}
	        		if ( cont<8) {
	        			loggedIn = false;
	    	            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "La contraseña debe contener al menos 8 carácteres", "Invalid credentials");
	        		}
	        		
	        		for (int i=0;i<b.length();i++) {
	        			if ( t3.indexOf(b.charAt(i)) != -1 ){
	        				nNum1++;
	        				}
	        		}
	        		
	        		if ( nNum1>0) {
	        			loggedIn = false;
	    	            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "El nombre no puede tener números ", "Invalid credentials");
	        		}
	        		
	        	 if(nMay>0 && nMin>0 && nNum>0 && cont>=8 && nNum1==0){
	        		
	        	
	        	
	            loggedIn = true;
	            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "creado", nomus);
	        	}
	        	
	        } else {
	            loggedIn = false;
	            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "crear Error", "Invalid credentials");
	        }
	         
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }
	
}