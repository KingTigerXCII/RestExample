package starWars.constants;

public enum DbCollectionNames {
	JEDI("jedi"),
	SITH("sith");
	
	private final String dbCollectionName;
	
	private DbCollectionNames(String dbCollectionName) {
		this.dbCollectionName = dbCollectionName;
	}
	
	@Override
	public String toString() {
		return dbCollectionName;
	}
}
