package methodWithTimestamp;

import java.sql.Timestamp;
import java.util.Date;

public class ClassWithTimestamp {
	Timestamp timestamp;
	
	public void setCreateDate(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public Timestamp getCreateDate() {
		return timestamp;
	}
}
