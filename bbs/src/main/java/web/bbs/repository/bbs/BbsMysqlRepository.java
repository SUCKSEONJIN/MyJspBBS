package web.bbs.repository.bbs;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import web.bbs.domain.BbsData;
import web.bbs.domain.BbsData_update;

@Primary
@Slf4j
@Repository
public class BbsMysqlRepository implements BbsRepository{

	private final NamedParameterJdbcTemplate template;
	
	
	public BbsMysqlRepository(NamedParameterJdbcTemplate template) {
		this.template = template;
	}
	
	public RowMapper<BbsData> bbsRowMapper(){
		return new BeanPropertyRowMapper<BbsData>().newInstance(BbsData.class);
	}
	
	@Override
	public Long save(BbsData data) {		
		String sql = "insert into bbs(title, text, author, time, good) "
				+ "value(:title, :text, :author, :time, :good)";
				
		KeyHolder keyHolder = new GeneratedKeyHolder(); 
		template.update(sql, (SqlParameterSource) bbsRowMapper(),keyHolder);
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
	public List<BbsData> findAll() {
		// TODO Auto-generated method stub
		return null;
	}



	
}
