package es.upm.fis.UPMFIT_CITIM21_02.Controladores;

import java.util.ArrayList;
import java.util.List;

import es.upm.fis.UPMFIT_CITIM21_02.Modelo.Estudiante;
import es.upm.fis.UPMFIT_CITIM21_02.Modelo.Personal;

public class CPersonal {
	private List<Personal> listaPersonal;
	private static CPersonal instancia=new CPersonal();
	
	private CPersonal() {
		this.listaPersonal=new ArrayList<>();
		
	}
	
	public static CPersonal getInstance () {
		return instancia;
		
	}
	
	public void aniadirPersonal(Personal e) {
		
		this.listaPersonal.add(e);
	}
	
	public List<Personal> getListaPersonal(){
		return this.listaPersonal;
	}

}
