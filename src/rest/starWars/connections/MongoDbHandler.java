package rest.starWars.connections;

import java.net.UnknownHostException;

import javax.ejb.Startup;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.sun.jersey.spi.resource.Singleton;

@Singleton
@Startup
public class MongoDbHandler {
	
	private static final String hostname = "localhost";
	private static final int port = 27017;
	private static MongoDbHandler mongoDbHandler = new MongoDbHandler();
	private MongoClient mongoClient;
	private DB db;
	
	private MongoDbHandler() {
		try {
			init();	
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void init() throws UnknownHostException {
		System.out.println("MongoDbHandler initializisation....");
		String uri = "mongodb://" + hostname + ":" + port;
		MongoClientURI mongoClientUri = new MongoClientURI(uri);
		mongoClient = new MongoClient(mongoClientUri);
	}
	
	public static MongoDbHandler get() {
		return mongoDbHandler;
	}
	
	public MongoDbHandler connectToDatabase(String databaseName) {
		if(db != null) {
			throw new RuntimeException("Already connected to " + db.getName());
		}
		
		db = mongoClient.getDB(databaseName);
		return mongoDbHandler;
	}
	
	public DBCollection getCollection(String collectionName) {
		return db.getCollection(collectionName);
	}
	
}
