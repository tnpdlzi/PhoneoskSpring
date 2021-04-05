package com.donggun.phoneosk.service;

import com.donggun.phoneosk.domain.Menu;
import com.donggun.phoneosk.domain.Store;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class MenuServiceTest {

    @Autowired MenuService menuService;
    @Autowired StoreService storeService;

    @Test
    public void 메뉴추가() {
        //given
        Store store = Store.builder()
                .name("test2")
                .address("address2")
                .close(2200)
                .open(1000)
                .phone(1010001000)
                .build();
        storeService.add(store);

        Menu menu = Menu.builder()
                .menuName("test menu")
                .store(store)
                .price(10000)
                .build();

        //when
        Long id = menuService.add(menu);
        Menu findMenu = menuService.findOne(id);

        //then
        Assertions.assertThat(findMenu).isSameAs(menu);

    }

    @Test
    public void 메뉴목록() {
        //given
        Store store = Store.builder()
                .name("test")
                .address("address")
                .close(2200)
                .open(1000)
                .phone(1010001000)
                .build();
        storeService.add(store);

        Menu menu = Menu.builder()
                .menuName("test menu")
                .store(store)
                .price(10000)
                .build();
        menuService.add(menu);

        //when
        List<Menu> menuList = menuService.findMenusByStore(store);

        //then
        Assertions.assertThat(menuList.size()).isEqualTo(1);

    }
}
