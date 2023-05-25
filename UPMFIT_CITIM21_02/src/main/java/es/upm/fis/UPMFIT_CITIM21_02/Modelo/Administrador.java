package es.upm.fis.UPMFIT_CITIM21_02.Modelo;

import java.util.HashMap;


/**
 * @author The Administrator
 * @version 1.0
 * @created 05-may.-2023 13:59:44
 */
public class Administrador extends Usuario {

	/*porq da error?*/
	
	private String telefono;

	public Administrador(){

	}
	
	public  Administrador(String telefono){
		this.telefono=telefono;
	}
	
	/**Constructor de administrador pasandole todos los datos necesarios.*/
	public Administrador(String contrasena, String correo, String nombre, String nombreUsuario, 
			String apellidos, String telefono) {
		super(contrasena,correo,nombre,nombreUsuario,apellidos);
		this.telefono = telefono;
	}
	
	public void finalize() throws Throwable {
		super.finalize();
	}
	
	
	
	/**FUNCION DE LA CLASE ABSTRACTA**/
	
	
	
	
	

	/**GETTERS AND SETTERS**/
	
	public String getTelefono(){
		return this.telefono;
	}
	/**Esta función se encarga de validar el telefono de un admin.*/
	public Boolean valTelefono() {
		String telefono = this.telefono;
	    if (!telefono.startsWith("+")) {
	        telefono = "+34" + telefono;
	    }
	    return telefono.matches("\\+\\d{1,3}\\d{9}"); 
	}
	
	public HashMap<String, String> valAdmin(Administrador admin) {
	    HashMap<String, String> resultado = new HashMap<>();
	    StringBuilder errores = new StringBuilder();
	    
	    resultado = valUsuario(admin);
	    
	    if(!admin.valTelefono()) {
	    	errores.append(resultado.get("error")) ;
	    	errores.append("El teléfono es incorrecto");
	    	if(resultado.get("result").equals("OK")) {
	    		resultado.put("result","KO");
	    	}
	    	resultado.put("error", errores.toString());
	    }	    
	    return resultado;
	}

	/**
	 * 
	 * @param tlf
	 */
	public void setTelefono(String telefono){
		this.telefono=telefono;
	}


	
	

	

	


}//end ADMINISTRADOR