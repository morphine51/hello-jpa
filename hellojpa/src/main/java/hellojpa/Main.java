package hellojpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hellojpa.entity.Member;
import hellojpa.entity.Team;

/**
 * @description run with jdk8
 * @author leehaebin
 */

public class Main {
	public static void main(String[] args) {
		
		// hello 라는 것은 persistence.xml에 있는 persistence-unit의 name
		// EntityManager를 생산하는 공장.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		
		// Transaction이 일어날때마다 EntityManager를 사용해야한다.
		// EntityManager는 쓰레드간에 공유하면 안된다.(쓰고 바로 버리는것이 원칙)
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			
			// 팀 저장
			Team team = new Team();
			team.setName("teamA");
			em.persist(team);
			
			Member member = new Member(); 
			member.setName("안녕하세요");
			member.setTeam(team);
			em.persist(member); // INSERT DB
			
			em.flush();
			em.clear();
			
			tx.commit();
			
			/////
			
			Member findMember = em.find(Member.class, member.getId());
			Team findTeam = findMember.getTeam();
			
			List<Member> members = findTeam.getMembers();
			for(Member record : members) {
				System.out.println(record.getName());
			}
			
			
			
			
		}catch(Exception e){
			tx.rollback();
		}finally {
			em.close();
		}
		emf.close();
		
	}
}
