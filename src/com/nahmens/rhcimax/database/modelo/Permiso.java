package com.nahmens.rhcimax.database.modelo;

public class Permiso {
	
	public final static String ID = "_id";
	public final static String NOMBRE = "nombre";
	public final static String DESCRIPCION = "descripcion";
	
	/*Lista de permisos*/
	public final static String LISTAR_TODO = "ListarTodo";
	public final static String LISTAR_PROPIOS = "ListarPropios";
	public final static String MODIFICAR_TODO = "ModificarTodo";
	public final static String MODIFICAR_PROPIOS = "ModificarPropios";
	public final static String ELIMINAR_TODO = "EliminarTodo";
	public final static String ELIMINAR_PROPIOS = "EliminarPropios";
	
	int id;
	String nombre;
	String descripcion;
	
	public Permiso(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
