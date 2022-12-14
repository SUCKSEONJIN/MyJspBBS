package web.bbs.repository.bbs;

import java.util.List;
import java.util.Optional;

import web.bbs.domain.BbsData;
import web.bbs.domain.BbsDataCond;
import web.bbs.domain.BbsData_update;

public interface BbsRepository {
		
	public Long save(BbsData data);
	public void remove(Long id);
	public List<BbsData> searchByTitle(String title);	
	public List<BbsData> searchByAuthor(String author);
	public void update(Long id, BbsData_update bbsData);
	public List<BbsData> findAll(BbsData bbsData);
	public Optional<BbsData> findById(Long id);
	
	
	public void updateViews(Long id, Integer views);
	
}
