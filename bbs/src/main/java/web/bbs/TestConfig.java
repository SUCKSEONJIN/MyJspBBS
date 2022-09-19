package web.bbs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.extern.slf4j.Slf4j;
import web.bbs.intercepter.FirstInterceptor;
import web.bbs.intercepter.SecondInterceptor;

@Slf4j
@Configuration
public class TestConfig implements WebMvcConfigurer{@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new FirstInterceptor())
		.order(1)
		.addPathPatterns("/test/first");
		
		registry.addInterceptor(new SecondInterceptor()).
		order(2).addPathPatterns("/test/first");
			
	}

	
}
