package com.cardcoffer.app;

import android.animation.LayoutTransition;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.SearchView;

/**
 * 
 * @author sinash
 * 
 */

public class CheckInActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		getActionBar().setTitle("Check In!");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		getMenuInflater().inflate(R.menu.main_actionbar, menu);

		// actionbar searchview animation

		SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
		int searchBarId = searchView.getContext().getResources().getIdentifier("android:id/search_bar", null, null);
		LinearLayout searchBar = (LinearLayout) searchView.findViewById(searchBarId);
		searchBar.setLayoutTransition(new LayoutTransition()); // TODO set good
																// animation!

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		if (id == R.id.action_search) {

			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
