package es.upm.fis.UPMFIT_CITIM21_02.Vistas;

import java.util.List;
import java.util.Scanner;

import es.upm.fis.UPMFIT_CITIM21_02.Interfaces.ICurso;
import es.upm.fis.UPMFIT_CITIM21_02.Interfaces.ISesion;
import es.upm.fis.UPMFIT_CITIM21_02.Interfaces.ICliente;

/**
 * @author The Administrator
 * @version 1.0
 * @created 18-may.-2023 19:54:37
 */
public class VistaCurso {

	private static VistaCurso instancia = new VistaCurso();
	private Scanner sc;



	public void finalize() throws Throwable {

	}
	private  VistaCurso(){
		sc=new Scanner(System.in);
	}

	public static VistaCurso getInstance(){
		return instancia;
	}
	
	public String leerDatos(String s) {
		System.out.println(s);
		String dato=sc.next();	
		return dato;
	}
	
	public int leerInt(String s) {
		Scanner scan = new Scanner(System.in);
		mostrarMensaje(s);
		int dato = -1;
		try {
			dato=scan.nextInt();
		}catch(Exception e) {
			System.out.println(e);
		}
		//scan.close();
		return dato;
	}
	public void mostrarCursos(List<ICurso> cursos) {
		
		for(ICurso curso: cursos) {
			//mostramos información del ccurso
			mostrarMensaje("ID: "+curso.getId()+"\tNombre: "+curso.getNombre());
			//mostramos información de las sesiones del curso
			mostrarMensaje("\nSesiones del curso: ");
			for(ISesion s: curso.getSesiones()) {
				mostrarMensaje("ID: "+s.getId()+"\tActividad: "+s.getActividad()+"\n"
						+ "Inicio: "+s.getFechaInicio()+"\tFin: "+s.getFechaFin()+"\n");
				
				
			}
			//mostramos información de los clientes inscritos
			if(curso.getClientes().isEmpty()) {
				mostrarMensaje("No hay clientes inscritos.\n");
				continue;
			}
			for(ICliente c: curso.getClientes()) {
				mostrarMensaje("nombre: "+c.getNombre()+"\napellidos: "+c.getApellidos()+"\n");
			}
		}
	}
	public void mostrarMensaje(String msg) {
		
		System.out.println(msg);
		
	}
}//end VistaCurso