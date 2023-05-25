package es.upm.fis.UPMFIT_CITIM21_02.Controladores;

import java.util.ArrayList;
import java.util.List;

import es.upm.fis.UPMFIT_CITIM21_02.Modelo.Estudiante;

public class CEstudiante {
	private List<Estudiante> listaEstudiantes;
	private static CEstudiante instancia=new CEstudiante();
	
	private CEstudiante() {
		this.listaEstudiantes=new ArrayList<>();
		
	}
	
	public static CEstudiante getInstance () {
		return instancia;
		
	}
	
	public void aniadirEstudiante(Estudiante e) {
		
		this.listaEstudiantes.add(e);
	}
	
	public List<Estudiante> getListaEstudiantes(){
		return this.listaEstudiantes;
	}
	
}
