package com.unbosque.info.bean;


import java.io.IOException;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.unbosque.info.entidad.Usuario;
import com.unbosque.info.service.UsuarioService;

import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.springframework.dao.DataAccessException;
 
@ManagedBean (name = "usuariosMB")
@SessionScoped
public class UsuariosMB implements Serializable {
	
private static final long serialVersionUID = 5678093963468460743L;
	
	//Spring Customer Service is injected...
	@ManagedProperty(value = "#{UsuarioService}")
	UsuarioService usuarioService;

	private UsuariosMB registroSeleccionado;
   
	List<Usuario> usuarioList;
	
	private int id;
	private String nomus;
    private String apeus;
    private String ideus;
    private String us;
    private String passwordus;
    private String mailus;
    private String especus;
    private String telus;
    private int proyectosus;
    private Timestamp fecha1;
    private Timestamp fecha2;
    private String login;
    private String contraseña;
	
    
    public void addUsuario() {
		try {

			RequestContext context = RequestContext.getCurrentInstance();
			FacesMessage message = null;
			boolean loggedIn = false;
			
			if(nomus.equals("")){
				
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
						"Error, El nombre del Usuario no puede estar vacío ");
				FacesContext.getCurrentInstance().addMessage(null, message);
			}else{
				
				if(apeus.equals("")){
					
					message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
							"Error, El apellido del Usuario no puede estar vacío ");
					FacesContext.getCurrentInstance().addMessage(null, message);
				}else{
					
					if(ideus.equals("")){
						
						message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
								"Error, La identificación del Usuario no puede estar vacía ");
						FacesContext.getCurrentInstance().addMessage(null, message);
					}else{
						
						if(us.equals("")){
							
							message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
									"Error, El nombre del login del Usuario no puede estar vacío ");
							FacesContext.getCurrentInstance().addMessage(null, message);
						}else{
							
							if(passwordus.equals("")){
								
								message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
										"Error, La contraseña del Usuario no puede estar vacía ");
								FacesContext.getCurrentInstance().addMessage(null, message);
							}else{

								if(mailus.equals("")){
									
									message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
											"Error, El correo del Usuario no puede estar vacío ");
									FacesContext.getCurrentInstance().addMessage(null, message);
								}else{
									
									if(especus.equals("")){
										
										message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
												"Error, La especialidad del Usuario no puede estar vacía ");
										FacesContext.getCurrentInstance().addMessage(null, message);
									}else{
										
										if(telus.equals("")){
											
											message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
													"Error, El teléfono del Usuario no puede estar vacío ");
											FacesContext.getCurrentInstance().addMessage(null, message);
										}else{
				
				String a = nomus;
				a.toCharArray();
				String a1 = apeus;
				a1.toCharArray();
				String a2 = ideus;
				a2.toCharArray();
				String a3 = passwordus;
				a3.toCharArray();
				String a4 = especus;
				a4.toCharArray();
				String a5 = telus;
				a5.toCharArray();
				int nNum = 0, nNum1 = 0, nMay=0, nMin=0, nNum2 = 0, nMay1=0, nMin1=0 , contador = 0, nNum3=0, nMay2=0, nMin2=0;
				String t3 = "0123456789";
				String t1 = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
	        	String t2 = "abcdefghijklmnñopqrstuvwxyz";
				
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
					contador++;
        			if ( t1.indexOf(a3.charAt(i)) != -1 ){
        				nMay1++;
        				}
        			if ( t2.indexOf(a3.charAt(i)) != -1 ){
        				nMin1++;
        				}
        			if ( t3.indexOf(a3.charAt(i)) != -1 ){
        				nNum2++;
        				}
        		}
				for (int i=0;i<a4.length();i++) {
        			if ( t3.indexOf(a4.charAt(i)) != -1 ){
        				nNum3++;
        				}
        		}
				
				for (int i=0;i<a5.length();i++) {
        			if ( t1.indexOf(a5.charAt(i)) != -1 ){
        				nMay2++;
        				}
        			if ( t2.indexOf(a5.charAt(i)) != -1 ){
        				nMin2++;
        				}
        		}
				
				
				if ( nNum!=0) {
					loggedIn = false;
    	            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "","El nombre del Usuario no puede contener números");
    				FacesContext.getCurrentInstance().addMessage(null, message);
        		}else{
        			
        			if ( nNum1!=0) {
    					loggedIn = false;
        	            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "","El apellido del Usuario no puede contener números");
        				FacesContext.getCurrentInstance().addMessage(null, message);
            		}else{
            			
            			if ( nMay!=0 && nMin!=0) {
        					loggedIn = false;
            	            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "","La identificación del Usuario no puede contener letras");
            				FacesContext.getCurrentInstance().addMessage(null, message);
                		}else{
                			
                			if ( nNum2==0 && nMay1==0 && nMin1==0) {
            					loggedIn = false;
                	            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "","La contraseña del Usuario debe contener al menos un número, una Mayuscula y una Minuscula");
                				FacesContext.getCurrentInstance().addMessage(null, message);
                    		}else{
                    			
                    			if ( contador>8) {
                					loggedIn = false;
                    	            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "","La contraseña del Usuario debe contener mínimo 8 caracteres");
                    				FacesContext.getCurrentInstance().addMessage(null, message);
                        		}else{
                        			if ( nNum3!=0) {
                    					loggedIn = false;
                        	            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "","La especialidad del Usuario no puede contener números");
                        				FacesContext.getCurrentInstance().addMessage(null, message);
                            		}else{
                            			if ( nMay2!=0 && nMin2!=0) {
                        					loggedIn = false;
                            	            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "","El teléfono del Usuario no puede contener letras");
                            				FacesContext.getCurrentInstance().addMessage(null, message);
                                		}else{

            
           java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(6); 
           
        			loggedIn = true;
			Usuario usuario = new Usuario();
			
			usuario.setApellidosNombres(getNomus() + " " + getApeus());
			usuario.setIdentificacion(getIdeus());
			usuario.setLogin(getUs());
			usuario.setPassword(getPasswordus());
			usuario.setCorreo(getMailus());
			usuario.setEspecialidad(getEspecus());
			usuario.setTelefono(getTelus());
			usuario.setEstado("A");
			usuario.setTipoUsuario("U");
			usuario.setIdProyecto(getProyectosus());
			usuario.setFechaClave(sqlTimestamp);
			usuario.setFechaCreacion(sqlTimestamp);
			getUsuarioService().addUsuario(usuario);
			reset();
	
			
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
					"Registro agregado exitosamente.");
			FacesContext.getCurrentInstance().addMessage(null, message);
                                									}
                            									}
                            								}
                        								}
                        							}
                        						}
                    						}
                						}
                					}
                				}
            				}
            			}
        			}
        		}
			}

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		

	}
    
    public void updateUsuario(RowEditEvent event){

        }
    
    public void borrarUsuario(Usuario usuario) {
		try {
			FacesMessage message = null;
			
			
			getUsuarioService().deleteUsuario(usuario);
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario Borrado exitosamente.","");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}


	}
    
    public void ingresar() {
        FacesContext contex = FacesContext.getCurrentInstance();
        
        FacesMessage message = null;
        

        
        for(int a = 0; a<usuarioService.getUsuarios().size(); a++){
        	System.out.println(login);
        	System.out.println(usuarioService.getUsuarios().get(a).getLogin());
        	if(login.equals(usuarioService.getUsuarios().get(a).getLogin()))
        			System.out.println("si1");
        	if( getContraseña().equals(usuarioService.getUsuarios().get(a).getPassword())){
        		if(usuarioService.getUsuarios().get(a).getTipoUsuario().equals("A")){
        			try {
        				contex.getExternalContext().redirect( "MenuAd.jsf" );
        			} catch (IOException e) {
        				// TODO Auto-generated catch block
        				e.printStackTrace();
        			}
        		}else
        		
        		if(usuarioService.getUsuarios().get(a).getTipoUsuario().equals("U")){
        			try {
        				contex.getExternalContext().redirect( "MenuUs.jsf" );
        			} catch (IOException e) {
        				// TODO Auto-generated catch block
        				e.printStackTrace();
        			}
        		}
        		else{
        			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
        					"Error Login");
        			FacesContext.getCurrentInstance().addMessage(null, message);

        		}
        	}else{
        		message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
    					"Nombre de Usuario y/o contraseña erroneos");
    			FacesContext.getCurrentInstance().addMessage(null, message);

		}
        }
    } 
    
    public void reset() {
    	
    	this.setId(0);
    	this.setIdeus(null);
    	this.setNomus(null);
    	this.setApeus(null);
    	this.setUs(null);
    	this.setPasswordus(null);
    	this.setMailus(null);
    	this.setEspecus(null);
    	this.setTelus(null);
	}

	public List<Usuario> getUsuariosList() {
		usuarioList = new ArrayList<Usuario>();
		usuarioList.addAll(getUsuarioService().getUsuarios());
		return usuarioList;
	}
	
	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public List<Usuario> getUsuarioList() {
		return usuarioList;
	}

	public void setUsuarioList(List<Usuario> usuarioList) {
		this.usuarioList = usuarioList;
	}

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

	public int getProyectosus() {
		return proyectosus;
	}

	public void setProyectosus(int proyectosus) {
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

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}




	public Timestamp getFecha1() {
		return fecha1;
	}



	public void setFecha1(Timestamp fecha1) {
		this.fecha1 = fecha1;
	}



	public Timestamp getFecha2() {
		return fecha2;
	}



	public void setFecha2(Timestamp fecha2) {
		this.fecha2 = fecha2;
	}



	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
}