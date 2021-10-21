package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MemberDao;
import com.example.demo.persistence.Member;
import com.example.demo.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao memberDao;
	
	@Override
	@PostConstruct
	public ResponseEntity<List<Member>> selectAll() {
		
		List<Member> list = memberDao.findAll();
		
		return new ResponseEntity<List<Member>>(list, HttpStatus.OK);
		
//		return new ResponseEntity<List<Member>>(new ArrayList<>(), HttpStatus.OK);
	}

}
