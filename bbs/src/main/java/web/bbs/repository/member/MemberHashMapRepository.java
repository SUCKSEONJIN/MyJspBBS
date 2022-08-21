package web.bbs.repository.member;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Controller;

import web.bbs.domain.Member;


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
	public Member findById(Long id) {		
		return repository.get(id);
	}

	@Override
	public Member findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> findAll() {
		return new ArrayList<>(repository.values());
	}

	@Override
	public Member update(Long id, Member member) {
		Member findedMember = repository.get(id);		
		if(member.getName() != null) {
			findedMember.setName(member.getName());
		}
		if(member.getAge() != 0) {
			findedMember.setAge(member.getAge());
		}
		
		if(member.getEmail() != null) {
			findedMember.setEmail(member.getEmail());
		}
		
		if(member.getPassword() != null) {
			findedMember.setPassword(member.getPassword());
		}
		
		return member;		
	}

	@Override
	public void clear(Long id) {
		repository.remove(id);
		
	}

	@Override
	public void clear(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearAll() {
		repository.clear();
		
	}

	
}
