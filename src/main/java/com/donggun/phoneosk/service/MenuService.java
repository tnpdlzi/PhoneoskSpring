package com.donggun.phoneosk.service;

import com.donggun.phoneosk.domain.Menu;
import com.donggun.phoneosk.domain.Store;
import com.donggun.phoneosk.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    @Transactional
    public Long add(Menu menu) {
        validateDuplicateMember(menu);
        menuRepository.add(menu);
        return menu.getMenuId();
    }

    private void validateDuplicateMember(Menu menu) {
        List<Menu> findMenus = menuRepository.findByName(menu.getMenuName());
        if (!findMenus.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 메뉴입니다.");
        }
    }

    public List<Menu> findMenusByStore(Store store) {
        return menuRepository.findByStore(store);
    }

    public Menu findOne(Long menuId) {
        return menuRepository.findOne(menuId);
    }

}
