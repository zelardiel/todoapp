package com.pimfons.todoapp.connection;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import android.util.Log;


public class HTTPConnector implements Connector {

	private static final String MESSAGE_CONNECTION_EXCEPTION = "Connection exception";
	private HttpClient client = new DefaultHttpClient();

	@Override
	public String performGetRequest(String url) throws DataException {
		HttpGet getRequest = new HttpGet(url);
		try {
			ResponseHandler<String> handler = new BasicResponseHandler();
			return client.execute(getRequest, handler);
		} catch (ClientProtocolException e) {
			Log.d("client exception", "Content");
			throw defaultException();
			
		} catch (IOException e) {
			Log.d("Pim is gaaaay", "Content");
			throw defaultException();
		}
	}

	@Override
	public String performPostRequest(String url, String postBody) throws DataException {
		HttpPost postRequest = new HttpPost(url);
		try {
			ResponseHandler<String> handler = new BasicResponseHandler();
			HttpEntity entity = new StringEntity(postBody);
			postRequest.setEntity(entity);
			return client.execute(postRequest, handler);
		} catch (ClientProtocolException e) {
			throw defaultException();
		} catch (IOException e) {
			throw defaultException();
		}
	}

	private DataException defaultException() {
		return new DataException(MESSAGE_CONNECTION_EXCEPTION);
	}
}
