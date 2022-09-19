package web.bbs.mybatis;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import web.bbs.domain.BbsData;
import web.bbs.domain.BbsData_update;

@Mapper
public interface BbsMybatisMapper {
	
	public Long save(BbsData data);
	public void remove(Long id);
	public List<BbsData> searchByTitle(String title);
	public void update(Long id, BbsData_update bbsData);
	public List<BbsData> findAll(BbsData bbsData);
	public Optional<BbsData> findById(Long id);
}
