package com.donggun.phoneosk.repository;

import com.donggun.phoneosk.domain.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class StoreRepository {

    private final EntityManager em;

    public void add(Store store) {
        em.persist(store);
    }

    public Store findOne(Long id) {
        return em.find(Store.class, id);
    }

    public List<Store> findAll() {
        return em.createQuery("select s from Store s", Store.class)
                .getResultList();
    }

    public List<Store> findByName(String name) {
        return em.createQuery("select s from Store s where s.name = :name", Store.class)
                .setParameter("name", name)
                .getResultList();
    }

}
