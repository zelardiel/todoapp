package com.pimfons.todoapp.loaders;

import com.pimfons.todoapp.connection.DataException;
import com.pimfons.todoapp.connection.ServiceFactory;
import com.pimfons.todoapp.connection.TodoService;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

public class TodoListLoader extends AsyncTaskLoader<TodoResult> {
	
	private TodoResult result;

	public TodoListLoader(Context context) {
		super(context);
	}
	@Override
	public TodoResult loadInBackground() {
		TodoService service = ServiceFactory.getNewsServiceInstance();
		TodoResult result = new TodoResult();
		try {
			result.setItems(service.getTodos());
			Log.d("werk", result.isItEmpty());
		} catch (DataException exception) {
			result.setException(exception);
		}
		return result;
	}

	@Override
	protected void onStartLoading() {
		if (this.result != null) {
			deliverResult(this.result);
		}

		if (takeContentChanged() || this.result == null) {
			forceLoad();
		}

	}

	@Override
	public void deliverResult(TodoResult result) {
		if (this.result == null) {
			this.result = result;
		}
		if (isStarted()) {
			super.deliverResult(result);
		}
	}

}
