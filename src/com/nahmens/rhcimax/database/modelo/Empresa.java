package com.nahmens.rhcimax.database.modelo;

public class Empresa {
	public final static String ID = "_id";
	public final static String NOMBRE = "nombre";
	public final static String TELEFONO = "telefono";
	public final static String RIF = "rif";
	public final static String WEB = "web";
	public final static String DIR_FISCAL= "dirFiscal";
	public final static String DIR_COMERCIAL = "dirComercial";
	public final static String FECHA_CREACION = "fechaCreacion";
	public final static String ID_USUARIO_CREADOR = "idUsuarioCreador";
	public final static String FECHA_MODIFICACION = "fechaModificacion";
	public final static String ID_USUARIO_MODIFICADOR = "idUsuarioModificador";
	public final static String FECHA_SINCRONIZACION = "fechaSincronizacion";
	public final static String MODIFICADO = "modificado";
	public final static String SINCRONIZADO = "sincronizado";
	public final static String LATITUD = "latitud";
	public final static String LONGITUD = "longitud";
	
	String id;
	String nombre;
	String telefono;
	String rif;
	String web;
	String dirFiscal;
	String dirComercial;
	Double latitud;
	Double longitud;
	String fechaCreacion;
	String idUsuarioCreador;
	String fechaModificacion;
	String idUsuarioModificador;
	String fechaSincronizacion;
	int modificado;
	
	//utilizado cuando se esta agregando
	public Empresa(String nombre, String telefono, String rif, String web,
			String dirFiscal, String dirComercial, 	String idUsuarioCreador, 
			String idUsuarioModificador) {

		this.nombre = nombre;
		this.telefono = telefono;
		this.rif = rif;
		this.web = web;
		this.dirFiscal = dirFiscal;
		this.dirComercial = dirComercial;
//		this.fechaCreacion = fechaCreacion;
//		this.fechaModificacion = fechaModificacion;
//		this.fechaSincronizacion = fechaSincronizacion;
		this.idUsuarioCreador = idUsuarioCreador;
		this.idUsuarioModificador = idUsuarioModificador;
//		this.modificado = modificado;
	}

	//utilizado cuando se esta modificando
	public Empresa(String id, String nombre, String telefono, String rif,
			String web, String dirFiscal, String dirComercial,
			String fechaModificacion, String idUsuarioModificador) {

		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.rif = rif;
		this.web = web;
		this.dirFiscal = dirFiscal;
		this.dirComercial = dirComercial;
//		this.fechaCreacion = fechaCreacion;
//		this.fechaSincronizacion = fechaSincronizacion;
		this.fechaModificacion = fechaModificacion;
//		this.idUsuarioCreador = idUsuarioCreador;
		this.idUsuarioModificador = idUsuarioModificador;
//		this.modificado = modificado;
	}
	
	//utilizado cuando se esta modificando coordenadas geoespaciales
	public Empresa(String id, String nombre, String telefono, String rif,
				String web, String dirFiscal, String dirComercial,
				Double latitud, Double longitud,
				String fechaModificacion, String idUsuarioModificador) {

			this.id = id;
			this.nombre = nombre;
			this.telefono = telefono;
			this.rif = rif;
			this.web = web;
			this.dirFiscal = dirFiscal;
			this.dirComercial = dirComercial;
			this.latitud = latitud;
			this.longitud = longitud;
//			this.fechaCreacion = fechaCreacion;
//			this.idUsuarioCreador = idUsuarioCreador;
			this.fechaModificacion = fechaModificacion;
			this.idUsuarioModificador = idUsuarioModificador;
//			this.fechaSincronizacion = fechaSincronizacion;
//			this.modificado = modificado;
		}
	
	
	//utilizado cuando se busca
	public Empresa(String id, String nombre, String telefono, String rif,
			String web, String dirFiscal, String dirComercial, Double latitud,
			Double longitud, String fechaCreacion, String idUsuarioCreador,
			String fechaModificacion, String idUsuarioModificador,
			String fechaSincronizacion, int modificado) {

		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.rif = rif;
		this.web = web;
		this.dirFiscal = dirFiscal;
		this.dirComercial = dirComercial;
		this.latitud = latitud;
		this.longitud = longitud;
		this.fechaCreacion = fechaCreacion;
		this.idUsuarioCreador = idUsuarioCreador;
		this.fechaModificacion = fechaModificacion;
		this.idUsuarioModificador = idUsuarioModificador;
		this.fechaSincronizacion = fechaSincronizacion;
		this.modificado = modificado;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getRif() {
		return rif;
	}
	public void setRif(String rif) {
		this.rif = rif;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	public String getDirFiscal() {
		return dirFiscal;
	}
	public void setDirFiscal(String dirFiscal) {
		this.dirFiscal = dirFiscal;
	}
	public String getDirComercial() {
		return dirComercial;
	}
	public void setDirComercial(String dirComercial) {
		this.dirComercial = dirComercial;
	}
	
	public Double getLatitud() {
		return latitud;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	public Double getLongitud() {
		return longitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getIdUsuarioCreador() {
		return idUsuarioCreador;
	}
	public void setIdUsuarioCreador(String idUsuarioCreador) {
		this.idUsuarioCreador = idUsuarioCreador;
	}
	public String getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	public String getIdUsuarioModificador() {
		return idUsuarioModificador;
	}
	public void setIdUsuarioModificador(String idUsuarioModificador) {
		this.idUsuarioModificador = idUsuarioModificador;
	}
	public String getFechaSincronizacion() {
		return fechaSincronizacion;
	}
	public void setFechaSincronizacion(String fechaSincronizacion) {
		this.fechaSincronizacion = fechaSincronizacion;
	}
	public int getModificado() {
		return modificado;
	}
	public void setModificado(int modificado) {
		this.modificado = modificado;
	}

}
