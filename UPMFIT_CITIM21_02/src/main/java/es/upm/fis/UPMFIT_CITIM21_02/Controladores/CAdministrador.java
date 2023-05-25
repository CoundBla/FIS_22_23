package es.upm.fis.UPMFIT_CITIM21_02.Controladores;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import es.upm.fis.UPMFIT_CITIM21_02.Modelo.Administrador;

/**
 * @author The Administrator
 * @version 1.0
 * @created 05-may.-2023 13:59:45
 */
public class CAdministrador {

	private static CAdministrador instancia = new CAdministrador();
	private List<Administrador> administradores;

	private CAdministrador(){
		administradores = new ArrayList<Administrador>();
	}

	public static CAdministrador getInstance() {
		return instancia;
	}
	
	public List<Administrador> getAdmins(){
		return administradores;
	}
	
	/**
	 * 
	 * @param s,s
	 */
	public void crearAdministrador(String contrasena, String correo, String nombre, String nombreUsuario, 
			String apellidos, String telefono){

	}

	public void finalize(){
		administradores = null;
		instancia = null;
	}
}//end CAdministrador