package es.upm.fis.UPMFIT_CITIM21_02.Modelo;

import es.upm.fis.UPMFIT_CITIM21_02.Enumerados.TSexo;

public class Estudiante extends Cliente {
	
	private String matricula;

	public Estudiante(String contrasena, String correo, String nombre, String nombreUsuario, String apellidos, int edad,
			float peso, TSexo sexo, String tarjeta, String dni, String matricula) {
		
		super(contrasena, correo, nombre, nombreUsuario, apellidos, edad, peso, sexo, tarjeta, dni);
		this.matricula=matricula;
		// TODO Auto-generated constructor stub
	}
	
	public Estudiante(Cliente cliente) {
		
		super(cliente.contrasena, cliente.correo, cliente.nombre, cliente.nombreUsuario, cliente.apellidos, cliente.getEdad(), cliente.getPeso(), cliente.getSexo(), 
				cliente.getTarjeta(), cliente.getDni());		
		// TODO Auto-generated constructor stub
	}
	
	public String getMatricula() {
		return this.matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula=matricula;
	}
	

}
