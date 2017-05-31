package com.huirong.hello.domain.relationship.onetoone;

import java.io.Serializable;

/**
 * Created by huirong on 17-5-14.
 */
public class Person implements Serializable{
    private static final long serialVersionUID = -8825623520303368849L;
    private Long id;
    private String name;
    private Card card;

    public Person() {
    }

    public Person(String name, Card card) {
        this.name = name;
        this.card = card;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
