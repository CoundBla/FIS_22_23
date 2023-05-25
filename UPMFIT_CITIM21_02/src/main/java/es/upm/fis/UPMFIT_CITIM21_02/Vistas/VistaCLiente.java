package es.upm.fis.UPMFIT_CITIM21_02.Vistas;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import es.upm.fis.UPMFIT_CITIM21_02.Modelo.Sesion;
import es.upm.fis.UPMFIT_CITIM21_02.Controladores.CCliente;
import es.upm.fis.UPMFIT_CITIM21_02.Enumerados.TSexo;
import es.upm.fis.UPMFIT_CITIM21_02.Interfaces.ICurso;

/**
 * @author The Administrator
 * @version 1.0
 * @created 05-may.-2023 13:59:56
 */
public class VistaCLiente {

	private static VistaCLiente instancia = new VistaCLiente();

	private VistaCLiente(){

	}

	public static VistaCLiente getInstance() {
		return instancia;
	}

	public void finalize() throws Throwable {

	}


	/**
	 * 
	 * @param msg
	 */
	public void mostrarMensaje(String msg){
		System.out.println(msg);
	}
	
	public void mostrarMenu() {
		System.out.println("Elija una de estas opciones:");
		System.out.println("1) Inscribirse a un Curso");
		System.out.println("2) Volver");
	}
	
	
	public String leerString(String s) {
		Scanner scan = new Scanner(System.in);
		mostrarMensaje(s);
		String dato=scan.next();
		//scan.close();
		return dato;
	}
	
	public TSexo leerStringSexo() {
		String dato;
		TSexo sexo;
		Scanner scan = new Scanner(System.in);
		mostrarMensaje("Hombre o Mujer: ");
		do {
			dato=scan.next();			
			if(!dato.equals("Hombre")&&!dato.equals("Mujer")) {
				mostrarMensaje("sexo no válido.\n");
			}
		}while(!dato.equals("Hombre")&&!dato.equals("Mujer"));		
		sexo = TSexo.valueOf(dato);
		//scan.close();
		return sexo;
	}
	
	public String leerFecha(String s) {
		String dato;
		Scanner scan = new Scanner(System.in);
		mostrarMensaje(s);
		//Se ejecutará el bucle mientras el usuario no introduzca una fecha en formato dd/mm/aaaa
		do {
			dato=scan.next();			
			//Si el string no está en formato dd/mm/aaaa 
			if(!dato.matches("\\d{2}/\\d{2}/\\d{4}")) {
				mostrarMensaje("fecha no válida.\n");
			}
		}while(!dato.matches("\\d{2}/\\d{2}/\\d{4}"));	
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
	
	public float leerFloat(String s) {
		Scanner scan = new Scanner(System.in);
		mostrarMensaje(s);
		float dato = -1;
		try {
			dato=scan.nextFloat();
		}catch(Exception e) {
			System.out.println(e);
		}
		//scan.close();
		return dato;
	}
	
	/*
	 * 
	 */



	
}//end VistaCLiente