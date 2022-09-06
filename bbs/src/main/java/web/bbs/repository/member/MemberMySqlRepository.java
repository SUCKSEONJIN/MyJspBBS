package web.bbs.repository.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import web.bbs.domain.BbsData;
import web.bbs.domain.Member;
import web.bbs.domain.MemberUpdateDTO;

@Slf4j
@Controller
public class MemberMySqlRepository implements MemberRepository{

	private final NamedParameterJdbcTemplate template;
		
	public MemberMySqlRepository(DataSource dataSource) {
		this.template = new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Override
	public Member save(Member member)  {				
		String sql = "insert into members(name, email, password, age, userId)"
				+ "values(:name,:email,:password,:age,:userId)";
		SqlParameterSource param = new BeanPropertySqlParameterSource(member);
		KeyHolder keyHolder = new GeneratedKeyHolder();
		template.update(sql, param, keyHolder);
		long key = keyHolder.getKey().longValue();
		member.setId(key);				
		return member;

	}

	@Override
	public Optional<Member> findById(Long id) {		
		String sql = "select * from members where id = :id";
		
		try {
				Map<String, Object>param = Map.of("id", id);
				Member member = template.queryForObject(sql, param, beanRowMapper());				
				return Optional.of(member);
		}catch(EmptyResultDataAccessException e) {
			return Optional.empty();
		}
	}

	@Override
	public Optional<Member> findByLoginId(String LoginId) {		
		return findAll().stream().filter(m->m.getUserId().equals(LoginId)).findFirst();		
	}

	
	@Override
	public List<Member> findAll() {
		String sql = "select * from members";		
		List<Member> members = template.query(sql, beanRowMapper());
		return members;
	}

	@Override
	public void update(Long id, MemberUpdateDTO member) {
		String sql = "update members set email = :member , password= :password";
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("email", member.getEmail())
				.addValue("password", member.getPassword())
				.addValue("id",id);
		template.update(sql,param);
			
	}

	@Override
	public void clear(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearAll() {
		// TODO Auto-generated method stub
		
	}
	
	
	private RowMapper<Member> beanRowMapper() {
		return BeanPropertyRowMapper.newInstance(Member.class);
	}
	


}
