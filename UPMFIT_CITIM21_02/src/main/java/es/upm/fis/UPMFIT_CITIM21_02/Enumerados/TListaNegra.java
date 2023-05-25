package es.upm.fis.UPMFIT_CITIM21_02.Enumerados;

public enum TListaNegra {
	USUARIO1("usuario1"),
    USUARIO2("usuario2"),
    USUARIO3("usuario3");

    private final String nombreUsuario;

    private TListaNegra(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public static boolean contiene(String nombreUsuario) {
        for (TListaNegra usuario : TListaNegra.values()) {
            if (usuario.nombreUsuario.equals(nombreUsuario)) {
                return true;
            }
        }
        return false;
    }
}
