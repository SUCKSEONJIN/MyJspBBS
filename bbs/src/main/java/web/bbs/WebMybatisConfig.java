package web.bbs;

import java.sql.Connection;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
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
import web.bbs.intercepter.NavInterceptor;
import web.bbs.mybatis.BbsMybatisMapper;
import web.bbs.mybatis.MemberMapper;
import web.bbs.repository.bbs.BbsMysqlRepository;
import web.bbs.repository.bbs.BbsRepository;
import web.bbs.repository.bbs.MybatisBbsRepository;
import web.bbs.repository.member.MemberMySqlRepository;
import web.bbs.repository.member.MemberRepository;
import web.bbs.repository.member.MyBatisMemberRepository;


@Configuration
public class WebMybatisConfig implements WebMvcConfigurer{

	@Autowired
	private MemberMapper memberMapper;	
	@Autowired
	private BbsMybatisMapper bbsMapper;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new NavInterceptor())
		.order(1)
		.addPathPatterns("/**")
		.excludePathPatterns("/css/**","/js/**","//code/**","/test/**","/img/**");
		
		registry.addInterceptor(new LoginInterceptor())
		.order(2)
		.addPathPatterns("/**")
		.excludePathPatterns("/", "/home/login/form", "/home/logOut","/home/signUp/form"
				,"/css/**","/js/**","/*.ico","/error","//code/**","/test/**","/img/**");
		
		registry.addInterceptor(new MemberDtoIntercepter())
		.order(3)
		.addPathPatterns("/**")
		.excludePathPatterns("/","/home/login/form", "/home/logOut","/home/signUp/**",
				"/css/**","/js/**","/*.ico","/error","//code/**","/test/**","/img/**");
		
		
	}
	
	@PostConstruct
	public MemberRepository memberRepository() throws ClassNotFoundException {				
		return new MyBatisMemberRepository( memberMapper);		
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
		
		BbsRepository bbsRepository = new MybatisBbsRepository(bbsMapper);
		return bbsRepository;
				
	}
	
}
