package com.transform.configs;

public class DbConfig {
	private MongoClientURI url;
	private MongoClient mongoClient;
	private MongoDatabase database;

	private static DbConfig instancia;

	private DbConfig(){
		url = new MongoClientURI(
				"mongodb+srv://transform:1234@cluster0-tcjsq.mongodb.net/transform?retryWrites=true&w=majority");
		mongoClient = new MongoClient(url);
		database = mongoClient.getDatabase("transform");
	}

	
	//Singleton para realizar la conexión solo una vez
	public static DbConfig getConfiguration(){
		if(instancia == null){
			instancia = new DbConfig();
		}
		return instancia;
	}
	
	//Método para obtener la DB, sobre la cual se opera
	public MongoDatabase getDB(){
		return database;
	}

}
