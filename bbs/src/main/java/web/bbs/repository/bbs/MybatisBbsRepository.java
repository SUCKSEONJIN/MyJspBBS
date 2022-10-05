package web.bbs.repository.bbs;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import web.bbs.domain.BbsData;
import web.bbs.domain.BbsData_update;
import web.bbs.mybatis.BbsMybatisMapper;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MybatisBbsRepository implements BbsRepository{

	private final BbsMybatisMapper mapper;
	
	@Override
	public Long save(BbsData data) {
		return mapper.save(data);
		
	}

	@Override
	public void remove(Long id) {
		mapper.remove(id);
		log.info("마이바티스 제거");
		
	}

	@Override
	public List<BbsData> searchByTitle(String title) {		
		return mapper.searchByTitle(title);
	}

	@Override
	public void update(Long id, BbsData_update bbsData) {
		mapper.update(id, bbsData);
		
	}

	@Override
	public List<BbsData> findAll(BbsData bbsData) {
		return mapper.findAll(bbsData);		
	}

	@Override
	public Optional<BbsData> findById(Long id) {
		return mapper.findById(id);
		
	}
	
	public void updateViews(Long id , Integer views) {
		mapper.updateViews(id, views);
	}
	

}
