package hellojpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import hellojpa.type.MemberType;

@Entity
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "USERNAME", nullable = false) // DB의 mapping될 컬럼명
	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TEAM_ID")
	private Team team;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
	

	/*
	private Integer age;

	// 현업에서는 꼭 EnumType.STRING 을 써야함
	// EnumType.ORDINAL을 쓸 경우 Enum이 소스에 작성된 순서대로 0,1,2 ... 으로 자동으로 순서를 매겨버림
	@Enumerated(EnumType.STRING) 
	private MemberType memberType;
	
	// 잠시 임시로만 가지고있을용도. DB하고 매칭하지 않음.
	@Transient
	private String aaa;
	
	@Lob
	@Column(name = "CLOB")
	private char[] clob; // char인 경우 clob
	
	@Lob
	@Column(name = "BLOB")
	private byte[] blob; // byte인 경우 blob
	*/
	
	

}
