package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.MemberDao;
import com.example.demo.persistence.Member;
import com.example.demo.service.MemberService;

@RestController
public class HelloController {

	@Autowired
	MemberService memberService;
	
	@RequestMapping(name="/select")
	public ResponseEntity<Member> selectAll(){
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
