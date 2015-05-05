package com.unbosque.info.bean;


import java.io.IOException;
import java.io.Serializable;
import com.unbosque.info.entidad.Usuario;
import com.unbosque.info.service.UsuarioService;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
 

import org.primefaces.context.RequestContext;


 
@ManagedBean (name = "loginMB")
@SessionScoped
public class LoginMB implements Serializable {
	
	private static final long serialVersionUID = -7809396168460749463L;
	
	private LoginMB registroSeleccionado;

	@ManagedProperty(value = "#{UsuarioService}")
	UsuarioService usuarioService; 
	
    private String username;
     
    private String password;
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    
	public LoginMB getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(LoginMB registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}
   
    public void ingresar() {
        FacesContext contex = FacesContext.getCurrentInstance();
        
        FacesMessage message = null;
        
        usuarioService.getUsuarios();
        
        for(int a = 0; a<usuarioService.getUsuarios().size(); a++){
        	if(username != null && username.equals(usuarioService.getUsuarios().get(a).getLogin()) &&  password != null && password.equals(usuarioService.getUsuarios().get(a).getPassword())){
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
        				message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");

        		}
        	}else{
				message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");

		}
        }
         
        if(username != null && username.equals("admin") && password != null && password.equals("admin")) {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);
            try {
				contex.getExternalContext().redirect( "MenuAd.jsf" );
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
        } else {
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
        }
        
        if(username != null && username.equals("usuario") && password != null && password.equals("usuario")) {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome user", username);
            try {
				contex.getExternalContext().redirect( "MenuUs.jsf" );
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
        } else {
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
        }
         
        FacesContext.getCurrentInstance().addMessage(null, message);
        //context.addCallbackParam("loggedIn", loggedIn);
    }   
}