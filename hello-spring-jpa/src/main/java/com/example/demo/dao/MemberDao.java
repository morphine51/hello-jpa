package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.persistence.Member;

@Repository
public interface MemberDao extends JpaRepository<Member, Long>{
	
}
