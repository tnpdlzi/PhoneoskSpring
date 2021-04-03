package com.donggun.phoneosk.repository;

import com.donggun.phoneosk.domain.Menu;
import com.donggun.phoneosk.domain.Store;
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

    public List<Menu> findByName(String name) {
        return em.createQuery("select m from Menu m where m.menuName = :name", Menu.class)
                .setParameter("name", name)
                .getResultList();
    }

    public List<Menu> findByStore(Store store) {
        return em.createQuery("select m from Menu m where m.store = :store", Menu.class)
                .setParameter("store", store)
                .getResultList();
    }

}
