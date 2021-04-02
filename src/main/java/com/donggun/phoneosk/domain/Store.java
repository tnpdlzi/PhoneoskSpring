package com.donggun.phoneosk.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Store {

    @GeneratedValue @Id
    @Column(name = "store_id")
    private int storeId;

    private String name;
    private String address;
    private int phone;
    private int open;
    private int close;

}
