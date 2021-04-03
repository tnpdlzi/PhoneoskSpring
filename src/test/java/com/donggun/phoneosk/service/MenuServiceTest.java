package com.donggun.phoneosk.service;

import com.donggun.phoneosk.domain.Store;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class MenuServiceTest {

    @Autowired MenuService menuService;
    @Autowired MenuRepository menuRepository;
    @Autowired StoreService storeService;

    @Test
    public void 메뉴목록() {
        //given
        Store store = new Store();
        storeService.add(store);

        //when

        //then

    }
}
