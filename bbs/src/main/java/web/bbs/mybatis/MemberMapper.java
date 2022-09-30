package web.bbs.mybatis;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import web.bbs.domain.Member;
import web.bbs.domain.MemberUpdateDTO;

@Mapper
public interface MemberMapper {
	
	
	void save(Member member);
	void update(@Param("id") Long id, @Param("updateParam")  MemberUpdateDTO updateParam);
	
	Optional<Member> findById(Long id);
	
	List<Member> findAll();
	
	Optional<Member> findByLoginId(String userId);
	
	void clear(Long id);
	
	void clearAll();
	
	
	
	
	
}
