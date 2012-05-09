package com.senselabs.wireframe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;

public class HomeActivity extends Activity {
	protected Object mActionMode;
	GridView gridView;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_activity);
		// Look for Projects in SD, if there are projects then show in a
		// gridview

		// Adding long-touch capabilities to GridView
		gridView = (GridView) findViewById(R.id.gridview);
		gridView.setAdapter(new ImageAdapter(this));
		gridView.setChoiceMode(GridView.CHOICE_MODE_MULTIPLE_MODAL);
		gridView.setMultiChoiceModeListener(new MultiChoiceModeListener());

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.home_menu, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_new:
			startActivity(new Intent(getApplicationContext(),
					WireframeActivity.class));
			return true;
			// case R.id.action_copy:
			// //Do something related to our copy objects in project gridview
			// return true;
			//
			// case R.id.action_delete:
			// //Do something related to our delet objects in project gridview
			// return true;
		}

		return false;
	}

	public class MultiChoiceModeListener implements
			GridView.MultiChoiceModeListener {
		public boolean onCreateActionMode(ActionMode mode, Menu menu) {
			mode.setTitle("Select Items");
			mode.setSubtitle("One item selected");
			return true;
		}

		public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
			MenuInflater inflater = mode.getMenuInflater();
			inflater.inflate(R.menu.contextual, menu);
			return true;
		}

		public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
			switch (item.getItemId()) {
			case R.id.copy:
				Toast.makeText(HomeActivity.this,
						"You selected copy a Chihuahua", Toast.LENGTH_SHORT)
						.show();
				mode.finish();
			case R.id.delete:
				Toast.makeText(HomeActivity.this,
						"You selected delete a Chihuahua", Toast.LENGTH_SHORT)
						.show();
				mode.finish();

				return true;
			default:
				return false;
			}
		}

		public void onDestroyActionMode(ActionMode mode) {
		}

		public void onItemCheckedStateChanged(ActionMode mode, int position,
				long id, boolean checked) {
			int selectCount = gridView.getCheckedItemCount();
			switch (selectCount) {
			case 1:
				mode.setSubtitle("One item selected");
				break;
			default:
				mode.setSubtitle("" + selectCount + " items selected");
				break;
			}
		}

	}
}