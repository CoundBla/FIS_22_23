package es.upm.fis.UPMFIT_CITIM21_02.Controladores;

import java.util.*;

import es.upm.fis.UPMFIT_CITIM21_02.Interfaces.ISesion;
import es.upm.fis.UPMFIT_CITIM21_02.Modelo.Curso;
import es.upm.fis.UPMFIT_CITIM21_02.Modelo.Sesion;
import es.upm.fis.UPMFIT_CITIM21_02.Vistas.VistaSesion;
/**
 * @author The Administrator
 * @version 1.0
 * @created 18-may.-2023 19:54:36
 */
public class CSesion {

	private static CSesion instancia=new CSesion();
	private List<ISesion> listaSesiones;
	private VistaSesion vistaSesion;



	public void destroy() throws Throwable {

	}
	private CSesion(){
		this.listaSesiones = new ArrayList<ISesion>();
		this.vistaSesion = VistaSesion.getInstance();
	}

	public static CSesion getInstance(){
		return instancia;	
	}
	
	public List<ISesion> crearSesionesBase() {
	    List<ISesion> newSesiones = new ArrayList<ISesion>();
	    for (int i = 0; i < 2; i++) {
	        ISesion s = new Sesion();
	        newSesiones.add(s);
	    }
	    return newSesiones;
	}
	
	public void CrearSesionesFromCurso(Curso nuevoCurso) {		
		for(ISesion s : nuevoCurso.getSesiones()) {
			listaSesiones.add(s);
		}		
	}
}//end CSesion