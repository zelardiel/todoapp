package com.pimfons.todoapp.connection;

public class ServiceFactory {
	
	private static final Connector connector = new HTTPConnector();
	private static final TodoService todoService = new RESTService();
	
	public static Connector getConnectorInstance() {
		return connector;
	}
	
	public static TodoService getNewsServiceInstance() {
		return todoService;
	}
}
