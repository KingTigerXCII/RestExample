package starWars.daoImpl;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

import starWars.adapters.JediAdapter;
import starWars.connections.MongoDbHandler;
import starWars.constants.DatabaseCollectionNames;
import starWars.dao.JediDao;
import starWars.models.Jedi;

@Stateless
@LocalBean
public class JediDaoImpl implements JediDao {
	
	private DBCollection jediCollection;

	@Override
	public void create(Jedi jedi) {
		jediCollection = MongoDbHandler.get().getCollection(DatabaseCollectionNames.JEDI.toString());
		jediCollection.insert(JediAdapter.toDbObject(jedi));
	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeByName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateById(int id) {
		// TODO Auto-generated method stub
		
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
	public ArrayList<String> getAll() {
		jediCollection = MongoDbHandler.get().getCollection(DatabaseCollectionNames.JEDI.toString());
		ArrayList<String> jedis = new ArrayList<String>();
		
		DBCursor jediCursor = jediCollection.find();
		while(jediCursor.hasNext()) {
			jedis.add((String)jediCursor.next().get("name"));
		}
		
		return jedis;
	}
}
