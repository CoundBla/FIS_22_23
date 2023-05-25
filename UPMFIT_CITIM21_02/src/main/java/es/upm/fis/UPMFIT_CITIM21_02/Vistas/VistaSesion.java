package es.upm.fis.UPMFIT_CITIM21_02.Vistas;



/**
 * @author The Administrator
 * @version 1.0
 * @created 18-may.-2023 19:54:37
 */
public class VistaSesion {

	private static VistaSesion instancia;



	public void finalize() throws Throwable {

	}
	private void VistaSesion(){

	}

	public static VistaSesion getInstance(){
		return instancia;
	}
}//end VistaSesion