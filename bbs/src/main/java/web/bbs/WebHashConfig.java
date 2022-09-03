package web.bbs;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.metadata.HikariDataSourcePoolMetadata;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.zaxxer.hikari.HikariDataSource;

import web.bbs.intercepter.LoginInterceptor;
import web.bbs.intercepter.MemberDtoIntercepter;
import web.bbs.repository.member.MemberHashMapRepository;
import web.bbs.repository.member.MemberMySqlRepository;
import web.bbs.repository.member.MemberRepository;

@Configuration
public class WebHashConfig implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor())
		.order(1)
		.addPathPatterns("/**")
		.excludePathPatterns("/", "/home/login/form", "/home/logOut","/home/signUp/form"
				,"/css/**","/js/**","/*.ico","/error","//code/**");
		
		registry.addInterceptor(new MemberDtoIntercepter())
		.order(2)
		.addPathPatterns("/**")
		.excludePathPatterns("/","/home/login/form", "/home/logOut","/home/signUp/form",
				"/css/**","/js/**","/*.ico","/error","//code/**");
		
		
	}
	

	
	
			
	
}
