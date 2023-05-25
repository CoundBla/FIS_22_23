package es.upm.fis.UPMFIT_CITIM21_02.Interfaces;

import java.util.List;

import es.upm.fis.UPMFIT_CITIM21_02.Modelo.Cliente;

/**
 * @author The Administrator
 * @version 1.0
 * @created 05-may.-2023 13:59:50
 */
public interface ICurso {
	
	public String getId();
	public String getNombre();
	public void setId(String id);
	public void setNombre(String nombre);
	public List<Cliente> getClientes();
	public List<ISesion> getSesiones();

}