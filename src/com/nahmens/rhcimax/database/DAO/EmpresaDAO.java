package com.nahmens.rhcimax.database.DAO;

import android.content.Context;
import android.database.Cursor;

import com.nahmens.rhcimax.database.modelo.Empresa;

public interface EmpresaDAO {
	
	/** 
	 * Funcion que inserta una nueva empresa.
	 * 
	 * @param empresa Datos de la empresa a ingresar.
	 * @return Id de la empresa ingresada o -1 en caso de error.
	 */
	long insertarEmpresa(Context contexto, Empresa empresa);
	boolean modificarEmpresa(Context contexto, Empresa empresa);
	boolean eliminarEmpresa(Context contexto, String idEmpresa);
	
	/**
	 * Funcion que retorna lista de empresas y toda la informacion asociada a cada una de ellas.
	 * 
	 * @param contexto
	 * @return Cursor Lista de todas las empresas almacenadas en la BD
	 */
	Cursor listarEmpresas(Context contexto);
	
	/**
	 * Funcion utilizada para autocomplete.
	 * 
	 * @param contexto
	 * @param args Argumentos pasados al sql como los caracteres que se ingresan en el 
	 *             campo autocomplete.
	 * @return Nombres de empresas
	 */
	Cursor listarNombresEmpresas(Context contexto, String args);
	Empresa buscarEmpresa(Context contexto, String id);
	Cursor buscarEmpresaPorNombre(Context contexto, String args);
	
	/**
	 * Funcion utilizada por el buscador para filtrar la lista de empresas.
	 * Esta funcion compara el valor de args con el nombre de la empresa.
	 * 
	 * @param args Argumentos pasados al query como los caracteres que se ingresan en el campo
	 *             de buscador
	 * @return Cursor Lista filtrada
	 * 
	 */
	Cursor buscarEmpresaFilter(Context contexto, String args);

}
