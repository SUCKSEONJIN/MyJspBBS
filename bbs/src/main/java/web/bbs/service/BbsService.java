package web.bbs.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import web.bbs.domain.BbsData;
import web.bbs.repository.bbs.BbsRepository;
import web.bbs.repository.member.MemberRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class BbsService {	
	private final MemberRepository memberRepository;
	private final BbsRepository BbsRepository;
	public void bbsSave(BbsData bbsData) {
		BbsRepository.save(bbsData);
		
	}
	
	public List<BbsData> BbsView() {
		return BbsRepository.findAll();	
	}	
	
	
	
	
	
}
