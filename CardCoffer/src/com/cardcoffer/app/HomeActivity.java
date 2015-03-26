package com.cardcoffer.app;

import android.animation.LayoutTransition;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SearchView;

import com.cardcoffer.app.customviews.ItemCardThumbnail;

/**
 * 
 * @author sinash
 *
 */
public class HomeActivity extends Activity {

	LinearLayout llCardContainer;
	ImageButton btnCardCoffer, btnCheckIn, btnExchange;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		llCardContainer = (LinearLayout) findViewById(R.id.home_llCardContainer);

		btnCardCoffer = (ImageButton) findViewById(R.id.btnHome_cardCoffer);
		btnCheckIn = (ImageButton) findViewById(R.id.btnHome_checkIn);
		btnExchange = (ImageButton) findViewById(R.id.btnHome_exchange);
		
		btnCheckIn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				launchCheckInActivity();
				
			}
		});

	}

	protected void launchCheckInActivity() {
		
		Intent intent = new Intent(this, CheckInActivity.class);
		startActivity(intent);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_actionbar, menu);

		// actionbar searchview animation

		SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
		// Get the ID for the search bar LinearLayout
		int searchBarId = searchView.getContext().getResources().getIdentifier("android:id/search_bar", null, null);
		// Get the search bar Linearlayout
		LinearLayout searchBar = (LinearLayout) searchView.findViewById(searchBarId);
		// Give the Linearlayout a transition animation.
		searchBar.setLayoutTransition(new LayoutTransition()); // TODO set good
																// animation!

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		if (id == R.id.action_search) {

			llCardContainer.addView(new ItemCardThumbnail(this));

			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
