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
	
	public List<BbsData> BbsView(BbsData bbsData) {
		return BbsRepository.findAll(bbsData);	
	}	
	
	public void bbsSave(BbsData data, HttpServletRequest request) {
		Long dataId = BbsRepository.save(data);		
		Optional<BbsData> bbsData_o = BbsRepository.findById(dataId);
		BbsData bbsData = bbsData_o.orElse(null);
		if(bbsData != null) {
			bbsData.getId();
			Member member = (Member)request.getAttribute("member");			
		}
		
	}	
	public List<BbsData> bbsDataSum() {
		List<BbsData> list = BbsRepository.findAll(new BbsData());
		int size = list.size();
		return list;
	}
		
	public int intOneValueExtract(int num) {
		String sNum = String.valueOf(num);
		char cNum = sNum.charAt(sNum.length()-1);			
		return Integer.parseInt(String.valueOf(cNum));
		
	}
	
}
