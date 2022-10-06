package web.bbs.mybatis;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import web.bbs.domain.BbsData;
import web.bbs.domain.BbsData_update;

@Mapper
public interface BbsMybatisMapper {
	
	public Long save(BbsData data);
	public void remove(Long id);
	public List<BbsData> searchByTitle(String title);
	public List<BbsData> searchByAuthor(String author);
	public void update(@Param("id")Long id,@Param("bbsData") BbsData_update bbsData);
	public List<BbsData> findAll(BbsData bbsData);
	public Optional<BbsData> findById(Long id);
	void updateViews(@Param("id") Long id,@Param("views")Integer views );
}
