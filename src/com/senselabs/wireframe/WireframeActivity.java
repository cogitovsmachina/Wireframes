package com.senselabs.wireframe;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ActionBar.OnNavigationListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class WireframeActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wireframe_layout);
		// Opens a Canvas to do Drag & Drop
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.wireframe_menu, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_new:
			startActivity(new Intent(getApplicationContext(),
					WireframeActivity.class));
			return true;
		case R.id.action_copy:
			// Do something related to our copy objects in project gridview
			return true;

		case R.id.action_delete:
			// Do something related to our delete objects in project gridview
			return true;
		case R.id.action_edit_or_view:
			// item.setActionView(R.layout.custom);
		case R.id.action_new_view:
			Toast.makeText(getApplicationContext(), "...", Toast.LENGTH_SHORT).show();
		}

		return false;
	}


}
