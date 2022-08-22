package web.bbs.service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import web.bbs.domain.Member;
import web.bbs.domain.SessionConst;
import web.bbs.repository.member.MemberRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class LoginService {
	
	private final MemberRepository memberRepository;
	
	public boolean loginProcess(HttpServletRequest request, HttpServletResponse response, Member member) {
		Member findedMember = memberRepository.findById(member.getId());
		if( findedMember.getId() == null)		{
			return false;  
		}
		if(findedMember.getPassword() == null) {
			return false;
		}
		
		Member passedMember = memberRepository.findByLoginId(findedMember.getUserId()).filter(x->x.getPassword().equals(member.getPassword())).orElse(null);		
		HttpSession session = request.getSession(true);
		session.setAttribute(SessionConst.Login_session, passedMember);		
		return true;
		
	}
}