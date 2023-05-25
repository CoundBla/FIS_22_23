package es.upm.fis.UPMFIT_CITIM21_02.Modelo;

import java.util.HashMap;

import es.upm.fis.UPMFIT_CITIM21_02.Controladores.CAdministrador;
import es.upm.fis.UPMFIT_CITIM21_02.Controladores.CCliente;
import es.upm.fis.UPMFIT_CITIM21_02.Controladores.CCurso;
import es.upm.fis.UPMFIT_CITIM21_02.Controladores.CEstudiante;
import es.upm.fis.UPMFIT_CITIM21_02.Controladores.CInscripcion;
import es.upm.fis.UPMFIT_CITIM21_02.Controladores.CMonitor;
import es.upm.fis.UPMFIT_CITIM21_02.Controladores.CPersonal;
import es.upm.fis.UPMFIT_CITIM21_02.Vistas.VistaSistema;

/**
 * @author The Administrator
 * @version 1.0
 * @created 05-may.-2023 13:59:54
 */
public class Sistema {

	private CCliente controladorCliente;
	private CAdministrador controladorAdmin;
	private CCurso controladorCurso;
	private CMonitor controladorMonitor;
	private VistaSistema vistaSistema;
	private CInscripcion controladorInscripcion;
	private CPersonal controladorPersonal;
	private CEstudiante controladorEstudiante;
	

	
	/**CONSTRUCTORES**/
	
	public Sistema(){}

	

	/**Función para finalizar el sistema. Borrara todo lo creado en cascada.*/
	public void finalize() throws Throwable {
	
	}
	
	/**Función para inicializar el sistema, aquí se crea todo lo necesario para que funcione*/
	private void init(){
		this.controladorCliente = CCliente.getInstance();
		this.controladorAdmin = CAdministrador.getInstance();
		this.controladorCurso = CCurso.getInstance();
		this.controladorMonitor= CMonitor.getInstance();
		this.vistaSistema = VistaSistema.getInstance();	
		this.controladorInscripcion = CInscripcion.getInstance();
		this.controladorEstudiante = CEstudiante.getInstance();
		this.controladorPersonal = CPersonal.getInstance();
		HashMap<String, String> objeto = new HashMap<>();
		objeto.put("contraseña", "123789");
		objeto.put("correo", "c@j.com");
		objeto.put("nombre", "a");
		objeto.put("nombreUsuario", "usuario123333");
		objeto.put("apellidos", "ap");
		objeto.put("cuentaBancaria", "esto es una cuenta bancaria");
		objeto.put("dni","DNI que no se comprueba");
		this.controladorMonitor.crearMonitor(objeto.get("contraseña"),objeto.get("correo"),objeto.get("nombre"),
				objeto.get("nombreUsuario"),objeto.get("apellidos"),objeto.get("cuentaBancaria"),objeto.get("dni"));
		objeto.put("contraseña", "");
		objeto.put("correo", "");
		objeto.put("nombre", "");
		objeto.put("nombreUsuario", "");
		objeto.put("apellidos", "");
		objeto.put("telefono", "");
		this.controladorAdmin.crearAdministrador(objeto.get("contraseña"),objeto.get("correo"),objeto.get("nombre"),
				objeto.get("nombreUsuario"),objeto.get("apellidos"),objeto.get("telefono"));		
		/*inicializamos clases importantes para el sistema ej cliente*/
		
	}
	public void procesarSeleccion(int opcion) {	
			switch(opcion) {
			case 1: try {
					this.controladorCliente.inscribirClienteEnCurso(controladorCurso, controladorInscripcion,controladorEstudiante,controladorPersonal);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					this.vistaSistema.mostrarMensaje(e.getMessage());
				}
				break;
				
			case 2: this.controladorCurso.getInfoCursos();
				break;
				
			case 3: this.controladorCurso.crearCurso(controladorMonitor);
				break;
				
			case 4: 
				try {
					this.controladorCliente.darAltaCliente(controladorMonitor,controladorAdmin,controladorPersonal,controladorEstudiante);	
				}catch(Exception e) {
					this.vistaSistema.mostrarMensaje(e.getMessage());
				}				
				break;
			}
		

	}

	/**
	 * Función principal del sistema
	 * Se inicializará lo necesario para que funcione el sistema.
	 * Mostrará el menú y procesará las distintas acciones del usuario.
	 * @param s
	 *
	 */
	public static void main(String[] s){
		int opcion;
		//Hacer singleton de sistema?
		Sistema sistema=new Sistema();
		sistema.init();
		sistema.vistaSistema.bienvenida();
		do {
			sistema.vistaSistema.menu();
			opcion = sistema.vistaSistema.capturarSeleccionUsuario();
			sistema.procesarSeleccion(opcion);
		}while(opcion!=5);
		
		sistema.vistaSistema.despedida();
		try {
			sistema.finalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
}//end SISTEMA