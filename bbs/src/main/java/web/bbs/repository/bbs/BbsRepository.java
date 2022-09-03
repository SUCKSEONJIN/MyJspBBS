package web.bbs.repository.bbs;

import java.util.List;
import java.util.Optional;

import web.bbs.domain.BbsData;
import web.bbs.domain.BbsData_update;

public interface BbsRepository {
		
	public Long save(BbsData data);
	public void remove(Long id);
	public List<BbsData> searchByTitle(String title);	
	public BbsData update(Long id, BbsData_update bbsData);
	public List<BbsData> findAll();
	public Optional<BbsData> findById(Long id);

}
