package es.upm.fis.UPMFIT_CITIM21_02.Modelo;



/**
 * @author The Administrator
 * @version 1.0
 * @created 05-may.-2023 13:59:51
 */
public class Monitor extends NoAdmin {

	private String cuentaBancaria;


	/**CONSTRUCTORES**/


	public Monitor(String contrasena, String correo, String nombre, String nombreUsuario, 
			String apellidos,String cuentaBancaria, String dni) {
		super(contrasena,correo,nombre,nombreUsuario,apellidos,dni);
		this.cuentaBancaria = cuentaBancaria;		
	}

	public void darseDeBaja(){

	}

	public String validarEmail(){
		return "";
	}
	
	
	/**GETTERS AND SETTERS**/
	
	public String getCuentaBancaria() {
		return this.cuentaBancaria;
	}

	public void setCuentaBancaria(String cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}


	public void finalize() throws Throwable {
		super.finalize();
	}
	
}//end MONITOR