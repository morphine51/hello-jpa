package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.persistence.Member;

public interface MemberService {

	public ResponseEntity<List<Member>> selectAll();
	
}
