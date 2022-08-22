package web.bbs;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;

public class OptionalPratice {
	@Test
	public void whenCreateEmptyOptional_thenCorrect() {
		Optional<String> empty = Optional.empty();
		assertFalse(empty.isPresent());
	}
	
	@Test
	public void givenNonNull_whenCreateNonNullable_thenCorrect() {
		String name = "bealdung";
		Optional<String> opt = Optional.of(name);
		assertTrue(opt.isPresent());
	}
	
	@Test
	public void givenNull_whenThrowsErrorOnCreate_thenCorrect() {
		String name=null;
		Optional.of(name); //NullPointerException 발생
	}
	
	@Test
	public void givenNull_WhenCreateNullable_thenCorrect() {
		String name = null;
		Optional<String>opt = Optional.ofNullable(name);
		assertFalse(opt.isPresent()); // Object 반환
	}
	
	//Checking Value Presence: isPresent() and is Empty()
	@Test
	public void givenOptional_whenIsPresentWorks_thenCorect() {
		Optional<String> opt = Optional.of("Bealdung");
		assertTrue(opt.isPresent());
		
		opt = Optional.ofNullable(null);
		assertFalse(opt.isPresent());		
	}
	
	@Test
	public void givenAnEmptyOptional_thenIsEmptyBehavesAsExpected() {
		Optional<String> opt = Optional.of("Bealdung");
		assertFalse(opt.isEmpty());
		
		opt = Optional.ofNullable(null);
		assertTrue(opt.isEmpty()); 
	}
	
	
	
	
	

}
