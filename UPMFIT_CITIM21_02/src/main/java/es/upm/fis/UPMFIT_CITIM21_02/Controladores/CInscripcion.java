package es.upm.fis.UPMFIT_CITIM21_02.Controladores;

import java.util.*;
import es.upm.fis.UPMFIT_CITIM21_02.Modelo.*;

/**
 * @author The Administrator
 * @version 1.0
 * @created 18-may.-2023 19:54:36
 */
public class CInscripcion {

	private static CInscripcion instancia = new CInscripcion();
	private List<InscripcionCurso> inscripcionesCurso;

	private CInscripcion(){
		this.inscripcionesCurso = new ArrayList<InscripcionCurso>();
	}

	public void destroy() throws Throwable {

	}

	/**
	 * 
	 * @param c
	 * @param curso
	 */
	public HashMap<String,String> crearInscripcion(Cliente c, Curso curso){
		HashMap<String, String> resultado = new HashMap<>();
	    StringBuilder errores = new StringBuilder();
		InscripcionCurso inscripcion = new InscripcionCurso(new Date(), curso, c);
		if(!validarInscripcion(inscripcion)) {
			//Mensaje de Inscripcion ya existe
			errores.append("La inscripcion ya existe.");
		}
		
		
		// Comprobar si hay errores
	    if (errores.length() > 0) {
	        resultado.put("result", "KO");
	        resultado.put("error", errores.toString());
	    } else {
	    	inscripcionesCurso.add(inscripcion);
	        resultado.put("result", "OK");
	    }
		
		return resultado;
	}
	
	private boolean validarInscripcion(InscripcionCurso inscripcion) {
		boolean result = true;
		for(InscripcionCurso i: inscripcionesCurso) {
			if(i.m_CLIENTE.equals(inscripcion.m_CLIENTE) && i.m_CURSO.equals(inscripcion.m_CURSO)) {
				result = false;
			}
		}
		
		return result;
	}

	public static CInscripcion getInstance(){
		return instancia;
	}

	/**
	 * 
	 * @param c
	 * @param curso
	 */
	public HashMap<String, String> validarInscripcion(Cliente c, Curso curso){
		return null;
	}
}//end CInscripci�n