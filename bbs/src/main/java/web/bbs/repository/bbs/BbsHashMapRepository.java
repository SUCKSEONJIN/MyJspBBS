package web.bbs.repository.bbs;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import web.bbs.domain.BbsData;
import web.bbs.domain.BbsData_update;

@Slf4j
//@Repository
public class BbsHashMapRepository implements BbsRepository {

	private final Map<Long, BbsData> repository = new ConcurrentHashMap<>();
	private static Long sequence = 0L;
	
	@Override
	public Long save(BbsData data) {
		if(data.getAuthor() == null) {
			return null;
		}
		data.setId(++sequence);
		data.setTime(createTime());
		repository.put(data.getId(), data);
		log.info("repository : {}",repository.get(data.getId()));
		return data.getId();
	}

	@Override
	public Optional<BbsData> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Long id) {		
		repository.remove(id);
		
	}

	@Override
	public List<BbsData> searchByTitle(String title) {
		List<BbsData> list = new ArrayList<>();
		for(Long id : repository.keySet()) {
			BbsData element = repository.get(id);
			if(element.getTitle().contains(title)) {
				list.add(element);
			}
		}
		return list;

	}

	@Override
	public void update(Long id, BbsData_update bbsData) {
		BbsData findedBbsData = repository.get(id);
		if(bbsData.getText()!= null) {
			findedBbsData.setText(bbsData.getText());			
		}
	
			
	}
	
	@Override
	public List<BbsData> findAll(BbsData bbsData){
		
		return null;
	}
	
	
	public List<BbsData> findAll(){
		return new ArrayList<>(repository.values());
	}
	
	public String createTime() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		String date = formatter.format(now);
		log.info("date : {}", date);
		
		return date;
		
	}

	@Override
	public void updateViews(Long id, Integer views) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
