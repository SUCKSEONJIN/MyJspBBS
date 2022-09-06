package web.bbs.repository.member;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

import web.bbs.domain.Member;
import web.bbs.domain.MemberUpdateDTO;


public interface MemberRepository {
	public Member save(Member member);
	public Optional<Member> findById(Long id);	
	public Optional<Member> findByLoginId(String id);
	public List<Member> findAll();
	public void update(Long id, MemberUpdateDTO member);
	public void clear(Long id);	
	public void clearAll();
}
