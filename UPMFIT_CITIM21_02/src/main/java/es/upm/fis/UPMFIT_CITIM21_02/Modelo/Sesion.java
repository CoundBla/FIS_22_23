package es.upm.fis.UPMFIT_CITIM21_02.Modelo;

import java.util.Date;

import es.upm.fis.UPMFIT_CITIM21_02.Enumerados.TActividad;
import es.upm.fis.UPMFIT_CITIM21_02.Interfaces.ISesion;
import es.upm.fis.UPMFIT_CITIM21_02.Modelo.Monitor;
/**
 * @author The Administrator
 * @version 1.0
 * @created 05-may.-2023 13:59:53
 */
public class Sesion implements ISesion {

	private TActividad actividad;
	private Date fechaInicio;
	private Date fechaFin;
	private String id;
	private int numeroPersonas;
	private Monitor m_Monitor;
	
	public Sesion(){
		this.actividad = TActividad.obtenerValorAleatorio();
		this.fechaInicio = new Date();
		this.fechaFin = new Date();
		this.id = "REVISAR LA GENERACION ALEATORIA DE ID, y como debe ser formado";
		this.numeroPersonas = 10;//Revisar generación de máximo personas. Ver reglas en el enunciado.
	}


	public void finalize() throws Throwable {

	}
	public void destroy(){

	}
	
	/**GETTERS AND SETTERS**/

	public TActividad getActividad(){
		return actividad;
	}

	public Date getFechaFin(){
		return fechaFin;
	}

	public Date getFechaInicio(){
		return  fechaInicio;
	}

	public String getId(){
		return "";
	}

	public int getNumeroPersonas(){
		return numeroPersonas;
	}

	/**
	 * 
	 * @param actividadIn
	 * @param fechaFinIn
	 * @param fechaInicioIn
	 * @param idIn
	 * @param numeroPersonasIn
	 */
	

	/**
	 * 
	 * @param actividad
	 */
	public void setActividad(TActividad actividad){
		this.actividad=actividad;
	}

	/**
	 * 
	 * @param fecha
	 */
	public void setFechaFin(Date fecha){
		this.fechaFin=fecha;
	}

	/**
	 * 
	 * @param fecha
	 */
	public void setFechaInicio(Date fecha){
		this.fechaInicio=fecha;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(String id){
		this.id=id;
	}

	/**
	 * 
	 * @param num
	 */
	public void setNumeroPersonas(int num){
		this.numeroPersonas=num;
	}


	@Override
	public void setMonitor(Monitor m) {
		this.m_Monitor = m;		
	}

}//end SESION