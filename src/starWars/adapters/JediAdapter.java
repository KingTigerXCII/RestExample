package starWars.adapters;

import com.mongodb.DBObject;
import com.mongodb.util.JSON;

import starWars.models.Jedi;

public class JediAdapter {
	public static final DBObject toDbObject(Jedi jedi) {
		return (DBObject) JSON.parse(jedi.toString());
	}
}
