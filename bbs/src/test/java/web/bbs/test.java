package web.bbs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class test {
	@Test
	public void String_contains() {
		String parentString = "I like a apple";
		String subString1 = "like";
		String subString2 = "I like";
		String subString3 = "I like a apple";
		String subString4 = "I like a banana";
		
		assertTrue(parentString.contains(subString1));
		assertTrue(parentString.contains(subString2));
		assertTrue(parentString.contains(subString3));
		assertFalse(parentString.contains(subString4));
	}
	
	@Test
	public void Time() {
		Date now = new Date();
		System.out.println("now :" + now );
		//now :Thu Aug 18 17:02:45 KST 2022

		ZonedDateTime now1 = ZonedDateTime.now();
		System.out.println("zonedDateTime : " + now1);
		//zonedDateTime : 2022-08-18T17:02:45.147856100+09:00[Asia/Seoul]
		
		LocalDateTime now3 = LocalDateTime.now();		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'hh:mm:ss");
		String date = formatter.format(now3);
		LocalDateTime s = LocalDateTime.parse(date);
		System.out.println("date1 : " + date);
		System.out.println("date2 : " + date);
		
		
		
		
	}
	
	@Test
	public void createTime_Test() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		String date = formatter.format(now);
		log.info("date : {}", date);
		assertTrue(date.getClass()==String.class);
		
		
	}
	@Test
	public void stringValue() {
		String str = "/home/login/form?redirectURL=/bbs/bbs";
		
		int index = str.indexOf("=");
		String result = str.substring(index+1);
		assertThat(result).isEqualTo("/bbs/bbs");
	}
}
