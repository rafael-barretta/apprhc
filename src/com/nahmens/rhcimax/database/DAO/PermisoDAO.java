package com.nahmens.rhcimax.database.DAO;

import org.json.JSONArray;

import android.content.Context;
import android.database.Cursor;

import com.nahmens.rhcimax.database.modelo.Permiso;

public interface PermisoDAO {
	
	JSONArray buscarPermisos(Context contexto, String idRol);
	String insertarPermiso(Context context, Permiso permiso);
	boolean modificarPermiso(Context context, Permiso permiso);
	/**
     * Funcion que elimina todos los registros de una tabla
     * @param context
     * @return numero de registros eliminados
     */
    int eliminarPermisos(Context context);
    /**
	 * Funcion que retorna lista de Permiso que no han sido sincronizados
	 */
	Cursor listarPermisoNoSync(Context contexto);

}
