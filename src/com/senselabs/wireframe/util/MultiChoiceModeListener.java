package com.senselabs.wireframe.util;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;

import com.senselabs.wireframe.R;

public class MultiChoiceModeListener implements
		GridView.MultiChoiceModeListener {
	GridView gridView;
	private Context mContext;

	public MultiChoiceModeListener(GridView gridView, Context mContext) {
		this.gridView = gridView;
		this.mContext = mContext;
	}

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
			Toast.makeText(mContext, "You selected copy a Chihuahua",
					Toast.LENGTH_SHORT).show();
			mode.finish();
		case R.id.delete:
			Toast.makeText(mContext, "You selected delete a Chihuahua",
					Toast.LENGTH_SHORT).show();
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