package es.upm.fis.UPMFIT_CITIM21_02.Controladores;

import java.util.List;
import java.util.Map;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import es.upm.fis.UPMFIT_CITIM21_02.Modelo.InscripcionCurso;
import es.upm.fis.UPMFIT_CITIM21_02.Interfaces.ICliente;
import es.upm.fis.UPMFIT_CITIM21_02.Interfaces.ICurso;
import es.upm.fis.UPMFIT_CITIM21_02.Interfaces.ISesion;
import es.upm.fis.UPMFIT_CITIM21_02.Modelo.Cliente;
import es.upm.fis.UPMFIT_CITIM21_02.Modelo.Curso;
import es.upm.fis.UPMFIT_CITIM21_02.Modelo.Sesion;
import es.upm.fis.UPMFIT_CITIM21_02.Vistas.*;

/**
 * @author The Administrator
 * @version 1.0
 * @created 05-may.-2023 13:59:46
 */
public class CCurso {

	private static CCurso controladorCurso = new CCurso();
	private List<Curso> cursos;
	private VistaCurso vistaCurso;



	private CCurso(){
		this.vistaCurso=vistaCurso.getInstance();
		this.cursos = new ArrayList<Curso>();
	}

	public static CCurso getInstance() {
		return controladorCurso;
	}

	public void finalize() throws Throwable {

	}
	
	
	public void getInfoCursos(){
		for(ICurso curso: cursos) {
			//mostramos información del ccurso
			vistaCurso.mostrarMensaje("ID: "+curso.getId()+"\tNombre: "+curso.getNombre());
			//mostramos información de las sesiones del curso
			vistaCurso.mostrarMensaje("\nSesiones del curso: ");
			for(ISesion s: curso.getSesiones()) {
				vistaCurso.mostrarMensaje("ID: "+s.getId()+"\tActividad: "+s.getActividad()+"\n"
						+ "Inicio: "+s.getFechaInicio()+"\tFin: "+s.getFechaFin()+"\n");
				
			}
			//mostramos información de los clientes inscritos
			if(curso.getClientes().isEmpty()) {
				vistaCurso.mostrarMensaje("No hay clientes inscritos.\n");
				continue;
			}
			for(ICliente c: curso.getClientes()) {
				vistaCurso.mostrarMensaje("nombre: "+c.getNombre()+"\napellidos: "+c.getApellidos()+"\n");
			}
		}
	}

	/**
	 * 
	 * @param c
	 */
	

	

	/**
	 * 
	 * @param c
	 * @param curso
	 */
	public void inscripcionClienteCurso(Cliente c, CInscripcion controladorInscripcion)throws Exception{
		if(!this.cursos.isEmpty()) {
			int opcion;
			this.vistaCurso.mostrarMensaje("Selecciona curso al que inscribir");
			this.getInfoCursos();
			this.vistaCurso.mostrarMensaje("-----------------------------------------");
			do {
				opcion = this.vistaCurso.leerInt("Seleccion 1-"+this.cursos.size()+": ");
				if(opcion<1||opcion>this.cursos.size()) {
					this.vistaCurso.mostrarMensaje("Numero no valido");
				}
			}while(opcion<1||opcion>this.cursos.size());
			//Hay que validar que el cliente no esté dentro del curso, en caso de que ya esté, se envia error.
			
			if(!this.comprobarClienteCurso(c, opcion)) {
				
				controladorInscripcion.crearInscripcion(c, cursos.get(opcion-1));
				this.cursos.get(opcion-1).addCliente(c);
				this.vistaCurso.mostrarMensaje("Se ha inscrito el cliente correctamente.");
				
			}else {
				//this.vistaCurso.mostrarMensaje("ERROr!! El cliente ya estaba inscrito en el curso");
				throw new Exception("Error! El cliente ya está inscrito en el curso.");

			}
			
		}else
			throw new Exception("Error! No hay cursos creados.");
			//this.vistaCurso.mostrarMensaje("ERROr!! No hay cursos creados");

	}
	
	private boolean comprobarClienteCurso(Cliente c, int opcion) {
		for(ICliente cliente: cursos.get(opcion-1).getClientes()) {
			if(cliente==c) {
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * esta función es la de CrearCurso con varios datos de entrada, la diferencia es que debe recibir un HashMap<String,String>
	 * @param s,s
	*/	
	public void crearCurso(CMonitor cmon) {
		
		String ID=vistaCurso.leerDatos("Introduce ID");
		String nombre=vistaCurso.leerDatos("Introduce nombre del curso");
	    //StringBuilder errores = new StringBuilder();
		Curso nuevoCurso = new Curso(ID,nombre);
		//validación para comprobar que no se repita
		HashMap<String, String> resultado;
		resultado =  valCurso(nuevoCurso);
		if(resultado.get("result").equals("KO")) {
			vistaCurso.mostrarMensaje("Error al crear curso:\n"+resultado.get("error"));
		}
		//Añadimos sesiones al curso antes de validar el propio curso
		for(ISesion s: crearSesionesBase()) {
			s.setMonitor(cmon.getRandomMonitor());
			nuevoCurso.addSesion(s);
		}
		
		resultado = nuevoCurso.valCurso();
		if(resultado.get("result").equals("OK")) {
			addCurso(nuevoCurso);
			//añadir sesiones al controlador de sesiones
			//csesion.CrearSesionesFromCurso(nuevoCurso);
		}
		vistaCurso.mostrarMensaje("Curso creado correctamente.\n");
	}
	
	private void addCurso(Curso c) {
		cursos.add(c);
	}
	

	
	private HashMap<String,String> valCurso(Curso nuevocurso){
		HashMap<String, String> resultado = new HashMap<>();
	    StringBuilder errores = new StringBuilder();    
	    
	   for(ICurso curso :cursos) {
		   if(curso.getId().equals(nuevocurso.getId())) {
			   errores.append("El ID ya existe");
		   }
	   }
	   // Comprobar si hay errores
	    if (errores.length() > 0) {
	        resultado.put("result", "KO");
	        resultado.put("error", errores.toString());
	    } else {
	        resultado.put("result", "OK");
	    }
    	return resultado;
	}	
	
	public List<ISesion> crearSesionesBase() {
	    List<ISesion> newSesiones = new ArrayList<ISesion>();
	    for (int i = 0; i < 2; i++) {
	        ISesion s = new Sesion();
	        newSesiones.add(s);
	    }
	    return newSesiones;
	}
	    
	
}//end CCurso