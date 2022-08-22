package web.bbs.repository.member;

import java.util.List;
import java.util.Optional;

import web.bbs.domain.Member;


public interface MemberRepository {
	public Member save(Member member);
	public Member findById(Long id);	
	public Optional<Member> findByLoginId(String id);
	public List<Member> findAll();
	public Member update(Long id, Member member);
	public void clear(Long id);	
	public void clearAll();
}
