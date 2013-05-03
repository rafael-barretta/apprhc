package com.nahmens.rhcimax;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}
	
	/*
	 * FUNCION TEMPORAL PARA CAMBIAR DE VISTA
	 */
	public void onClickClientes(View v){
		Intent i = new Intent(this, ClientesActivity.class);
		startActivity(i);
	}

}
