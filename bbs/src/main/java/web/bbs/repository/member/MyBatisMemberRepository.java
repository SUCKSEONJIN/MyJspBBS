package web.bbs.repository.member;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import web.bbs.domain.Member;
import web.bbs.domain.MemberUpdateDTO;
import web.bbs.mybatis.MemberMapper;

@Primary
@Repository
@RequiredArgsConstructor

public class MyBatisMemberRepository implements MemberRepository{
	private final MemberMapper memberMapper;
	
	public Member save(Member member) {
		memberMapper.save(member);
		return findById(member.getId()).orElse(null);		
	}

	@Override
	public Optional<Member> findById(Long id) {
			return memberMapper.findById(id);
	}

	@Override
	public Optional<Member> findByLoginId(String id) {		
		return memberMapper.findByLoginId(id); 
	}

	@Override
	public List<Member> findAll() {		
		return memberMapper.findAll();
	}

	@Override
	public void update(Long id, MemberUpdateDTO member) {
		memberMapper.update(id, member);
		
	}

	@Override
	public void clear(Long id) {
		memberMapper.clear(id);
		
	}

	@Override
	public void clearAll() {
		memberMapper.clearAll();				
	}
	
	
}
