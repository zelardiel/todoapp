package com.pimfons.todoapp.adapter;

import java.util.ArrayList;
import java.util.List;

import com.pimfons.todoapp.R;
import com.pimfons.todoapp.models.Todo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class TodoListAdapter extends BaseAdapter{
	
	private List<Todo> todos = new ArrayList<Todo>();
	private final Context context;
	
	public TodoListAdapter(final Context context) {
		this.context = context;
	}
	
	public void setList(final List<Todo> todos) {
		this.todos = todos;
		notifyDataSetChanged();
	}
	@Override
	public int getCount() {
		if(todos != null){
			return todos.size();
		}
		return 0;
	}

	@Override
	public Object getItem(final int position) {
		if(todos != null){
			return todos.get(position);
		}
		return null;
	}

	@Override
	public long getItemId(final int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(final int position, View convertView, final ViewGroup parent) {
		if(convertView == null){
			convertView = View.inflate(context, R.layout.activity_main, null);
		}
		

		final TextView title = (TextView) convertView.findViewById(R.id.title_text);
		final TextView status = (TextView) convertView.findViewById(R.id.status_text);
		
		final Todo item = (Todo)getItem(position);
		
		title.setText(item.getTitle());
		status.setText(convertStatus(item.getIsDone()));
		
		return convertView;
	}
	
	private String convertStatus(String isdone){
		if (isdone.equals("1")){
			return "Done";
		}
		return "Not Done";
	}

}
