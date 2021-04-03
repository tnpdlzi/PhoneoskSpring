package com.donggun.phoneosk.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Menu {

    @Id @GeneratedValue
    @Column(name = "menu_id")
    private Long menuId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @Column(name = "menu_name")
    private String menuName;

    private int price;

    @Builder
    public Menu(Store store, String menuName, int price) {
        this.store = store;
        this.menuName = menuName;
        this.price = price;
    }
}
