package starWars.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

import starWars.adapters.JediAdapter;
import starWars.constants.DbCollectionNames;
import starWars.dao.JediDao;
import starWars.db.MongoDbHandler;
import starWars.models.Jedi;

@Stateless
@LocalBean
public class JediDaoImpl implements JediDao {
	
	private DBCollection jediCollection;

	@Override
	public void create(Jedi jedi) {
		jediCollection = MongoDbHandler.get().getCollection(DbCollectionNames.JEDI.toString());
		jediCollection.insert(JediAdapter.toDbObject(jedi));
	}

	@Override
	public void removeAll() {
		jediCollection = MongoDbHandler.get().getCollection(DbCollectionNames.JEDI.toString());
		jediCollection.remove(new BasicDBObject());
	}

	@Override
	public void removeByName(String name) {
		jediCollection = MongoDbHandler.get().getCollection(DbCollectionNames.JEDI.toString());
		jediCollection.remove(new BasicDBObject().append("name", name));
	}

	@Override
	public void removeById(int id) {
		jediCollection = MongoDbHandler.get().getCollection(DbCollectionNames.JEDI.toString());
		jediCollection.remove(new BasicDBObject().append("_id", id));
	}

	@Override
	public Jedi getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Jedi getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Jedi> getAll() {
		jediCollection = MongoDbHandler.get().getCollection(DbCollectionNames.JEDI.toString());
		List<Jedi> jedis = new ArrayList<Jedi>();
		
		DBCursor jediCursor = jediCollection.find();
		while(jediCursor.hasNext()) {
			BasicDBObject dbJedi = (BasicDBObject)jediCursor.next();
			Jedi jedi = JediAdapter.toJediObject(dbJedi);
			jedis.add(jedi);
		}
		
		return jedis;
	}
}
