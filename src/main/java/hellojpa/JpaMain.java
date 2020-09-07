package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        try {
            // 저장
//            Member member = new Member();
//            member.setId(1L);
//            member.setName("helloA");
//            em.persist(member);

            //조회
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.Id = " + findMember.getId());
//            System.out.println("findMember.Name = " + findMember.getName());

            //삭제
//            Member findMember = em.find(Member.class, 1L);
//            em.remove(findMember);

            //수정
//            Member findMember = em.find(Member.class, 2L);
//            findMember.setName("helloB");
            // 신기하게도 jpa는 데이터 수정을 마치 자바 컬렉션 다루듯이 만들어진다.

//            List<Member> resultList = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(1)
//                    .setMaxResults(10)
//                    .getResultList();
//
//            for (Member m : resultList) {
//                System.out.println("member.name = " + m.getName());
//            }

            //비영속
            Member member = new Member();
            member.setId(100L);
            member.setName("helloJPA");

            //영속 (DB에 직접 저장되는 단계가 아니다.)
            System.out.println("BEFORE");
            em.persist(member);
            System.out.println("AFTER");

            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
