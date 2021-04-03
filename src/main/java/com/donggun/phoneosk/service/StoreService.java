package com.donggun.phoneosk.service;

import com.donggun.phoneosk.domain.Store;
import com.donggun.phoneosk.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    @Transactional
    public Long add(Store store) {
        validateDuplicateStore(store);
        storeRepository.add(store);
        return store.getStoreId();
    }

    private void validateDuplicateStore(Store store) {
        List<Store> findStores = storeRepository.findByName(store.getName());
        if (!findStores.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 가게입니다.");
        }
    }

    public List<Store> findStores() {
        return storeRepository.findAll();
    }

    public Store findOne(Long storeId) {
        return storeRepository.findOne(storeId);
    }

    public List<Store> findStoreByName(String name) {
        return storeRepository.findByName(name);
    }

}
