package es.upm.fis.UPMFIT_CITIM21_02.Modelo;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import es.upm.fis.UPMFIT_CITIM21_02.Modelo.Cliente;
import es.upm.fis.UPMFIT_CITIM21_02.Modelo.Curso;

/**
 * @author The Administrator
 * @version 1.0
 * @created 05-may.-2023 13:59:49
 */
public class InscripcionCurso {

	private Date fecha;
	public Curso m_CURSO;
	public Cliente m_CLIENTE;

	public InscripcionCurso(){

	}

	public InscripcionCurso(Date fecha, Curso m_CURSO, Cliente m_CLIENTE) {
		super();
		this.fecha = fecha;
		this.m_CURSO = m_CURSO;
		this.m_CLIENTE = m_CLIENTE;
	}


	public void finalize() throws Throwable {

	}
	public void destroy(){

	}

	/**
	 * 
	 * @param c
	 */
	public List<Curso> GetCursosFromCliente(Cliente c){
		return null;
	}

	public Date getFecha(){
		return this.fecha;
	}

	/**
	 * 
	 * @param C
	 */
	public List<Cliente> GetInscritos(Curso C){
		return null;
	}
	
	public Curso getCurso(){
		return this.m_CURSO;
	}
	
	
	/**
	 * 
	 * @param fecha
	 * @param curso
	 * @param cliente
	 */
	
}//end INSCRIPCION_CURSO