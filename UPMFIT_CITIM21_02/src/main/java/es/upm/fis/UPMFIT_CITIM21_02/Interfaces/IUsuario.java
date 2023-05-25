package es.upm.fis.UPMFIT_CITIM21_02.Interfaces;



/**
 * @author The Administrator
 * @version 1.0
 * @created 05-may.-2023 13:59:50
 */
public interface IUsuario {

	//public void cerrarSesion();

	public void destroy();

	public String getApellidos();

	public String getContrasena();

	public String getCorreo();

	public String getNombre();

	public String getNombreUsuario();

	//public void iniciarSesion();

	/**
	 * 
	 * @param apellidos
	 */
	public void setApellidos(String apellidos);

	/**
	 * 
	 * @param contrae�a
	 */
	public void setContrasena(String contrasena);

	/**
	 * 
	 * @param correo
	 */
	public void setCorreo(String correo);

	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre);

	/**
	 * 
	 * @param nickName
	 */
	public void setNombreUsuario(String nickName);

}