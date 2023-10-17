package connection.platforms.ConnectionPlatforms.table;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "connections_manager")
public class PlatformTable {
	@Id
	private String id;
	
	@Field("connectionId_manager")
	private String connectionId;
	
	@Field("connectionUser")
	private String userkey;
	private String loggedIntoComputer;
	
	@Field("connectionComputer")
	private String computerkey;
	private String user;
	
	@Field("unresolvedConnections")
	private String compId;
	private String connectId;
	
	
	// Constructor
	
	public PlatformTable(String id, String connectionId, String userkey, String loggedIntoComputer, String computerkey,
			String user, String compId, String connectId) {
		super();
		this.id = id;
		this.connectionId = connectionId;
		this.userkey = userkey;
		this.loggedIntoComputer = loggedIntoComputer;
		this.computerkey = computerkey;
		this.user = user;
		this.compId = compId;
		this.connectId = connectId;
	}
	
	// Setters
	
	public void setId(String id) {
		this.id = id;
	}
	public void setConnectionId(String connectionId) {
		this.connectionId = connectionId;
	}
	public void setUserkey(String userkey) {
		this.userkey = userkey;
	}
	public void setLoggedIntoComputer(String loggedIntoComputer) {
		this.loggedIntoComputer = loggedIntoComputer;
	}
	public void setComputerkey(String computerkey) {
		this.computerkey = computerkey;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public void setCompId(String compId) {
		this.compId = compId;
	}
	public void setConnectId(String connectId) {
		this.connectId = connectId;
	}

	
}
