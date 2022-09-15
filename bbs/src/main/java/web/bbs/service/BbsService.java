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
import web.bbs.domain.BbsData_update;
import web.bbs.domain.Member;
import web.bbs.repository.bbs.BbsRepository;
import web.bbs.repository.member.MemberRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class BbsService {	
	private final MemberRepository memberRepository;
	private final BbsRepository bbsRepository;
	
	public List<BbsData> bbsView(BbsData bbsData) {
		return bbsRepository.findAll(bbsData);	
	}	
	
	public BbsData bbsDataView(Long bbsDataId) {		
		Optional<BbsData> bbsData = bbsRepository.findById(bbsDataId);		
		return bbsData.orElse(null); 
	}
	
	public void bbsSave(BbsData data, HttpServletRequest request) {
		Long dataId = bbsRepository.save(data);		
		Optional<BbsData> bbsData_o = bbsRepository.findById(dataId);
		BbsData bbsData = bbsData_o.orElse(null);
		if(bbsData != null) {
			bbsData.getId();
			Member member = (Member)request.getAttribute("member");			
		}
		
	}	
	
	public void bbsDataModify(Long bbsDataId , BbsData_update bbsUpdate) {			
		bbsRepository.update(bbsDataId, bbsUpdate);
		
	}
	public List<BbsData> bbsDataSum() {
		List<BbsData> list = bbsRepository.findAll(new BbsData());
		int size = list.size();
		return list;
	}
		
	public int intOneValueExtract(int num) {
		String sNum = String.valueOf(num);
		char cNum = sNum.charAt(sNum.length()-1);			
		return Integer.parseInt(String.valueOf(cNum));
		
	}
	
}
