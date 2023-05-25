package es.upm.fis.UPMFIT_CITIM21_02.Controladores;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import es.upm.fis.UPMFIT_CITIM21_02.Modelo.Monitor;

/**
 * @author The Administrator
 * @version 1.0
 * @created 18-may.-2023 19:54:36
 */
public class CMonitor {

	public List <Monitor> m_Monitor;
	private static CMonitor instancia=new CMonitor();

	private CMonitor(){
		this.m_Monitor = new ArrayList<Monitor>();
	}
	public static  CMonitor getInstance() {
		return instancia;
	}
	

	public void destroy() throws Throwable {
		m_Monitor = null;
		instancia = null;		
	}
	/**
	 * 
	 * @param m
	 */
	public void aniadirMonitor(Monitor m){
		m_Monitor.add(m);
	}

	/**
	 * 
	 * @param s,s
	 */
	public void crearMonitor(String contrasena, String correo, String nombre, String nombreUsuario, 
			String apellidos,String cuentaBancaria, String dni){
		//No se implementa una validación
		Monitor newMonitor = new Monitor(contrasena,correo,nombre,nombreUsuario,apellidos,cuentaBancaria,dni);
		aniadirMonitor(newMonitor);
	}
	
	public Monitor getRandomMonitor() {
		Random random = new Random();
	    int index = random.nextInt(m_Monitor.size());
	    return m_Monitor.get(index);
	}
}//end CMonitor