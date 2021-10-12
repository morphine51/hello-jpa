package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hellojpa.entity.Member;

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
			Member member = new Member();
			member.setId(100L);
			member.setName("안녕하세요");
			
			em.persist(member); // INSERT DB
			
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally {
			em.close();
		}
		emf.close();
		
	}
}
