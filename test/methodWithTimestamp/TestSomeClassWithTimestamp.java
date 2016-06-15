package methodWithTimestamp;

import static org.junit.Assert.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;

public class TestSomeClassWithTimestamp {
	Date date = new Date();
	Timestamp timestampWithOldDate = new Timestamp(date.getTime());
	ClassWithTimestamp useOldDate = new ClassWithTimestamp();

	LocalDateTime specificDateAndTime = LocalDateTime.now();
	Timestamp timestampWithStaticTime = Timestamp.valueOf(specificDateAndTime);
	ClassWithTimestamp useNewDate = new ClassWithTimestamp();

	@Before
	public void setUp() {
		useOldDate.setCreateDate(timestampWithOldDate);
		useNewDate.setCreateDate(timestampWithStaticTime);
	}

	@Test
	public void testWithOldDate() {
		assertEquals(timestampWithOldDate, useOldDate.getCreateDate());
	}

	@Test
	public void testWithNewLocalDateTime() {
		System.out.println(useNewDate.getCreateDate());
		assertEquals(timestampWithStaticTime, useNewDate.getCreateDate());
	}
}
