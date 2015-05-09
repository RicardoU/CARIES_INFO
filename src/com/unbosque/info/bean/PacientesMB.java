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
 












import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.springframework.dao.DataAccessException;

import com.unbosque.info.entidad.Paciente;
import com.unbosque.info.entidad.Proyecto;
import com.unbosque.info.entidad.Usuario;
import com.unbosque.info.service.PacienteService;
import com.unbosque.info.service.ProyectoService;
 
@ManagedBean (name = "pacientesMB")
@SessionScoped
public class PacientesMB implements Serializable {
	
private static final long serialVersionUID = 2563448963468460743L;
	
	private PacientesMB registroSeleccionado;
   
	// Spring Customer Service is injected...
			@ManagedProperty(value = "#{PacienteService}")
			PacienteService pacienteService;
	
	private int id;
	private String nompa;
    private String apepa;
    private String idepa;
    private String edadpa;
    private String generopa;
    private String ciudadpa;
    private String csaludpa;
    private String denticionpa;
    private int proyectospa;
    private String telpa;
    private String correopa;
    
    List<Paciente> pacienteList;

    public void addPaciente() {
		try {

			int errores= 0;
			
			RequestContext context = RequestContext.getCurrentInstance();
			FacesMessage message = null;
			
			boolean loggedIn = false;

			if(nompa.equals("")){
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "","Error, El Nombre del Paciente no puede estar vacío ");
				FacesContext.getCurrentInstance().addMessage(null, message);
				errores++;
			}
			if(apepa.equals("")){
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "","Error, El Apellido del Paciente no puede estar vacío ");
				FacesContext.getCurrentInstance().addMessage(null, message);
				errores++;
			}
			if(idepa.equals("")){
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "","Error, La Identificación del Paciente no puede estar vacía ");
				FacesContext.getCurrentInstance().addMessage(null, message);
				errores++;
			}
			if(edadpa.equals("")){
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "","Error, La edad del Paciente no puede estar vacía ");
				FacesContext.getCurrentInstance().addMessage(null, message);
				errores++;
			}
			if(correopa.equals("")){
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "","Error, El Correo del Paciente no puede estar vacío ");
				FacesContext.getCurrentInstance().addMessage(null, message);
				errores++;
			}
			if(telpa.equals("")){
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "","Error, El Teléfono del Paciente no puede estar vacío ");
				FacesContext.getCurrentInstance().addMessage(null, message);
				errores++;
			}
			if(csaludpa.equals("")){
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "","Error, El Centro de Atención no puede estar vacío ");
				FacesContext.getCurrentInstance().addMessage(null, message);
				errores++;
			}
			
				String a = nompa;
				a.toCharArray();
				String a1 = apepa;
				a1.toCharArray();
				String a2 = idepa;
				a2.toCharArray();
				String a3 = edadpa;
				a3.toCharArray();
				String a4 = telpa;
				a4.toCharArray();
				String a5 = correopa;
				a5.toCharArray();
				int nNum = 0, nNum1 = 0, nMay= 0, nMin=0, nMay1=0, nMin1=0, nMay2=0, nMin2=0,nEdad= 0, nValores = 0;
				String t3 = "0123456789";
				String t1 = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
	        	String t2 = "abcdefghijklmnñopqrstuvwxyz";
	        	String t4 = "@.";
				
				for (int i=0;i<a.length();i++) {
        			if ( t3.indexOf(a.charAt(i)) != -1 ){
        				nNum++;
        				}
        		}
				for (int i=0;i<a1.length();i++) {
        			if ( t3.indexOf(a1.charAt(i)) != -1 ){
        				nNum1++;
        				}
        		}
				for (int i=0;i<a2.length();i++) {
        			if ( t1.indexOf(a2.charAt(i)) != -1 ){
        				nMay++;
        				}
        			if ( t2.indexOf(a2.charAt(i)) != -1 ){
        				nMin++;
        				}
        		}
				for (int i=0;i<a3.length();i++) {
					nEdad++;
        			if ( t1.indexOf(a3.charAt(i)) != -1 ){
        				nMay1++;
        				}
        			if ( t2.indexOf(a3.charAt(i)) != -1 ){
        				nMin1++;
        				}
        		}
				for (int i=0;i<a4.length();i++) {
        			if ( t1.indexOf(a4.charAt(i)) != -1 ){
        				nMay2++;
        				}
        			if ( t2.indexOf(a4.charAt(i)) != -1 ){
        				nMin2++;
        				}
        		}
				for (int i=0;i<a5.length();i++) {
        			if ( t4.indexOf(a5.charAt(i)) != -1 ){
        				nValores++;
        				}
        		}
				
				
				if ( nNum!=0) {
					loggedIn = false;
    	            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "","El nombre del Paciente no puede contener números");
    				FacesContext.getCurrentInstance().addMessage(null, message);
    				errores++;
        		}
				if ( nNum1!=0) {
					loggedIn = false;
    	            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "","El apellido del Paciente no puede contener números");
    				FacesContext.getCurrentInstance().addMessage(null, message);
    				errores++;
        		}
				if ( nMay!=0 || nMin!=0) {
        			loggedIn = false;
            	    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "","La identificación del Paciente no puede contener letras");
            		FacesContext.getCurrentInstance().addMessage(null, message);
            		errores++;
                }
				if ( nEdad>2) {
        			loggedIn = false;
            	    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "","La Edad del Paciente no puede ser mayor de 2 digitos");
            		FacesContext.getCurrentInstance().addMessage(null, message);
            		errores++;
                }
				if ( nMay1!=0 || nMin1!=0) {
        			loggedIn = false;
            	    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "","La Edad del Paciente no puede contener letras");
            		FacesContext.getCurrentInstance().addMessage(null, message);
            		errores++;
                }
				if ( nMay2!=0 || nMin2!=0) {
        			loggedIn = false;
            	    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "","El Teléfono del Paciente no puede contener letras");
            		FacesContext.getCurrentInstance().addMessage(null, message);
            		errores++;
                }
				if ( nValores!=0) {
					loggedIn = false;
    	            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "","El correo ingresado no es válido");
    				FacesContext.getCurrentInstance().addMessage(null, message);
    				errores++;
        		}
				
				
				if(errores==0){

        	Paciente paciente = new Paciente();
        	paciente.setNombresApellidos(getNompa() + " " + getApepa());
        	paciente.setEdad(getEdadpa());
        	paciente.setEstado("A");
        	paciente.setCiudad(getCiudadpa());
        	paciente.setCorreo(getCorreopa()+"@gmail.com");
        	paciente.setDenticion(getDenticionpa());
        	paciente.setGenero(getGeneropa());
        	paciente.setIdentificacion(getIdepa());
        	paciente.setIdProyecto(getProyectospa());
        	paciente.setLugarAtencion(getCsaludpa());
        	paciente.setTelefono(getTelpa());
			getPacienteService().addPaciente(paciente);
			reset();
			
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
					"Registro agregado exitosamente.");
			FacesContext.getCurrentInstance().addMessage(null, message);	

				
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

	}

    public void ventanaPaciente(Paciente paciente){
    	
    	FacesContext contex = FacesContext.getCurrentInstance();
    	
        
    	try {
			FacesMessage message = null;
			if(paciente.getEstado().equals("I")){
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error, el paciente esta bloqueado, no se puede editar","");
				FacesContext.getCurrentInstance().addMessage(null, message);
			}else{
				try {
					contex.getExternalContext().redirect("EditarPa.jsf");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				String [] nom = paciente.getNombresApellidos().split(" ");
				
				this.setNompa(nom[0]);
				this.setApepa(nom[1]);
				this.setIdepa(paciente.getIdentificacion());
				this.setEdadpa(paciente.getEdad());
				this.setGeneropa(paciente.getGenero());	
				String [] h = paciente.getCorreo().split("@");			
				this.setCorreopa(h[1]);
				this.setTelpa(paciente.getTelefono());
				this.setCiudadpa(paciente.getCiudad());
				this.setCsaludpa(paciente.getLugarAtencion());
				this.setDenticionpa(paciente.getDenticion());
				this.setProyectospa(paciente.getIdProyecto());
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
    	

        }
    
    	public void editarPaciente(Paciente paciente){
    	
    	FacesContext contex = FacesContext.getCurrentInstance();
    	
        
    	
			FacesMessage message = null;

			paciente.setNombresApellidos(getNompa() + " " + getApepa());
        	paciente.setEdad(getEdadpa());
        	paciente.setCiudad(getCiudadpa());
        	paciente.setCorreo(getCorreopa()+"@gmail.com");
        	paciente.setDenticion(getDenticionpa());
        	paciente.setGenero(getGeneropa());
        	paciente.setIdentificacion(getIdepa());
        	paciente.setIdProyecto(getProyectospa());
        	paciente.setLugarAtencion(getCsaludpa());
        	paciente.setTelefono(getTelpa());
			getPacienteService().updatePaciente(paciente);
			reset();
			
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
					"Registro editado exitosamente.");
			FacesContext.getCurrentInstance().addMessage(null, message);


    	
    	}

    public void bloquearPaciente(Paciente paciente) {
		try {
			FacesMessage message = null;
			if(paciente.getEstado().equals("I")){
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error, el paciente ya se encuentra bloqueado.","");
				FacesContext.getCurrentInstance().addMessage(null, message);
			}else{
				paciente.setEstado("I");
			getPacienteService().updatePaciente(paciente);
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Paciente Bloqueado exitosamente.","");
			FacesContext.getCurrentInstance().addMessage(null, message);
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		

	}
    public void desbloquearPaciente(Paciente paciente) {
		try {
			FacesMessage message = null;
			if(paciente.getEstado().equals("A")){
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error, el paciente ya se encuentra Activo.","");
				FacesContext.getCurrentInstance().addMessage(null, message);
			}else{
				paciente.setEstado("A");
			getPacienteService().updatePaciente(paciente);
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Paciente Desbloqueado exitosamente.","");
			FacesContext.getCurrentInstance().addMessage(null, message);
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		

	}
    
    public void reset() {
    	this.setNompa("");
    	this.setApepa("");
		this.setId(0);
		this.setGeneropa("");
		this.setCiudadpa("");
		this.setCsaludpa("");
		this.setDenticionpa("");
		this.setTelpa("");
		this.setCorreopa("");
	}

	public List<Paciente> getPacientesList() {
		pacienteList = new ArrayList<Paciente>();
		pacienteList.addAll(getPacienteService().getPacientes());
		return pacienteList;
	}

	public PacienteService getPacienteService() {
		return pacienteService;
	}

	public void setPacienteService(PacienteService pacienteService) {
		this.pacienteService = pacienteService;
	}

	public List<Paciente> getPacienteList() {
		return pacienteList;
	}

	public void setPacienteList(List<Paciente> pacienteList) {
		this.pacienteList = pacienteList;
	}
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getTelpa() {
		return telpa;
	}

	public void setTelpa(String telpa) {
		this.telpa = telpa;
	}

	public String getCorreopa() {
		return correopa;
	}

	public void setCorreopa(String correopa) {
		this.correopa = correopa;
	}

	public int getProyectospa() {
		return proyectospa;
	}

	public void setProyectospa(int proyectospa) {
		this.proyectospa = proyectospa;
	}

	public PacientesMB getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(PacientesMB registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}

	
}