package web.bbs.repository.member;

import java.util.List;

import web.bbs.domain.Member;


public interface MemberRepository {
	public Member save(Member member);
	public Member findById(Long id);
	public Member findByName(String name);
	public List<Member> findAll();
	public Member update(Long id, Member member);
	public void clear(Long id);
	public void clear(String name);
	public void clearAll();
}
