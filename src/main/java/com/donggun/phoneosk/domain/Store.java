package com.donggun.phoneosk.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Store {

    @GeneratedValue @Id
    @Column(name = "store_id")
    private int storeId;

    private String name;
    private String address;
    private int phone;
    private int open;
    private int close;

    @Builder
    public Store(String name, String address, int phone, int open, int close) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.open = open;
        this.close = close;
    }
}
