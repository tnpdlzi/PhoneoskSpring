package com.donggun.phoneosk.repository;

import com.donggun.phoneosk.domain.Menu;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MenuRepository {

    private final EntityManager em;

    public void add(Menu menu) {
        em.persist(menu);
    }

    public Menu findOne(Long id) {
        return em.find(Menu.class, id);
    }

    public List<Menu> findAll() {
        return em.createQuery("select m from Menu m", Menu.class) // 첫번째 JPQL, 두 번째 반환 타입
                .getResultList(); // 조회된 결과를 result로 반환
    }

    public List<Menu> findByName(String name) {
        return em.createQuery("select m from Menu m where m.menuName = :name", Menu.class)
                .setParameter("name", name)
                .getResultList();
    }

}
