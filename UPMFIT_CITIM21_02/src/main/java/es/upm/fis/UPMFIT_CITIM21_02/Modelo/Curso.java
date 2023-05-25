package es.upm.fis.UPMFIT_CITIM21_02.Modelo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import es.upm.fis.UPMFIT_CITIM21_02.Modelo.InscripcionCurso;
import es.upm.fis.UPMFIT_CITIM21_02.Modelo.Sesion;
import es.upm.fis.UPMFIT_CITIM21_02.Interfaces.ICurso;
import es.upm.fis.UPMFIT_CITIM21_02.Interfaces.ISesion;

/**
 * @author The Administrator
 * @version 1.0
 * @created 05-may.-2023 13:59:47
 */
public class Curso implements ICurso {

	private String id;
	private String nombre;
	private List<ISesion> m_sesiones;
	private List<InscripcionCurso> cursosInscritos;
	private List<Cliente> lista;
	
	public Curso(String id, String nombre){
		this.id=id;
		this.nombre=nombre;		
		this.cursosInscritos = new ArrayList<InscripcionCurso>();
		this.m_sesiones = new ArrayList<ISesion>();
		this.lista=new ArrayList<Cliente>();
	}

	public void finalize() throws Throwable {

	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<ISesion> getSesiones() {
		return this.m_sesiones;
	}
	public List<Cliente> getClientes() {
		return this.lista;
	}
	public void addCliente(Cliente cliente) {
		this.lista.add(cliente);
	} 

	public void addSesion(ISesion newSesion) {
		this.m_sesiones.add(newSesion);
	}
	
	public List<InscripcionCurso> getInscripcionCursos(){
		return this.cursosInscritos;
	}
	
	public void addInscripcionCurso(InscripcionCurso inscripcion) {
		this.cursosInscritos.add(inscripcion);
	}
	
	/**Función que valida que el curso tenga al menos 2 sesiones*/
	public HashMap<String,String> valCurso(){
		HashMap<String, String> resultado = new HashMap<>();
	    StringBuilder errores = new StringBuilder();
		if(m_sesiones.size()<2)
			errores.append("Número de sesiones insuficiente.");
		// Comprobar si hay errores
	    if (errores.length() > 0) {
	        resultado.put("result", "KO");
	        resultado.put("error", errores.toString());
	    } else {
	        resultado.put("result", "OK");
	    }
    	return resultado;	    
	}
	
	public void destroy() {
	
	}
	
	
	
}//end CURSO