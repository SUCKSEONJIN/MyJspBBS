package web.bbs.repository.member;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Controller;

import web.bbs.domain.Member;
import web.bbs.domain.MemberUpdateDTO;


@Controller
public class MemberHashMapRepository implements MemberRepository{
	
	private final Map<Long, Member> repository = new ConcurrentHashMap();
	private final static MemberHashMapRepository store = new MemberHashMapRepository();
	private static Long sequence = 0L;
	
	private MemberHashMapRepository() {
		
	}
	
	public static MemberHashMapRepository getInstance() {
		return store;
	}
	
	@Override
	public Member save(Member member) {
		member.setId(++sequence);	
		repository.put(member.getId(), member);
		return member;
	}

	@Override
	public Optional<Member> findById(Long id) {		
		return Optional.of(repository.get(id));
	}

	@Override
	public List<Member> findAll() {
		return new ArrayList<>(repository.values());
	}

	@Override
	public void update(Long id, MemberUpdateDTO member) {
		Member findedMember = repository.get(id);		
	
		if(member.getEmail() != null) {
			findedMember.setEmail(member.getEmail());
		}
		
		if(member.getPassword() != null) {
			findedMember.setPassword(member.getPassword());
		}
		
				
	}

	@Override
	public void clear(Long id) {
		repository.remove(id);
		
	}
	
	

	@Override
	public Optional<Member> findByLoginId(String LoginId) {
		return findAll().stream().filter(m->m.getUserId().equals(LoginId)).findFirst();
	}


	@Override
	public void clearAll() {
		repository.clear();
		
	}

	
}
