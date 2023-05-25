package es.upm.fis.UPMFIT_CITIM21_02.Modelo;

import es.upm.fis.UPMFIT_CITIM21_02.Enumerados.TSexo;

public class Personal extends Cliente{

	private String fechaAntiguedad;
	
	public Personal(String contrasena, String correo, String nombre, String nombreUsuario, String apellidos, int edad,
			float peso, TSexo sexo, String tarjeta, String dni, String fechaAntiguedad) {
		
		super(contrasena, correo, nombre, nombreUsuario, apellidos, edad, peso, sexo, tarjeta, dni);
		
		this.fechaAntiguedad=fechaAntiguedad;
		// TODO Auto-generated constructor stub
	}
	
	public Personal(Cliente cliente ) {
		
		super(cliente.contrasena, cliente.correo, cliente.nombre, cliente.nombreUsuario, cliente.apellidos, cliente.getEdad(), cliente.getPeso(), 
				cliente.getSexo(), cliente.getTarjeta(), cliente.getDni());
		
	}
	
	public String getFechaAntiguedad() {
		return this.fechaAntiguedad;
	}
	
	public void setFechaAntiguedad(String fechaAntiguedad) {
		this.fechaAntiguedad=fechaAntiguedad;
	}

}
