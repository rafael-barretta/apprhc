package com.nahmens.rhcimax.database.DAO;

import android.content.Context;

public interface CotizacionDAO {
	long insertarCotizacion(Context contexto, String idUsuario, String idEmpleado);
	boolean eliminarCotizacion(Context contexto, String idCotizacion);
}
