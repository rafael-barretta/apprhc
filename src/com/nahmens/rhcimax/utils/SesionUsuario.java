package com.nahmens.rhcimax.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.nahmens.rhcimax.database.modelo.Checkin;
import com.nahmens.rhcimax.database.modelo.Permiso;
import com.nahmens.rhcimax.database.modelo.Usuario;
import com.nahmens.rhcimax.database.sqliteDAO.CheckinSqliteDao;
import com.nahmens.rhcimax.database.sqliteDAO.PermisoSqliteDao;

public class SesionUsuario {

	public static void iniciarSesion(Context context, Usuario usu) {
		//Guardamos el geoposicionamiento
		GPSTracker gps = new GPSTracker(context);
		// check if GPS enabled
        if(!gps.canGetLocation()){

            gps.showSettingsAlert();
        }
        
        double latitud = gps.getLatitude();
        double longitud = gps.getLongitude();
        
        Log.e("Login", "Your Location is - \nLat: " + latitud + "\nLong: " +longitud);

		String fecha = FormatoFecha.darFormatoDateTimeUS(new Date());

        Checkin checkin = new Checkin(latitud, longitud, fecha, null, usu.getId());
        CheckinSqliteDao checkinDao = new CheckinSqliteDao();
        int idCheckin = (int) checkinDao.insertarCheckin(context, checkin);
      
        PermisoSqliteDao permisoDao = new PermisoSqliteDao();
        JSONArray permisos = permisoDao.buscarPermisos(context, ""+usu.getIdRol());
                
        //Limpiamos el archivo de preferencias
        context.getSharedPreferences("Usuario", Context.MODE_PRIVATE).edit().clear().commit(); 
		
		//Guardamos en el archivo de preferencias la sesion del usuario
		//de manera que pueda ser accedido desde cualquier parte del codigo
		SharedPreferences prefs = context.getSharedPreferences("Usuario",Context.MODE_PRIVATE);

		SharedPreferences.Editor editor = prefs.edit();
		editor.putInt(Usuario.ID, usu.getId());
		editor.putString(Usuario.CORREO, usu.getCorreo());
		editor.putInt(Usuario.ID_ROL, usu.getIdRol());
		editor.putInt("idCheckin", idCheckin);
		
		for (int i=0; i<permisos.length(); i++){

			try {
				JSONObject permisoObject = permisos.getJSONObject(i);
				editor.putString("permiso"+i, permisoObject.getString(Permiso.NOMBRE));
				
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		editor.commit();

	}
	
	public static void cerrarSesion(Context contexto) {
		String fecha = FormatoFecha.darFormatoDateTimeUS(new Date());

		SharedPreferences prefs = contexto.getSharedPreferences("Usuario",Context.MODE_PRIVATE);
		int idCheckin = prefs.getInt("idCheckin", 0); 

		CheckinSqliteDao checkinDao = new CheckinSqliteDao();
		Checkin checkin = checkinDao.buscarCheckin(contexto, ""+idCheckin);
		checkin.setCheckout(fecha);

		checkinDao.modificarCheckin(contexto, checkin);

	}
	
	public static int getIdUsuario(Context contexto) {
		SharedPreferences prefs = contexto.getSharedPreferences("Usuario",Context.MODE_PRIVATE);
		return prefs.getInt(Usuario.ID, 0); 
	}
	
	public static int getIdCheckin(Context contexto) {
		SharedPreferences prefs = contexto.getSharedPreferences("Usuario",Context.MODE_PRIVATE);
		return prefs.getInt("idCheckin", 0); 
	}
	
	public static String getCorreo(Context contexto) {
		SharedPreferences prefs = contexto.getSharedPreferences("Usuario",Context.MODE_PRIVATE);
		return prefs.getString(Usuario.CORREO, "");
	}
	
	public static int getIdRol(Context contexto) {
		SharedPreferences prefs = contexto.getSharedPreferences("Usuario",Context.MODE_PRIVATE);
		return prefs.getInt(Usuario.ID_ROL, 0); 
	}
	
	public static ArrayList<String> getPermisos(Context contexto) {
		SharedPreferences prefs = contexto.getSharedPreferences("Usuario",Context.MODE_PRIVATE);
		Map<String, ?> todos = prefs.getAll(); 
		ArrayList<String> permisos = new ArrayList<String>();
		
		for(int i=0; i<todos.size(); i++){
			if(todos.containsKey("permiso"+i)){
				String permiso = (String) todos.get("permiso"+i);
				permisos.add(permiso);
			}
		}

		return permisos;
	}

}



/*public class Autologout extends IntentService{

	public Autologout(String name) {
		super(name);
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		// TODO Auto-generated method stub

	}

}*/
