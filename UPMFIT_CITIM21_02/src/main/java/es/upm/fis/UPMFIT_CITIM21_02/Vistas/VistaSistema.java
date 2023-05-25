package es.upm.fis.UPMFIT_CITIM21_02.Vistas;

import java.util.Scanner;

/**
 * @author The Administrator
 * @version 1.0
 * @created 05-may.-2023 13:59:56
 */
public class VistaSistema {
	private static VistaSistema instancia=new VistaSistema();
	private Scanner sc;

	private VistaSistema(){
		this.sc=new Scanner(System.in);
		

	}
	public static VistaSistema getInstance(){
		return instancia;
	}

	public void finalize() throws Throwable {

	}
	public void bienvenida(){
		System.out.println("Bienvenido a la aplicación web UPMFIT, gimnasio propiedad de la UPM");
	}
	
	public void despedida() {
		System.out.println("Gracias por utilizar a la aplicación web UPMFIT. Hasta pronto!");
	}

	public void menu(){
		
		System.out.println("Elija una de estas opciones:");
		System.out.println("1) Inscribir un cliente a curso");
		System.out.println("2) Ver detalles de los cursos");
		System.out.println("3) Crear Curso");
		System.out.println("4) Dar alta cliente");
		System.out.println("5) Salir");
		
	}
	public int capturarSeleccionUsuario() {
		
		int n=0;
		
		do {
			System.out.println("Escoja una de estas opciones");
			try {
				n=sc.nextInt();
			}catch(Exception e) {
				
				System.out.println("Carácter incorrecto");
			}
		}while(n<1||n>5);
		
		return n;
		
	}
	
	public void mostrarMensaje(String msg) {		
		System.out.println(msg);		
	}
	
	
}//end VISTASISTEMA