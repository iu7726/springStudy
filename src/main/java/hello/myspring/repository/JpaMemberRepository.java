package hello.myspring.repository;

import hello.myspring.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {

        return em.createQuery("SELECT m From Member AS m WHERE m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList()
                .stream()
                .findAny();

    }

    @Override
    public List<Member> findAll() {
        //객체를 기반으로 테이블을 조회합니다.
        return em.createQuery("SELECT m FROM Member AS m", Member.class).getResultList();
    }
}
