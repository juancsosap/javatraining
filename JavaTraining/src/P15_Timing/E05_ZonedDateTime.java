package P15_Timing;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class E05_ZonedDateTime {

	public static void main(String[] args) {
		
		ZonedDateTime zonedDateTime = ZonedDateTime.now();
				
		System.out.println(zonedDateTime);
		System.out.println(zonedDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
		
		ZonedDateTime otherZonedDateTime = ZonedDateTime.now(ZoneId.of("America/Lima"));
		
		System.out.println(otherZonedDateTime);
		
		ZoneOffset offset = ZoneOffset.of("-04:00");
		
		OffsetDateTime offsetDateTime = OffsetDateTime.of(LocalDateTime.now(), offset);
		
		System.out.println(offsetDateTime);
	}

}
