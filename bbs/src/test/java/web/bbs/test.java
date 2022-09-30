package web.bbs;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.web.util.UriUtils;

import static org.hamcrest.Matchers.containsString;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.internal.Utils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequiredArgsConstructor
public class test {
	
	//private final TestMybatisRespositoroy repository;
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
	
	@Test
	public void whenSerializingUsingJsonAnyGetter_thenCorrect()
	throws JsonProcessingException{
		ExtendableBean bean = new ExtendableBean("My bean");
		bean.add("attr1", "val1");
		bean.add("attr2", "val2");
		
		
		String result = new ObjectMapper().writeValueAsString(bean);
		log.info("result = {}", result);
		assertThat(result, containsString("attr1"));
		assertThat(result,containsString("val1"));
		
	}
	
	@Test
	public void WhenDeserializingUsingJsonCreator_thenCorrect() throws IOException{			
		String json = "{\"id\":1,\"theName\":\"My bean\"}";		
		BeanWithCreator bean = new ObjectMapper().readerFor(BeanWithCreator.class).readValue(json);
		assertEquals("My bean", bean.name);					
	}
	
	@Test
	public void whenDeserializingUsingJsonAnySetter_thenCorrect() throws IOException {
		String json = "{\"name\":\"My bean\",\"attr\":\"val1\"}";
		ExtendableBean bean = new ObjectMapper().readerFor(ExtendableBean.class).readValue(json);
		
		assertEquals("My bean", bean.name);
	}

	@Test
	public void unserializingJsonToJava() {
		String json = "{\"name\":\"My bean\",\"attr\":\"val1\"}";
		ExtendableBean java = new ExtendableBean();
		java.add("name", "My bean");
		java.add("attr", "val1");
		java.getProperties();
		
		log.info("결과 괍 : {} ", java.getProperties());
		
	}
	@Test
	public void mapInfo() {
		Map<String, String> map = new HashMap<>();
		map.put("name", "My bean");
		log.info("결과 값2 : {}", map);
	}
	
	@Test
	public void listNumber() {
		List<Integer> list = new ArrayList<>();
		int a = 0;
		while(a< 10) {
			list.add(a);
			++a;
		}
		
		int size = list.size();
		int lastIndexOfValue = list.lastIndexOf(0);
		int lastIndexOfValue1 = list.get(size-1);
		
		System.out.println(list.get(9));
		assertThat(size).isEqualTo(10);
		
	}
	
	
	
	@Test
	public void numberParsing() {
		int num = 23;		
		String nums = String.valueOf(num);
		int lastIndex = nums.length()-1;
		
		char c1 = nums.charAt(0);
		char c2 = nums.charAt(1);			
		int parsToInt = Integer.parseInt(String.valueOf(c2));
		System.out.println("parsToInt ="+ parsToInt);
		
		int num1 = 12323214;
		
		
		// 스트링에서 특정 숫자 추출 방법.
		String num1s = String.valueOf(num1);
		int size = num1s.length();
		int result1 = Integer.parseInt(String.valueOf(num1s.charAt(size-1)));
		// 일의 값 4가 나올꺼라 예상한다.
		
		assertThat(result1).isEqualTo(4);
		
		
	}
	
	@Test
	public void utilsTest() {
		
		String[] hello = {"dis", "sdfs","sdf"};
		String va = "\u005a";
		
		String charset = "charset";
		String query = "query";
		String uri = UriUtils.encodeQuery(query, Charset.forName("UTF-8"));
		assertThat(uri).isEqualTo("");
	}
	
	
	
	@Test
	public void exampleTabel() {
		
//		String hoho = "123";
//		text.setDocs(hoho);
//		System.out.println("text.docs = " + text.getDocs());
//		//repository.save(text.getDocs()); 
	}
	
	
}



