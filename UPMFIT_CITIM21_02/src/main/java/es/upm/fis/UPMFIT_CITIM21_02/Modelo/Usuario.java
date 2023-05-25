package es.upm.fis.UPMFIT_CITIM21_02.Modelo;

import java.util.HashMap;

import es.upm.fis.UPMFIT_CITIM21_02.Enumerados.TListaNegra;
import es.upm.fis.UPMFIT_CITIM21_02.Interfaces.IUsuario;

/**
 * @author The Administrator
 * @version 1.0
 * @created 08-may.-2023 23:18:04
 */
abstract class Usuario implements IUsuario {

	protected String apellidos;
	protected String contrasena;
	protected String correo;
	protected String nombre;
	protected String nombreUsuario;

	public Usuario(){

	}
	
	public  Usuario(String contrasena, String correo, String nombre, String nombreUsuario, String apellidos){
		this.apellidos = apellidos;
		this.contrasena = contrasena;
		this.correo=correo;
		this.nombre=nombre;
		this.nombreUsuario=nombreUsuario;
	}

	public void finalize() throws Throwable {

	}
	
	

	public void destroy(){

	}

	public  String getApellidos(){
		return this.apellidos;
	}

	

	public String getCorreo(){
		return this.correo;
	}

	public String getNombre(){
		return this.nombre;
	}

	public String getNombreUsuario(){
		return this.nombreUsuario;
	}

	
	/**
	 * 
	 * @param apellidos
	 */
	public void setApellidos(String apellidos){
		this.apellidos=apellidos;
	}

	/**
	 * 
	 * @param contrae�a
	 */
	public void setContrasena(String contrasena){
		this.contrasena=contrasena;
	}

	/**
	 * 
	 * @param correo
	 */
	public void setCorreo(String correo){
		this.correo=correo;
	}

	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre){
		this.nombre=nombre;
	}

	/**
	 * 
	 * @param nickName
	 */
	public void setNombreUsuario(String nombreUsuario){
		this.nombreUsuario=nombreUsuario;
	}

	/**
	 * 
	 * @param contrsena
	 * @param correo
	 * @param nombre
	 * @param nombreUsuario
	 */
		
	public String getContrasena() {
		// TODO Auto-generated method stub
		return contrasena;
	}
	
	public HashMap<String, String> valUsuario(Usuario usuario) {
	    HashMap<String, String> resultado = new HashMap<>();
	    StringBuilder errores = new StringBuilder();
	    
	    // Comprobar que no haya campos vacíos
	    if (usuario.contrasena.isBlank() || usuario.correo.isBlank() || usuario.nombre.isBlank() || usuario.nombreUsuario.isBlank() || usuario.apellidos.isBlank()) {
	        errores.append("Hay campos vacíos.\n");
	    }
	    
	    // Comprobar que el nombre de usuario tenga entre 3 y 10 caracteres alfanuméricos
	    if (!usuario.nombreUsuario.matches("^[a-zA-Z0-9]{3,10}$")) {
	        errores.append("El nombre de usuario debe tener entre 3 y 10 caracteres alfanuméricos.\n");
	    }
	    
	    // Comprobar que el nombre de usuario no esté en la lista negra
	    if (TListaNegra.contiene(usuario.nombreUsuario)) {
	        errores.append("El nombre de usuario está en la lista negra.\n");
	    }
	    
	    // Comprobar que la contraseña tenga entre 8 y 12 caracteres y cumpla los requisitos de complejidad
	    if (!usuario.contrasena.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,12}$")) {
	        errores.append("La contraseña debe tener entre 8 y 12 caracteres y contener al menos una mayúscula, una minúscula, un número y un símbolo (@#$%^&+=).\n");
	    }
	    
	    // Comprobar que el correo electrónico tenga un formato adecuado
	    if (!usuario.correo.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
	        errores.append("El correo electrónico no tiene un formato adecuado.\n");
	    }
	    
	    // Comprobar si hay errores
	    if (errores.length() > 0) {
	        resultado.put("result", "KO");
	        resultado.put("error", errores.toString());
	    } else {
	        resultado.put("result", "OK");
	    }
	    
	    return resultado;
	}
}//end USUARIO