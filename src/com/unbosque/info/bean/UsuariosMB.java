package com.unbosque.info.bean;


import java.io.IOException;
import java.io.Serializable;
import java.security.MessageDigest;
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
import com.unbosque.info.util.Mailer;

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
    private String tipoUs;
	
    
    public void addUsuario() {
		try {
			int errores = 0;

			RequestContext context = RequestContext.getCurrentInstance();
			FacesMessage message = null;
			boolean loggedIn = false;
			
			if(nomus.equals("")){
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "","Error, El nombre del Usuario no puede estar vacío ");
				FacesContext.getCurrentInstance().addMessage(null, message);
				errores++;
			}
			if(apeus.equals("")){
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "","Error, El apellido del Usuario no puede estar vacío ");
				FacesContext.getCurrentInstance().addMessage(null, message);
				errores++;
			}
			if(ideus.equals("")){
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "","Error, La identificación del Usuario no puede estar vacía ");
				FacesContext.getCurrentInstance().addMessage(null, message);
				errores++;
			}
			if(us.equals("")){
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "","Error, El Usuario no puede estar vacío ");
				FacesContext.getCurrentInstance().addMessage(null, message);
				errores++;
			}
			if(passwordus.equals("")){
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "","Error, La contraseña del Usuario no puede estar vacía ");
				FacesContext.getCurrentInstance().addMessage(null, message);
				errores++;
			}
			if(mailus.equals("")){
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "","Error, El correo del Usuario no puede estar vacío ");
				FacesContext.getCurrentInstance().addMessage(null, message);
				errores++;
			}
			if(especus.equals("")){
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "","Error, La especialidad del Usuario no puede estar vacía ");
				FacesContext.getCurrentInstance().addMessage(null, message);
				errores++;
			}
			if(telus.equals("")){
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "","Error, El teléfono del Usuario no puede estar vacío ");
				FacesContext.getCurrentInstance().addMessage(null, message);
				errores++;
			}
				
				int contadorUsuarios = 0;
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
				String a6 = mailus;
				a6.toCharArray();
				int nNum = 0, nNum1 = 0, nMay=0, nMin=0, nNum2 = 0, nMay1=0, nMin1=0 , contador = 0, nNum3=0, nMay2=0, nMin2=0, nValores= 0;
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
				
				for (int i=0;i<a6.length();i++) {
        			if ( t4.indexOf(a6.charAt(i)) != -1 ){
        				nValores++;
        				}
        		}
				
				
				if ( nNum!=0) {
					loggedIn = false;
    	            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "","El nombre del Usuario no puede contener números");
    				FacesContext.getCurrentInstance().addMessage(null, message);
    				errores++;
        		}
				if ( nNum1!=0) {
    				loggedIn = false;
        	        message = new FacesMessage(FacesMessage.SEVERITY_INFO, "","El apellido del Usuario no puede contener números");
        			FacesContext.getCurrentInstance().addMessage(null, message);
        			errores++;
            	}
				if ( nMay!=0 || nMin!=0) {
        			loggedIn = false;
            	    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "","La identificación del Usuario no puede contener letras");
            		FacesContext.getCurrentInstance().addMessage(null, message);
            		errores++;
                }
				if ( nNum2==0 || nMay1==0 || nMin1==0) {
            		loggedIn = false;
                	message = new FacesMessage(FacesMessage.SEVERITY_INFO, "","La contraseña del Usuario debe contener al menos un número, una Mayuscula y una Minuscula");
                	FacesContext.getCurrentInstance().addMessage(null, message);
                	errores++;
				}
				if ( contador>8) {
                	loggedIn = false;
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "","La contraseña del Usuario debe contener mínimo 8 caracteres");
                    FacesContext.getCurrentInstance().addMessage(null, message);
                    errores++;
                 }
                 if ( nNum3!=0) {
                    loggedIn = false;
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "","La especialidad del Usuario no puede contener números");
                    FacesContext.getCurrentInstance().addMessage(null, message);
                    errores++;
                 }if ( nMay2!=0 || nMin2!=0) {
                    loggedIn = false;
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "","El teléfono del Usuario no puede contener letras");
                    FacesContext.getCurrentInstance().addMessage(null, message);
                    errores++;
                 }
                 if ( nValores!=0) {
                     loggedIn = false;
                     message = new FacesMessage(FacesMessage.SEVERITY_INFO, "","El correo ingresado no es válido");
                     FacesContext.getCurrentInstance().addMessage(null, message);
                     errores++;
                  }

           
            for(int y = 0; y<usuarioService.getUsuarios().size(); y++){
            	 String [] k =usuarioService.getUsuarios().get(y).getLogin().split(" ");
            	if(k[0].equals(getUs())){
            		contadorUsuarios++;	
            	}
            }
            if(errores!=0){
            	
            }else if(contadorUsuarios!=0){
            	message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
    					"Nombre de Usuario no disponible");
    			FacesContext.getCurrentInstance().addMessage(null, message);
            }else{
                                			
                                			
            java.util.Date date= new java.util.Date();
            
           java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(0); 
           
        			loggedIn = true;
        			UsuariosMB umb= new UsuariosMB();
			Usuario usuario = new Usuario();
			
			usuario.setApellidosNombres(getNomus() + " " + getApeus());
			usuario.setIdentificacion(getIdeus());
			usuario.setLogin(getUs());
			usuario.setPassword(umb.encriptarMD5(getPasswordus()));
			usuario.setCorreo(getMailus()+"@gmail.com");
			usuario.setEspecialidad(getEspecus());
			usuario.setTelefono(getTelus());
			usuario.setEstado("A");
			usuario.setIntentos(0);
			usuario.setTipoUsuario(getTipoUs());
			usuario.setIdProyecto(getProyectosus());
			usuario.setFechaClave(new Timestamp(date.getTime()));
			usuario.setFechaCreacion(new Timestamp(date.getTime()));
			
			
			Mailer obj = new Mailer(); 
	        String server = "smtp.gmail.com"; 
	        String userName = "richardu862@gmail.com"; 
	        String password = "booker39"; 
	        String fromAddres = "Nicolas"; 
	        String toAddres = getMailus()+"@gmail.com"; 
	        String cc = ""; 
	        String bcc = ""; 
	        boolean htmlFormat = false; 
	        String subject = "Proyecto Caries"; 
	        String body = "Cordial Saludo!" + "\n" +
	        "Tenemos el gusto de informarle que su registro a Nuestro Sistema a sido Exitoso!" + "\n" + 
	        		"Le invitamos a que ingrese con su nombre de usuario y contraseña al enlace: " + "http://localhost:8080/ProyectoCaries/index.jsf" + "\n"+ 
	        "Usuario: " + getUs() + "\n" + "Contraseña: " + getPasswordus(); 
	         
	        obj.sendMail(server, userName, password, fromAddres, toAddres, cc, bcc, 
	                     htmlFormat, subject, body); 
	         
	    
			
			getUsuarioService().addUsuario(usuario);
			reset();
	
			
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
					"Registro agregado exitosamente.");
			FacesContext.getCurrentInstance().addMessage(null, message);
            }
                                									
        		
			

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		

	}
    
    public void ventanaUsuario(Usuario usuario){
    	
    	FacesContext contex = FacesContext.getCurrentInstance();
    	
        
    	try {
			FacesMessage message = null;
			if(usuario.getEstado().equals("I")){
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error, el usuario esta bloqueado, no se puede editar","");
				FacesContext.getCurrentInstance().addMessage(null, message);
			}else{
				try {
					contex.getExternalContext().redirect("EditarUs.jsf");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				this.setIdeus((usuario.getIdentificacion()));
				this.setNomus(usuario.getApellidosNombres());
				this.setUs(usuario.getLogin());
				String [] h = usuario.getCorreo().split("@");
				this.setMailus(h[1]);
				this.setTipoUs(usuario.getTipoUsuario());
				this.setTelus(usuario.getTelefono());
				this.setEspecus(usuario.getEspecialidad());
				this.setProyectosus(usuario.getIdProyecto());
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
    	

        }
    
    	public void editarUsuario(Usuario usuario){
    	
    	FacesContext contex = FacesContext.getCurrentInstance();
    	
        
    	
			FacesMessage message = null;


				usuario.setApellidosNombres(getNomus());
				usuario.setIdentificacion(getIdeus());
				usuario.setLogin(getUs());
				usuario.setCorreo(getMailus()+"@gmail.com");
				usuario.setEspecialidad(getEspecus());
				usuario.setTelefono(getTelus());
				usuario.setTipoUsuario(getTipoUs());
				usuario.setIdProyecto(getProyectosus());
				
				
				
				Mailer obj = new Mailer(); 
		        String server = "smtp.gmail.com"; 
		        String userName = "richardu862@gmail.com"; 
		        String password = "booker39"; 
		        String fromAddres = "Nicolas"; 
		        String toAddres = getMailus()+"@gmail.com"; 
		        String cc = ""; 
		        String bcc = ""; 
		        boolean htmlFormat = false; 
		        String subject = "Proyecto Caries"; 
		        String body = "Cordial Saludo!" + "\n" +
		        "Tenemos el gusto de informarle que su registro a Nuestro Sistema ha sido cambiado!" + "\n" + 
		        		"Le invitamos a que ingrese con el nombre de usuario y la contraseña al enlace: " + "http://localhost:8080/ProyectoCaries/index.jsf" + "\n"+ 
		        "Usuario: " + getUs() + "\n" + "Contraseña: " + getPasswordus(); 
		         
		        obj.sendMail(server, userName, password, fromAddres, toAddres, cc, bcc, 
		                     htmlFormat, subject, body); 
		         
		        getUsuarioService().updateUsuario(usuario);
				reset();
		
				
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
						"Registro editado correctamente");
				FacesContext.getCurrentInstance().addMessage(null, message);

    	
    	}
    
    public void bloquearUsuario(Usuario usuario) {
		try {
			FacesMessage message = null;
			if(usuario.getEstado().equals("I")){
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error, el usuario ya se encuentra bloqueado.","");
				FacesContext.getCurrentInstance().addMessage(null, message);
			}else{
			usuario.setEstado("I");
			getUsuarioService().updateUsuario(usuario);
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario Bloqueado exitosamente.","");
			FacesContext.getCurrentInstance().addMessage(null, message);
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		

	}
    public void desbloquearUsuario(Usuario usuario) {
		try {
			FacesMessage message = null;
			if(usuario.getEstado().equals("A")){
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error, el usuario ya se encuentra Activo.","");
				FacesContext.getCurrentInstance().addMessage(null, message);
			}else{
			usuario.setEstado("A");
			usuario.setIntentos(0);
			getUsuarioService().updateUsuario(usuario);
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario Desbloqueado exitosamente.","");
			FacesContext.getCurrentInstance().addMessage(null, message);
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		

	}
    
    public void fallido(Usuario usuario) {
		try {

			int inten = usuario.getIntentos();
    		inten++;
			usuario.setIntentos(inten);
			
			getUsuarioService().updateUsuario(usuario);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		

	}
    
    public void correcto(Usuario usuario) {
		try {


			usuario.setIntentos(0);
			
			getUsuarioService().updateUsuario(usuario);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		

	}
    
    public int compare(Timestamp t1, Timestamp t2, int valor) {

        long l1 = t1.getTime();
        long l2 = t2.getTime();
        if (l2-l1<valor)
        return 1;
        else 
        return 0;
    }
    
    public void irMenu() {

    	FacesContext contex = FacesContext.getCurrentInstance();
    	try {
			contex.getExternalContext().redirect( "MenuUs.jsf" );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void ingresar() {
        FacesContext contex = FacesContext.getCurrentInstance();
        FacesMessage msg = null;
        FacesMessage message = null;
        int contador1=0;
        String us1 = null;
        String [] us2 = null;
        java.util.Date date= new java.util.Date();
        
        for(int a = 0; a<usuarioService.getUsuarios().size(); a++){
            String conCifrada=encriptarMD5(contraseña);
            
            us1 = login;
            us2 = usuarioService.getUsuarios().get(a).getLogin().split(" ");
            
        	if(getLogin().equals(us2[0])){
        	
        	
        	if( conCifrada.equals(usuarioService.getUsuarios().get(a).getPassword()) ){
        		
        		if(usuarioService.getUsuarios().get(a).getTipoUsuario().equals("A")){
        			Timestamp fechax =usuarioService.getUsuarios().get(a).getFechaClave();
    				Timestamp fechay = new Timestamp(date.getTime());
    				System.out.println("comparo " + fechax + " con " + fechay);
        			
        			if(usuarioService.getUsuarios().get(a).getEstado().equals("I")){
        				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
            					"Usuario Bloqueado, no puede ingresar");
            			FacesContext.getCurrentInstance().addMessage(null, message);
        			}else{
        				
        				if(compare(fechax, fechay, 10)==1){
        					message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
                					"Profavor cambie su contraseña");
                			FacesContext.getCurrentInstance().addMessage(null, message);
        				}else{
        			try {
        				correcto(usuarioService.getUsuarios().get(a));
        				contex.getExternalContext().redirect( "MenuAd.jsf" );
        			} catch (IOException e) {
        				// TODO Auto-generated catch block
        				e.printStackTrace();
        			}
        			}
        			}
        		}else
        		
        		if(usuarioService.getUsuarios().get(a).getTipoUsuario().equals("U")){
        			Timestamp fechax1 =usuarioService.getUsuarios().get(a).getFechaClave();
    				Timestamp fechay1 = new Timestamp(date.getTime());
    				System.out.println("comparo " + fechax1 + " con " + fechay1);
        			if(usuarioService.getUsuarios().get(a).getEstado().equals("I")){
        				
        				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
            					"Usuario Bloqueado, no puede ingresar");
            			FacesContext.getCurrentInstance().addMessage(null, message);
        			}else{
        				if(compare(fechax1, fechay1, 10)==1){
        					correcto(usuarioService.getUsuarios().get(a));
            				try {
								contex.getExternalContext().redirect( "CambioClave.jsf" );
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
        					message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
                					"Por Motivos de seguridad le recomendamos que cambie su contraseña. Muchas Gracias :D");
                			FacesContext.getCurrentInstance().addMessage(null, message);
        				}else{
        			try {
        				correcto(usuarioService.getUsuarios().get(a));
        				contex.getExternalContext().redirect( "MenuUs.jsf" );
        			} catch (IOException e) {
        				// TODO Auto-generated catch block
        				e.printStackTrace();
        			}
        			}
        			}
        		}
        		else{
        			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
        					"Error Login al buscar el tipo de usuario");
        			FacesContext.getCurrentInstance().addMessage(null, message);

        		}
        	}else{
        		contador1++;
        		
        		//int inten = usuarioService.getUsuarios().get(a).getIntentos();
        		//inten++;
        		//usuarioService.getUsuarios().get(a).setIntentos(inten);
        		
        		//getUsuarioService().updateUsuario(usuarioService.getUsuarios().get(a));
        		if(usuarioService.getUsuarios().get(a).getTipoUsuario().equals("A")){
        			correcto(usuarioService.getUsuarios().get(a));
        		}
        		fallido(usuarioService.getUsuarios().get(a));
        		
        		if(usuarioService.getUsuarios().get(a).getIntentos()==3){
        			bloquearUsuario(usuarioService.getUsuarios().get(a));
        			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
        					"Debido a 3 Intentos fallidos al entrar al sistema, su cuenta ha sido bloqueada. Porfavor contacte al administrador");
        			FacesContext.getCurrentInstance().addMessage(null, message);
        			
        		}
        	}
        	}else{
        		contador1++;
        		
        	}
		}   	
        
        
        if(contador1>0){
        	message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
					"Usuario y/o Contraseña erroneos");
			FacesContext.getCurrentInstance().addMessage(null, message);
        }
    } 
    
    private String hash(String clear) throws Exception { 
    	MessageDigest md = MessageDigest.getInstance("MD5"); 
    	byte[] b = md.digest(clear.getBytes()); 
    	int size = b.length; 
    	StringBuffer h = new StringBuffer(size); 
    	for (int i = 0; i < size; i++) { 
    		int u = b [ i ] & 255 ; 
    	if (u<16){ 
    	h.append("0"+Integer.toHexString(u)); 
    	}else { 
    	h.append(Integer.toHexString(u)); 
    	} 
    	} 
    	return h.toString(); 
    	}
    
    public String encriptarMD5(String palabra){ 
    	String pe=""; 
    	try { 
    	pe = hash(palabra); 
    	} 
    	catch (Exception e) { 
    	throw new Error("Error: Al encriptar el password"); 
    	} 
    	return pe; 
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

	public String getTipoUs() {
		return tipoUs;
	}

	public void setTipoUs(String tipoUs) {
		this.tipoUs = tipoUs;
	}
	
}