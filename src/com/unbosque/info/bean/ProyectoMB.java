package com.unbosque.info.bean;


import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.springframework.dao.DataAccessException;





import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

import com.unbosque.info.entidad.Proyecto;
import com.unbosque.info.entidad.Usuario;
import com.unbosque.info.service.ProyectoService;
import com.unbosque.info.util.Mailer;
 
@ManagedBean (name = "proyectoMB")
@SessionScoped
public class ProyectoMB implements Serializable {
	
private static final long serialVersionUID = 464463468460743L;
	
	private ProyectoMB registroSeleccionado;
	
	// Spring Customer Service is injected...
		@ManagedProperty(value = "#{ProyectoService}")
		ProyectoService proyectoService;
   
	private int id;
	private String nompro;
    private String depar;
    private String ciudad;
    private java.util.Date fecha1;
    private java.util.Date fecha2;
    private String tipo;
    private String poblacion;
    private String locacion;
	

    List<Proyecto> proyectoList;

    public java.sql.Date sqlDate(java.util.Date calendarDate) {
    	  return new java.sql.Date(calendarDate.getTime());
    	}
    
    
    public void addProyecto() {
		try {

			int errores = 0;
			
			RequestContext context = RequestContext.getCurrentInstance();
			FacesMessage message = null;
			
			boolean loggedIn = false;

			if(nompro.equals("")){
				
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "","Error, El nombre del Proyecto no puede estar vacío ");
				FacesContext.getCurrentInstance().addMessage(null, message);
				errores++;
			}
			
				String a = nompro;
				a.toCharArray();
				int nNum = 0;
				String t3 = "0123456789";
				
				for (int i=0;i<a.length();i++) {
        			if ( t3.indexOf(a.charAt(i)) != -1 ){
        				nNum++;
        				}
        		}
				
				if ( nNum!=0) {
					loggedIn = false;
    	            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "","El nombre del Proyecto no puede contener números");
    				FacesContext.getCurrentInstance().addMessage(null, message);
    				errores++;
        		}
        			
        			if(errores==0){

        		String[] locaciones =	getLocacion().split("-");
        		
        		this.setCiudad(locaciones[0] );
        		this.setDepar(locaciones[1]);
        			
			Proyecto proyecto = new Proyecto();
			proyecto.setNombre(getNompro());
			proyecto.setEstado("A");
			proyecto.setNomCiudad(getCiudad());
			proyecto.setNomDpto(getDepar());
			proyecto.setTipo(getTipo());
			proyecto.setPoblacion(getPoblacion());
			proyecto.setFechai(sqlDate(getFecha1()));
			proyecto.setFechaf(sqlDate(getFecha2()));
			getProyectoService().addProyecto(proyecto);
			reset();
			
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
					"Registro agregado exitosamente.");
			FacesContext.getCurrentInstance().addMessage(null, message);	

        			}
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

	}

    public void ventanaProyecto(Proyecto proyecto){
    	
    	FacesContext contex = FacesContext.getCurrentInstance();
    	
        
    	try {
			FacesMessage message = null;
			if(proyecto.getEstado().equals("I")){
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error, el proyecto esta bloqueado, no se puede editar","");
				FacesContext.getCurrentInstance().addMessage(null, message);
			}else{
				try {
					contex.getExternalContext().redirect("EditarPro.jsf");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				this.setNompro(proyecto.getNombre());
				this.setTipo(proyecto.getTipo());
				this.setPoblacion(proyecto.getPoblacion());
				this.setLocacion(proyecto.getNomCiudad()+"-"+proyecto.getNomDpto());
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
    	

        }
    
    	public void editarProyecto(Proyecto proyecto){
    	
    	FacesContext contex = FacesContext.getCurrentInstance();
    	
        
    	
			FacesMessage message = null;


    		String[] locaciones =	getLocacion().split("-");
    		
    		this.setCiudad(locaciones[0] );
    		this.setDepar(locaciones[1]);
    		
		proyecto.setNombre(getNompro());
		proyecto.setNomCiudad(getCiudad());
		proyecto.setNomDpto(getDepar());
		proyecto.setTipo(getTipo());
		proyecto.setPoblacion(getPoblacion());
		getProyectoService().updateProyecto(proyecto);
		reset();
		
		message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
				"Registro editado exitosamente.");
		FacesContext.getCurrentInstance().addMessage(null, message);	


    	
    	}

	// Aqui colocamos el de borrado


	public void reset() {
		this.setId(0);
		this.setNompro("");
		this.setCiudad("");
		this.setDepar("");
		this.setFecha1(null);
		this.setFecha2(null);
		this.setTipo("");
		this.setPoblacion("");
	}
	
	public void bloquearProyecto(Proyecto proyecto) {
		try {
			FacesMessage message = null;
			if(proyecto.getEstado().equals("I")){
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error, el proyecto ya se encuentra inactivo.","");
				FacesContext.getCurrentInstance().addMessage(null, message);
			}else{
				proyecto.setEstado("I");
			getProyectoService().updateProyecto(proyecto);
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Proyecto inactivado exitosamente.","");
			FacesContext.getCurrentInstance().addMessage(null, message);
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		

	}
    public void desbloquearProyecto(Proyecto proyecto) {
		try {
			FacesMessage message = null;
			if(proyecto.getEstado().equals("A")){
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error, el proyecto ya se encuentra Activo.","");
				FacesContext.getCurrentInstance().addMessage(null, message);
			}else{
				proyecto.setEstado("A");
			getProyectoService().updateProyecto(proyecto);
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Proyecto activado exitosamente.","");
			FacesContext.getCurrentInstance().addMessage(null, message);
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		

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

	public java.util.Date getFecha1() {
		return fecha1;
	}

	public void setFecha1(java.util.Date fecha1) {
		this.fecha1 = fecha1;
	}

	public java.util.Date getFecha2() {
		return fecha2;
	}

	public void setFecha2(java.util.Date fecha2) {
		this.fecha2 = fecha2;
	}

	public ProyectoMB getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(ProyectoMB registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}


	public String getLocacion() {
		return locacion;
	}


	public void setLocacion(String locacion) {
		this.locacion = locacion;
	}
	
}