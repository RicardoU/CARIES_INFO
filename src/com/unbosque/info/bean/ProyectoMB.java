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
import javax.faces.event.ActionEvent;

import org.springframework.dao.DataAccessException;





import org.primefaces.context.RequestContext;

import com.unbosque.info.entidad.Proyecto;
import com.unbosque.info.service.ProyectoService;
 
@ManagedBean (name = "proyectoMB")
@SessionScoped
public class ProyectoMB implements Serializable {
	
private static final long serialVersionUID = 464463468460743L;
	
	private ProyectoMB registroSeleccionado;
	
	// Spring Customer Service is injected...
		@ManagedProperty(value = "#{ProyectoService}")
		ProyectoService proyectoService;
   
	private String nompro;
    private String depar;
    private String ciudad;
	

    List<Proyecto> proyectoList;

    public void addProyecto() {
		try {

			RequestContext context = RequestContext.getCurrentInstance();
			FacesMessage message = null;

			Proyecto proyecto = new Proyecto();
			
			proyecto.setNombre(getNompro());
			proyecto.setEstado("A");
			proyecto.setIdCiudad(getCiudad());
			proyecto.setIdDpto(getDepar());
			getProyectoService().addProyecto(proyecto);
			reset();
			
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
					"Registro agregado exitosamente.");
			FacesContext.getCurrentInstance().addMessage(null, message);	

		} catch (DataAccessException e) {
			e.printStackTrace();
		}

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
		this.setNompro("");
		this.setCiudad("");
		this.setDepar("");
	}

	public List<Proyecto> getProyectosList() {
		proyectoList = new ArrayList<Proyecto>();
		proyectoList.addAll(getProyectoService().getProyectos());
		return proyectoList;
	}

	public ProyectoService getProyectoService() {
		return proyectoService;
	}

	public void setProyectoService(ProyectoService proyectoService) {
		this.proyectoService = proyectoService;
	}

	public List<Proyecto> getProyectoList() {
		return proyectoList;
	}

	public void setProyectoList(List<Proyecto> proyectoList) {
		this.proyectoList = proyectoList;
	}
    
    
	public String getNompro() {
		return nompro;
	}



	public void setNompro(String nompro) {
		this.nompro = nompro;
	}



	public String getDepar() {
		return depar;
	}



	public void setDepar(String depar) {
		this.depar = depar;
	}



	public String getCiudad() {
		return ciudad;
	}



	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public ProyectoMB getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(ProyectoMB registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}


	public void crearPro(ActionEvent event) {
	        RequestContext context = RequestContext.getCurrentInstance();
	        FacesContext contex = FacesContext.getCurrentInstance();
	        
	        FacesMessage message = null;
	        boolean loggedIn = false;
	         
	        if(nompro != null && depar != null && ciudad != null) {
	            loggedIn = true;
	            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "creado", nompro);
	        
	        } else {
	            loggedIn = false;
	            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "crear Error", "Invalid credentials");
	        }
	         
	        FacesContext.getCurrentInstance().addMessage(null, message);
	        //context.addCallbackParam("loggedIn", loggedIn);
	    }
	
}