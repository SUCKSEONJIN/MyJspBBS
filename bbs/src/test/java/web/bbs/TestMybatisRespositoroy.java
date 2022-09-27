package web.bbs;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonAlias;

@Repository
public interface TestMybatisRespositoroy {
	
	@Insert(value = "insert into example(docs) values(#{docs}) ")
	public void save(@JsonAlias String docs);
}
