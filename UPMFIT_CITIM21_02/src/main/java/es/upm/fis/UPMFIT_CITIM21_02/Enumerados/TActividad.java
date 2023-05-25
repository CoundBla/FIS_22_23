package es.upm.fis.UPMFIT_CITIM21_02.Enumerados;
import java.util.Random;
/**
 * @author The Administrator
 * @version 1.0
 * @created 05-may.-2023 13:59:54
 */
public enum TActividad {
	Gimnasia,
	Bicicleta,
	Natacion,
	Baile,
	Relax,
	General;
	
	private static final Random random = new Random();

    public static TActividad obtenerValorAleatorio() {
        return values()[random.nextInt(values().length)];
    }
}