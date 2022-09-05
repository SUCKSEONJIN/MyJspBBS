package web.bbs.service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import web.bbs.domain.Member;
import web.bbs.domain.MemberLoginDTO;
import web.bbs.domain.SessionConst;
import web.bbs.repository.member.MemberRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class LoginService {
	
	private final MemberRepository memberRepository;
	
	public Member loginProcess(HttpServletRequest request, HttpServletResponse response, MemberLoginDTO memberDto) {		
		Member passedMember = memberRepository.findByLoginId(memberDto.getUserId()).filter(x->x.getPassword().equals(memberDto.getPassword())).orElse(null);		
		if(passedMember == null) {
			return passedMember;
		}
		HttpSession session = request.getSession(true);			
		session.setAttribute(SessionConst.Login_session, passedMember);		
		return passedMember;
		
	}
}