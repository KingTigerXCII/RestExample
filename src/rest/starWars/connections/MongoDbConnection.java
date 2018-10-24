package rest.starWars.connections;

import java.net.UnknownHostException;
import com.mongodb.MongoClient;

public class MongoDbConnection {
	private MongoClient mongoClient = null;
	
	public void init() {
		try {
			mongoClient = new MongoClient();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public MongoClient getMongoClient() {
		return mongoClient;
	}
}
