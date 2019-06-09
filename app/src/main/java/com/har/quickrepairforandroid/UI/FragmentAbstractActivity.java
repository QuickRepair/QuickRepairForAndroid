package com.har.quickrepairforandroid.UI;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.har.quickrepairforandroid.R;

public abstract class FragmentAbstractActivity extends AppCompatActivity {

	public abstract Fragment createFragment();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment);

		FragmentManager fm = getSupportFragmentManager();
		Fragment fragment = fm.findFragmentById(R.id.fragment_empty_container);

		if(fragment == null) {
			fragment = createFragment();
			fm.beginTransaction().add(R.id.fragment_empty_container, fragment).commit();
		}
	}
}