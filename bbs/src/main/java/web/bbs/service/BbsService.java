package web.bbs.service;


import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import web.bbs.domain.BbsData;
import web.bbs.domain.Member;
import web.bbs.repository.bbs.BbsRepository;
import web.bbs.repository.member.MemberRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class BbsService {	
	private final MemberRepository memberRepository;
	private final BbsRepository BbsRepository;
	
	public List<BbsData> BbsView() {
		return BbsRepository.findAll();	
	}	
	
	public void bbsSave(BbsData data, HttpServletRequest request) {
		Long dataId = BbsRepository.save(data);		
		Optional<BbsData> bbsData_o = BbsRepository.findById(dataId);
		BbsData bbsData = bbsData_o.orElse(null);
		if(bbsData != null) {
			bbsData.getId();
			Member member = (Member)request.getAttribute("member");
			member.getBbsDataId().add(dataId);
		}
		

	}
	
	
	
}
