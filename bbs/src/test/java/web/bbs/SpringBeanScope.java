package web.bbs;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




public class SpringBeanScope {

	private static final String NAME = "John Smith";
	
	@Test
	public void givenSingletonScope_whenSetName_thenEqualNames() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("scopes.xml");
		
		Person personSingletonA = (Person) applicationContext.getBean("personSingleton");
		Person personSingletonB = (Person) applicationContext.getBean("personSingleton");
		
		personSingletonA.setName(NAME);
		assertEquals(NAME, personSingletonB.getName());
		
		((AbstractApplicationContext) applicationContext).close();
		
	}
	
	
	

}


@Getter @Setter
@NoArgsConstructor 
class Person{
	
	private String name;
	
	@Bean
	//@Scope("singleton")
	@Scope(value=ConfigurableBeanFactory.SCOPE_SINGLETON)
	public Person personSingleton() {
		return new Person();
	}
	
}


