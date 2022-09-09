
package web.bbs.repository.bbs;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;


import org.springframework.context.annotation.Primary;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;
import web.bbs.domain.BbsData;
import web.bbs.domain.BbsDataCond;
import web.bbs.domain.BbsData_update;

@Primary
@Slf4j
@Repository
public class BbsMysqlRepository implements BbsRepository{

	private final NamedParameterJdbcTemplate template;
	
	
	public BbsMysqlRepository(DataSource dataSource){
		this.template = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public RowMapper<BbsData> bbsRowMapper(){
		return BeanPropertyRowMapper.newInstance(BbsData.class);
	}
	
	@Override
	public Long save(BbsData data) {		
		String sql = "insert into bbs(title, text, author, time) "
				+ "values(:title, :text, :author, :time)";
				
		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource param = new BeanPropertySqlParameterSource(data);  
		template.update(sql,param,keyHolder);
		Number key = keyHolder.getKey();
		data.setId(key.longValue());	
		return data.getId();
	}
		
	@Override
	public Optional<BbsData> findById(Long id) {
		String sql = "select * from bbs where id = :id";
		try {
		Map<String, Object> param = Map.of("id",id);
		BbsData bbsData = template.queryForObject(sql, param,bbsRowMapper());
		return Optional.of(bbsData);}
		catch(EmptyResultDataAccessException e) {
			return Optional.empty();
		}
		
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BbsData> searchByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BbsData update(Long id, BbsData_update bbsData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BbsData> findAll(BbsData bbsData) {		
		String sql = "select * from bbs";
		SqlParameterSource param = new BeanPropertySqlParameterSource(bbsData);
		
		if(StringUtils.hasText(bbsData.getAuthor())== false && StringUtils.hasText(bbsData.getTitle())== false) {
			return template.query(sql,param,bbsRowMapper());
		}else {
			sql += " where";
			boolean andFlag = false;
			if(StringUtils.hasText(bbsData.getTitle())== true) {
				sql+= "title LIKE CONCAT('%',:title,'%')";
				andFlag = true;
			}
			if(StringUtils.hasText(bbsData.getAuthor()) && andFlag == true) {
				sql+=" and";
			}
			if(StringUtils.hasText(bbsData.getAuthor())==true) {
				sql+=" author LIKE CONCAT('%',:author,'%')";
			}
			
			return template.query(sql, param,bbsRowMapper());
			
		}
			
		
		
		
		
				
	}
	
	



	
}
