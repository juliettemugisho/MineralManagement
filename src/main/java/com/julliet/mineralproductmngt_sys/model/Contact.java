package com.julliet.mineralproductmngt_sys.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Contact {

    private String names;
    @Id
    private String email;
    private String comment;

    public Contact() {
    }

    public Contact(String names, String email, String comment) {
        this.names = names;
        this.email = email;
        this.comment = comment;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
