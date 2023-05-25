package es.upm.fis.UPMFIT_CITIM21_02.Interfaces;

import java.util.Date;

import es.upm.fis.UPMFIT_CITIM21_02.Enumerados.*;
import es.upm.fis.UPMFIT_CITIM21_02.Modelo.Monitor;

/**
 * @author The Administrator
 * @version 1.0
 * @created 18-may.-2023 19:54:36
 */
public interface ISesion {

	public TActividad getActividad();

	public Date getFechaFin();

	public Date getFechaInicio();

	public String getId();

	public int getNumeroPersonas();

	/**
	 * 
	 * @param t
	 */
	public void setActividad(TActividad t);

	/**
	 * 
	 * @param d
	 */
	public void setFechaFin(Date d);

	/**
	 * 
	 * @param d
	 */
	public void setFechaInicio(Date d);

	/**
	 * 
	 * @param s
	 */
	public void setId(String s);

	/**
	 * 
	 * @param n
	 */
	public void setNumeroPersonas(int n);
	
	public void setMonitor(Monitor m);

}