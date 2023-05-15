package com.julliet.mineralproductmngt_sys.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Minerals {
    @Id
    private Long order_id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date order_dob;
    private String mineral_type;
    private String customer_name;
    private String customer_email;
    private String customer_phone;
    private String customer_picture;

    public Minerals() {
    }

    public Minerals(Long order_id, String mineral_type, String customer_name, String customer_email, String customer_phone, String customer_picture, Date order_dob) {
        this.order_id = order_id;
        this.mineral_type = mineral_type;
        this.customer_name = customer_name;
        this.customer_email = customer_email;
        this.customer_phone = customer_phone;
        this.customer_picture = customer_picture;
        this.order_dob = order_dob;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public String getMineral_type() {
        return mineral_type;
    }

    public void setMineral_type(String mineral_type) {
        this.mineral_type = mineral_type;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public String getCustomer_picture() {
        return customer_picture;
    }

    public void setCustomer_picture(String customer_picture) {
        this.customer_picture = customer_picture;
    }

    public Date getOrder_dob() {
        return order_dob;
    }

    public void setOrder_dob(Date order_dob) {
        this.order_dob = order_dob;
    }
}
