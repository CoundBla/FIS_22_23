package es.upm.fis.UPMFIT_CITIM21_02.Interfaces;

import es.upm.fis.UPMFIT_CITIM21_02.Enumerados.TSexo;

/**
 * @author The Administrator
 * @version 1.0
 * @created 18-may.-2023 19:54:36
 */
public interface ICliente {

	public int getEdad();

	public float getPeso();

	public TSexo getSexo();

	public String getTarjeta();
	
	public String getNombre();
	public String getApellidos();

	/**
	 * 
	 * @param edad
	 */
	public void setEdad(int edad);

	/**
	 * 
	 * @param p
	 */
	public void setPeso(float p);

	/**
	 * 
	 * @param s
	 */
	public void setSexo(TSexo s);

	/**
	 * 
	 * @param s
	 */
	public void setTarjeta(String s);

}