package es.upm.fis.UPMFIT_CITIM21_02.Controladores;

import es.upm.fis.UPMFIT_CITIM21_02.Modelo.InscripcionCurso;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.upm.fis.UPMFIT_CITIM21_02.Modelo.InscripcionSesion;
import es.upm.fis.UPMFIT_CITIM21_02.Modelo.Monitor;
import es.upm.fis.UPMFIT_CITIM21_02.Modelo.Personal;
import es.upm.fis.UPMFIT_CITIM21_02.Modelo.Sesion;
import es.upm.fis.UPMFIT_CITIM21_02.Vistas.VistaCLiente;
import servidor.UPMUsers;
import es.upm.fis.UPMFIT_CITIM21_02.Enumerados.TSexo;
import es.upm.fis.UPMFIT_CITIM21_02.Interfaces.ICliente;
import es.upm.fis.UPMFIT_CITIM21_02.Modelo.Administrador;
import es.upm.fis.UPMFIT_CITIM21_02.Modelo.Cliente;
import es.upm.fis.UPMFIT_CITIM21_02.Modelo.Curso;
import es.upm.fis.UPMFIT_CITIM21_02.Modelo.Estudiante;
import utilidades.Cifrado;
import utilidades.Cifrado.Tipo;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * @author The Administrator
 * @version 1.0
 * @created 05-may.-2023 13:59:46
 */
public class CCliente {

	private static CCliente controladorCliente = new CCliente();
	private List<Cliente> clientes;
	private VistaCLiente vistaControladorCliente;	


	private CCliente(){
		clientes = new ArrayList<Cliente>();
		vistaControladorCliente = VistaCLiente.getInstance();
	}

	public static CCliente getInstance() {
		return controladorCliente;
	}
	public void finalize() throws Throwable {		
		vistaControladorCliente.finalize();
		clientes = null;
		controladorCliente = null;
	}
	
	private List<Curso> getCursosFromCliente(String correo){
		List<Curso> cursos = new ArrayList<Curso>();
		for(Cliente cliente : clientes) {
			if(cliente.getCorreo().equals(correo)) {
				for(InscripcionCurso inscripcion : cliente.getCursos()) {
					for(Curso curso : inscripcion.GetCursosFromCliente(cliente)) {
						cursos.add(curso);
					}
				}
				return cursos;
			}
		}
		return null;
	}
	
	private void aniadirCliente(Cliente cliente){	
		
		clientes.add(cliente);		
	}
	
	private void aniadirEstudiante(Cliente cliente, CEstudiante cEst) {
		Estudiante newEstudiante = new Estudiante(cliente);
		String matricula = this.vistaControladorCliente.leerString("Matricula: ");
		newEstudiante.setMatricula(matricula);
		cEst.aniadirEstudiante(newEstudiante);
	}
	
	private void aniadirPersonal(Cliente cliente, CPersonal cPer) {
		Personal newPersonal = new Personal(cliente);
		String fechaAntiguedad = this.vistaControladorCliente.leerFecha("Fecha de antiguedad(dd/mm/aaaa): ");
		newPersonal.setFechaAntiguedad(fechaAntiguedad);
		cPer.aniadirPersonal(newPersonal);
	}

	public void darAltaCliente(CMonitor cMon, CAdministrador cAdmin, CPersonal cPer, CEstudiante cEst)throws Exception{
		
		String nombre = this.vistaControladorCliente.leerString("Nombre: ");
		String apellidos = this.vistaControladorCliente.leerString("Apellidos: ");
		String nombreUsuario = this.vistaControladorCliente.leerString("Nombre de usuario: ");
		String correo = this.vistaControladorCliente.leerString("Correo: ");
		String contrasena = this.vistaControladorCliente.leerString("password: ");
		int edad = this.vistaControladorCliente.leerInt("Edad: ");
		float peso = this.vistaControladorCliente.leerFloat("Peso: ");
		TSexo sexo = this.vistaControladorCliente.leerStringSexo();
		String tarjeta = this.vistaControladorCliente.leerString("Tarjeta: ");
		String dni = this.vistaControladorCliente.leerString("DNI: ");
		
		Cliente nuevo = new Cliente(contrasena, correo, nombre, nombreUsuario, apellidos, edad, peso, sexo, tarjeta, dni);
		//Validamos que los datos del cliente tengan el formato correcto
		HashMap<String,String> error = nuevo.valCliente();		
		if(error.get("result").equals("OK")) {
			//Comprobamos que el cliente no exista en la lista
			if(validarCliente(nuevo, cMon, cAdmin)) {
				//obtenemos el tipo de usuario cliente/externo o estudianto/Alumno o Personal/PAS/PDI
				UPMUsers usuario = nuevo.getTipoCliente();
				//Ciframos password				
				nuevo.setContrasena(Cifrado.cifrar(nuevo.getContrasena(),Tipo.MD5));
				//Se mete el cliente en la lista de clientes dependiendo del usuario
				if(usuario == null) {
					this.aniadirCliente(nuevo);
				}
				if(usuario.equals(UPMUsers.ALUMNO)) {
					this.aniadirEstudiante(nuevo, cEst);
				}
				if(usuario.equals(UPMUsers.PAS)||usuario.equals(UPMUsers.PDI)) {
					this.aniadirPersonal(nuevo, cPer);
				}				
				//se manda mensaje de todo correcto
				this.vistaControladorCliente.mostrarMensaje("Cliente creado!!");
				return;
			}		
			//this.vistaControladorCliente.mostrarMensaje("El email o el DNI ya existen en el sistema.");
			throw new Exception("El email o el DNI ya existen en el sistema.");
		}
		if(error.get("result").equals("KO")) {
			//this.vistaControladorCliente.mostrarMensaje("Error al crear el cliente:\n"+error.get("error"));
			//this.vistaControladorCliente.mostrarMensaje("\n Corrija todos los datos y vuelva a intentarlo.");			
			String stringError = "Error al crear el cliente:\n"+error.get("error");
			throw new Exception(stringError);
		}
	}

	
	public void destroy(){

	}
	
	/**
	 * Esta función valida que el cliente no se está repitiendo dentro de la lista
	 * @param c
	 */
	private boolean validarCliente(Cliente c, CMonitor cMon, CAdministrador cAdmin){
		//Comprobar que las creedenciales no coincidan con otro ciente, admin o monitor
		String correo = c.getCorreo();
		String dni = c.getDni();
		//Comprobamos que el cliente no se repita
		for(Cliente cliente : this.clientes) {
			if(correo.equals(cliente.getCorreo()) || dni.equals(cliente.getDni())) {
				return false;
			}
		}
		//Comprobamos que el cliente no sea un monitor
		for(Monitor m: cMon.m_Monitor) {
			if(correo.equals(m.getCorreo()) || dni.equals(m.getDni())) {
				return false;
			}
		}
		//Comprobamos que el cliente no sea admin.
		for(Administrador a: cAdmin.getAdmins()) {
			if(correo.equals(a.getCorreo())) {
				return false;
			}
		}		
		return true;
	}
	
	private List<Cliente> mostrarClientes(CEstudiante cEst, CPersonal cPer) {
		int i = 1;
		List<Cliente> allClientes = new ArrayList<Cliente>();
		for(Personal p : cPer.getListaPersonal()) {
			this.vistaControladorCliente.mostrarMensaje(i+") "+p.getNombre()+" "+p.getApellidos());
			i++;
			allClientes.add(p);
		}
		for(Estudiante e : cEst.getListaEstudiantes()) {
			this.vistaControladorCliente.mostrarMensaje(i+") "+e.getNombre()+" "+e.getApellidos());
			i++;
			allClientes.add(e);
		}		
		for(Cliente c : clientes) {
			this.vistaControladorCliente.mostrarMensaje(i+") "+c.getNombre()+" "+c.getApellidos());
			i++;
			allClientes.add(c);
		};
		
		return allClientes;
	}
	
	public void inscribirClienteEnCurso(CCurso controladorCurso, CInscripcion controladorInscripcion, 
			CEstudiante cEst, CPersonal cPer)throws Exception {
		if(!this.clientes.isEmpty()||!cEst.getListaEstudiantes().isEmpty()||!cPer.getListaPersonal().isEmpty()) {
			int opcion;
			List<Cliente> allClientes = this.mostrarClientes(cEst,cPer);
			do{
				opcion = this.vistaControladorCliente.leerInt("Elige cliente(1-"+allClientes.size()+"): ");
				if(opcion<1||opcion>allClientes.size()) {
					this.vistaControladorCliente.mostrarMensaje("Opcion no valida");					
				}
			}while(opcion<1||opcion>allClientes.size());
			
			controladorCurso.inscripcionClienteCurso(allClientes.get(opcion-1),controladorInscripcion);
		}else {
			throw new Exception("No hay clientes");
			//this.vistaControladorCliente.mostrarMensaje("No hay clientes");			
		}		
	}
	
}//end CCliente