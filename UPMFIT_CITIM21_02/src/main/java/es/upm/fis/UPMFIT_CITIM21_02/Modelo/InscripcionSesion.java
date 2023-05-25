package es.upm.fis.UPMFIT_CITIM21_02.Modelo;

import java.util.Date;
import java.util.List;

import es.upm.fis.UPMFIT_CITIM21_02.Modelo.Cliente;

/**
 * @author The Administrator
 * @version 1.0
 * @created 05-may.-2023 13:59:50
 */
public class InscripcionSesion {

	private Date fecha;
	public Cliente m_Cliente;
	private List<Sesion> sesiones;

	public InscripcionSesion(){

	}

	public void finalize() throws Throwable {

	}
	public void destroy(){

	}

	public Date getFecha(){
		return null;
	}

	/**
	 * 
	 * @param f
	 */
	public void setFecha(Date f){

	}
	
	public List<Sesion> getSesiones() {
		return this.sesiones;
	}
}//end INSCRIPCI�N_SESION