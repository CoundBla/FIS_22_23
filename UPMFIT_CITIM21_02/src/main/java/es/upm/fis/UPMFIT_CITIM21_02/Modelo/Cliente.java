package es.upm.fis.UPMFIT_CITIM21_02.Modelo;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

import es.upm.fis.UPMFIT_CITIM21_02.Modelo.InscripcionSesion;
import es.upm.fis.UPMFIT_CITIM21_02.Modelo.InscripcionCurso;
import es.upm.fis.UPMFIT_CITIM21_02.Enumerados.TSexo;
import es.upm.fis.UPMFIT_CITIM21_02.Interfaces.*;
import servidor.Autenticacion;
import servidor.ObtencionDeRol;
import servidor.UPMUsers;

/**
 * @author The Administrator
 * @version 1.0
 * @created 09-may.-2023 21:05:25
 */
public class Cliente extends NoAdmin implements ICliente {

	private int edad;
	private float peso;
	private TSexo sexo;
	private String tarjeta;	
	private List<InscripcionCurso> cursosInscritos;

	/**Constructor de Cliente
	 * 
	 * @param dniIn
	 * @param edadIn
	 * @param pesoIn
	 * @param sexoIn
	 * @param tarjetaIn
	 */
	public Cliente(String contrasena, String correo, String nombre, String nombreUsuario, 
			String apellidos,int edad, float peso, TSexo sexo, String tarjeta, String dni) {
		
		super(dni, apellidos, contrasena, correo, nombre, nombreUsuario);
		this.edad=edad;
		this.peso = peso;
		this.sexo = sexo;
		this.tarjeta = tarjeta;
		this.cursosInscritos = new ArrayList<InscripcionCurso>();
	}
	
	public void finalize() throws Throwable {
		super.finalize();
	}

	
	
	
	/**Función que cambia el descuento del cliente de acuerdo a su email.*/
	public UPMUsers getTipoCliente() {
		Autenticacion validarCuenta = new Autenticacion();		
		if(!validarCuenta.existeCuentaUPM(this.correo)) {			
			return null;
		}
		UPMUsers rol = ObtencionDeRol.get_UPM_AccountRol(this.correo);
		return rol;	
	}

	public void destroy(){

	}
	public String esValido(){
		String error = "";
		
		Autenticacion validarCuenta = new Autenticacion();
		
		if(this.getNombre().matches(".*\\d+.*") || this.getNombre().length()<=0 || this.getNombre().length()>=15 ) {
			error = "nombre";
		}else if(this.getApellidos().matches(".*\\d+.*") || this.getApellidos().length()<=0) {
			error = "apellido";
		}else if(!this.getCorreo().matches(".*@.*\\.com$") || !validarCuenta.existeCuentaUPM(correo)) {
			error = "correo";
		}else if(this.contrasena.length()<=0) {
			error = "contraseña";
		}else if(this.nombreUsuario.length()<=0) {
			error = "nombre de usuario";
		}else if(this.edad <=16 || this.edad >= 105) {
			error = "edad";
		}else if(this.peso<=10 || this.peso>500) {
			error = "peso";
		}else if(this.tarjeta.length()<13 || this.tarjeta.length()>18) {
			error = "tarjeta";
		}else if(this.getDni().length()!=9 || !this.getDni().matches("\\d{8}[A-HJ-NP-TV-Z]")) {
			error = "DNI";
		}
		return error;
	}

	public HashMap<String, String> valCliente(){
		HashMap<String, String> resultado = new HashMap<>();
	    StringBuilder errores = new StringBuilder();
	    
	    resultado = valUsuario(this);
	    //si la validación de usuario tiene un error lo añadimos a errores.
	    if(resultado.get("result").equals("KO")) {
	    	errores.append(resultado.get("error"));
	    }
	    //Comprobamos que el codigo de la tarjeta tenga la longitud adecuada
	    if(this.tarjeta.length()<13 || this.tarjeta.length()>18) {
	    	errores.append("El identificador de la tarjeta tiene un formato no válido. Longitud 13-17.\n");
	    }
	    //Comprobamos la validez del DNI
	    if(this.getDni().length()!=9 || !this.getDni().matches("\\d{8}[A-HJ-NP-TV-Z]")) {
	    	errores.append("El DNI no es válido.\n");
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
	public int getEdad(){
		return this.edad;
	}

	public float getPeso(){
		return this.peso;
	}

	public TSexo getSexo(){
		return this.sexo;
	}

	public String getDni() {
		return super.getDni();
	}
	/**
	 * 
	 * @param dni
	 */
	public void setDni(String dni){
		super.setDni(dni);
	}

	/**
	 * 
	 * @param edad
	 */
	public void setEdad(int edad){
		this.edad=edad;
	}

	/**
	 * 
	 * @param peso
	 */
	public void setPeso(float peso){
		this.peso=peso;
	}

	/**
	 * 
	 * @param sexo
	 */
	public void setSexo(TSexo sexo){
		this.sexo=sexo;
	}

	/**
	 * 
	 * @param tarjeta
	 */
	public void setTarjeta(String tarjeta){
		this.tarjeta=tarjeta;
	}
	
	
	public List<InscripcionCurso> getCursos(){
		return this.cursosInscritos;
	}
	
	public void addCurso(InscripcionCurso curso) {
		this.cursosInscritos.add(curso);
	}

	@Override
	public String getTarjeta() {
		// TODO Auto-generated method stub
		return null;
	}
	
}