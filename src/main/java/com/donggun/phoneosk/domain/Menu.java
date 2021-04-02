package com.donggun.phoneosk.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Menu {

    @Id @GeneratedValue
    @Column(name = "menu_id")
    private Long menuId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    private String menuName;
    private int price;
}
