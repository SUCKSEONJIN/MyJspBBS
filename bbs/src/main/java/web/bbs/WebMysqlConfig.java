package web.bbs;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.metadata.HikariDataSourcePoolMetadata;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.zaxxer.hikari.HikariDataSource;

import lombok.RequiredArgsConstructor;
import web.bbs.intercepter.LoginInterceptor;
import web.bbs.intercepter.MemberDtoIntercepter;
import web.bbs.repository.bbs.BbsMysqlRepository;
import web.bbs.repository.bbs.BbsRepository;
import web.bbs.repository.member.MemberMySqlRepository;
import web.bbs.repository.member.MemberRepository;

@Configuration
public class WebMysqlConfig implements WebMvcConfigurer{

	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor())
		.order(1)
		.addPathPatterns("/**")
		.excludePathPatterns("/", "/home/login/form", "/home/logOut","/home/signUp/**"
				,"/css/**","/js/**","/*.ico","/error","//code/**","/test/**");
		
		registry.addInterceptor(new MemberDtoIntercepter())
		.order(2)
		.addPathPatterns("/**")
		.excludePathPatterns("/","/home/login/form", "/home/logOut","/home/signUp/**",
				"/css/**","/js/**","/*.ico","/error","//code/**","/test/**");
		
		
	}
	
	@Bean
	public MemberRepository memberRepository() throws ClassNotFoundException {
		MemberMySqlRepository memberRepository = new MemberMySqlRepository(dataSource());		
		return memberRepository;
		
	}
	
	@Bean
	public DataSource dataSource() throws ClassNotFoundException {
		HikariDataSource dataSource = new HikariDataSource();
		//getClass().forName("com.mysql.cj.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mybbs");
		dataSource.setUsername("root");
		dataSource.setPassword("wlq4220**");
		dataSource.setMaximumPoolSize(10);
		dataSource.setPoolName("dataPool");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return dataSource;
	}
			
	@Bean
	public BbsRepository bbsRepository() throws ClassNotFoundException {
		
		BbsMysqlRepository bbsRepository = new BbsMysqlRepository(dataSource());
		return bbsRepository;
				
	}
	
}
