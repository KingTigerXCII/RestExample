package starWars.db;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;


@Startup
@Singleton
public class DbConfiguration {
	
	@PostConstruct
	public void init() {
		MongoDbHandler mongoDbHandler = MongoDbHandler.get();
		mongoDbHandler.connectToDatabase("StarWars");
	}
	
	@PreDestroy
	public void destroy() {
		// TODO close db connection
	}
}
