package com.transform.configs;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

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

	
	//Singleton para realizar la conexi�n solo una vez
	public static DbConfig getConfiguration(){
		if(instancia == null){
			instancia = new DbConfig();
		}
		return instancia;
	}
	
	//M�todo para obtener la DB, sobre la cual se opera
	public MongoDatabase getDB(){
		return database;
	}

}
