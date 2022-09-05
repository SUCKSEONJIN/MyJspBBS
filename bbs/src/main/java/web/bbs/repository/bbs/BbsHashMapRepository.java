package web.bbs.repository.bbs;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import web.bbs.domain.BbsData;
import web.bbs.domain.BbsData_update;

@Slf4j
@Repository
public class BbsHashMapRepository implements BbsRepository {

	private final Map<Long, BbsData> repository = new ConcurrentHashMap<>();
	private static Long sequence = 0L;
	
	@Override
	public void save(BbsData data) {
		if(data.getAuthor() == null) {
			return;
		}
		data.setId(++sequence);
		data.setTime(createTime());
		repository.put(data.getId(), data);
		log.info("repository : {}",repository.get(data.getId()));
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
	public BbsData update(Long id, BbsData_update bbsData) {
		BbsData findedBbsData = repository.get(id);
		if(bbsData.getAuthor() != null) {
			findedBbsData.setAuthor(bbsData.getAuthor());
		}
		if(bbsData.getText()!= null) {
			findedBbsData.setText(bbsData.getText());			
		}
		if(bbsData.getTime() != null) {
			findedBbsData.setTime(createTime());
		}
		
		return findedBbsData;
	}
	
	@Override
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
	
	
}
