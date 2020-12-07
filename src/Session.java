import java.time.LocalDateTime;

public class Session {
	private LocalDateTime sessionDateCreated;
	
	public Session() {
		this.sessionDateCreated = LocalDateTime.now();
	}

	public LocalDateTime getSessionDateCreated() {
		return sessionDateCreated;
	}

	public void setSessionDateCreated(LocalDateTime sessionDateCreated) {
		this.sessionDateCreated = sessionDateCreated;
	}
	
	
}
