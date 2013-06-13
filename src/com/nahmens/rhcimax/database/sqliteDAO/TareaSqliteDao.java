package com.nahmens.rhcimax.database.sqliteDAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.nahmens.rhcimax.database.ConexionBD;
import com.nahmens.rhcimax.database.DataBaseHelper;
import com.nahmens.rhcimax.database.DAO.TareaDAO;
import com.nahmens.rhcimax.database.modelo.Tarea;

public class TareaSqliteDao implements TareaDAO{

	@Override
	public long insertarTarea(Context contexto, Tarea tarea) {
		ConexionBD conexion = new ConexionBD(contexto);
		long idFila = 0;

		try{
			conexion.open();

			ContentValues values = new ContentValues();

			values.put(Tarea.NOMBRE, tarea.getNombre());
			values.put(Tarea.FECHA, tarea.getFecha());
			values.put(Tarea.HORA, tarea.getHora());
			values.put(Tarea.DESCRIPCION, tarea.getDescripcion());
			values.put(Tarea.FINALIZADA, tarea.getFinalizada());
			values.put(Tarea.ID_USUARIO, tarea.getIdUsuario());
			values.put(Tarea.ID_EMPLEADO,tarea.getIdEmpleado());
			values.put(Tarea.ID_EMPRESA,tarea.getIdEmpresa());

			idFila = conexion.getDatabase().insert(DataBaseHelper.TABLA_TAREA, null,values);

		}finally{
			conexion.close();
		}

		return idFila;
	}

	@Override
	public boolean modificarTarea(Context contexto, Tarea tarea) {
		ConexionBD conexion = new ConexionBD(contexto);
		boolean modificado = false;

		try{
			conexion.open();
			
			ContentValues values = new ContentValues();
			values.put(Tarea.NOMBRE, tarea.getNombre());
			values.put(Tarea.FECHA, tarea.getFecha());
			values.put(Tarea.HORA, tarea.getHora());
			values.put(Tarea.DESCRIPCION, tarea.getDescripcion());
			values.put(Tarea.FINALIZADA, tarea.getFinalizada());
			values.put(Tarea.ID_USUARIO, tarea.getIdUsuario());
			values.put(Tarea.ID_EMPLEADO,tarea.getIdEmpleado());
			values.put(Tarea.ID_EMPRESA,tarea.getIdEmpresa());

			int value = conexion.getDatabase().update(DataBaseHelper.TABLA_TAREA, values, "_id=?", new String []{Integer.toString(tarea.getId())});

			if(value!=0){
				modificado = true;
			}

		}finally{
			conexion.close();
		}

		return modificado;
	}

	@Override
	public boolean eliminarTarea(Context contexto, String idTarea) {
		ConexionBD conexion = new ConexionBD(contexto);
		boolean eliminado = false;

		try{
			conexion.open();

			long value = conexion.getDatabase().delete(DataBaseHelper.TABLA_TAREA, "_id=?", new String[]{idTarea});

			if(value!=0){
				eliminado = true;
			}

		}finally{
			conexion.close();
		}

		return eliminado;
	}

	@Override
	public Tarea buscarTarea(Context contexto, String idTarea) {
		ConexionBD conexion = new ConexionBD(contexto);
		Cursor mCursor = null;
		Tarea tarea = null;

		try{
			conexion.open();

			mCursor = conexion.getDatabase().query(DataBaseHelper.TABLA_TAREA , null , Tarea.ID + " = ? ", new String [] {idTarea}, null, null, null);

			if (mCursor.getCount() > 0) {
				mCursor.moveToFirst();

				tarea = new Tarea( mCursor.getString(mCursor.getColumnIndex(Tarea.NOMBRE)), 
						mCursor.getString(mCursor.getColumnIndex(Tarea.FECHA)), 
						mCursor.getString(mCursor.getColumnIndex(Tarea.HORA)), 
						mCursor.getString(mCursor.getColumnIndex(Tarea.DESCRIPCION)), 
						mCursor.getInt(mCursor.getColumnIndex(Tarea.FINALIZADA)), 
						mCursor.getInt(mCursor.getColumnIndex(Tarea.ID_USUARIO)),
						mCursor.getInt(mCursor.getColumnIndex(Tarea.ID_EMPRESA)),
						mCursor.getInt(mCursor.getColumnIndex(Tarea.ID_EMPLEADO)));
			}

		}finally{
			conexion.close();
		}

		return tarea;
	}

	@Override
	public Cursor listarTareas(Context contexto) {
		ConexionBD conexion = new ConexionBD(contexto);
		Cursor mCursor = null;
		try{

			conexion.open();

			mCursor = conexion.getDatabase().rawQuery("SELECT * FROM " + DataBaseHelper.TABLA_TAREA  + " order by " + Tarea.FECHA, null);

			if (mCursor != null) {
				mCursor.moveToFirst();
			}

		}finally{
			conexion.close();
		}

		return mCursor;
	}
	


}
