package web.bbs;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SetTest {

	
	@Test
	public void whenAddingElement_shouldAddElement() {
		Set<String> hashset = new HashSet();
		assertTrue(hashset.add("String Added"));
		
	}
	
	
	public void whenModifyingHashSetWhileIterating_shouldThrowException() {
		Set<String> hashSet = new HashSet<>();
		hashSet.add("first");
		hashSet.add("second");
		hashSet.add("third");
		Iterator<String> itr = hashSet.iterator();
		while(itr.hasNext())
		{
			itr.next();
			hashSet.remove("second");
		}
		
	}
}
