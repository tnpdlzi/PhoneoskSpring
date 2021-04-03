package com.donggun.phoneosk.service;

import com.donggun.phoneosk.domain.Menu;
import com.donggun.phoneosk.domain.Store;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class StoreServiceTest {

    @Autowired StoreService storeService;
    @Autowired StoreRepository storeRepository;

    @Test
    public void 가게목록() {
        //given
        Store store = Store.builder()
                .name("test")
                .address("address")
                .close(2200)
                .open(1000)
                .phone(1010001000)
                .build();
        storeService.add(store);

        //when
        List<Store> storeList = storeService.findStores();

        //then
        Assertions.assertThat(storeList.size()).isEqualTo(1);

    }
}
