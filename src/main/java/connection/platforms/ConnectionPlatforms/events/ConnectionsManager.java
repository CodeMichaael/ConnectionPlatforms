package connection.platforms.ConnectionPlatforms.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import connection.platforms.ConnectionPlatforms.repository.PlatformRepo;
import connection.platforms.ConnectionPlatforms.table.PlatformTable;

@RestController
@RequestMapping("/connections")
public class ConnectionsManager {
	
	@Autowired
	private PlatformRepo repo;
	private PlatformTable table;
	
	@PostMapping("/connect/{connectionId}")
	public String connectToId(@RequestParam String connectionId, @RequestBody String user, String compId) {
		
		// Confidential
		
		return null;
	}
	

	}

