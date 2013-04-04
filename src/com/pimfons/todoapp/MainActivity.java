package com.pimfons.todoapp;



import com.pimfons.todoapp.adapter.TodoListAdapter;
import com.pimfons.todoapp.loaders.TodoListLoader;
import com.pimfons.todoapp.loaders.TodoResult;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends FragmentActivity implements LoaderCallbacks<TodoResult>, OnItemClickListener {
	private TodoListAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
		adapter = new TodoListAdapter(this);
		
		ListView listView = (ListView)findViewById(R.id.todolist);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(this);
		getSupportLoaderManager().initLoader(0, null, this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Loader<TodoResult> onCreateLoader(int id, Bundle arg1) {
		return new TodoListLoader(getApplicationContext());
	}

	@Override
	public void onLoadFinished(Loader<TodoResult> loader, TodoResult result) {
		if(result.getException() == null) {
			adapter.setList(result.getItems());
		} else {
			Toast.makeText(this, result.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
		}
		
	}

	@Override
	public void onLoaderReset(Loader<TodoResult> arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

}
