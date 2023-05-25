package es.upm.fis.UPMFIT_CITIM21_02.Modelo;

/**
 * @author The Administrator
 * @version 1.0
 * @created 05-may.-2023 13:59:51
 */
abstract class NoAdmin extends Usuario {

	private String dni;

	/**CONSTRUCTORES**/
	public NoAdmin(String dni, String apellidos, String contrasena, String correo, String nombre, String nombreUsuario){
		super(contrasena, correo, nombre, nombreUsuario, apellidos);
		this.dni = dni; 
	}
	
	public NoAdmin(String dni){
		this.dni=dni;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	
	public String validarEmail(){
		return "";
	}

	
	public String getDni() {
		return this.dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
/*
	@Override
	public String getContrasena() {
		// TODO Auto-generated method stub
		return null;
	}*/
}//end NoAdmin