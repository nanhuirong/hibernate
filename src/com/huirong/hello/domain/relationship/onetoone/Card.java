package com.huirong.hello.domain.relationship.onetoone;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by huirong on 17-5-14.
 */
public class Card implements Serializable{
    private static final long serialVersionUID = 2137654095558528939L;
    private Long id;
    private Date date;
    private Person person;

    public Card() {
    }

    public Card(Date date, Person person) {
        this.date = date;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
