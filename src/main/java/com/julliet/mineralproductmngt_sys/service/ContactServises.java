package com.julliet.mineralproductmngt_sys.service;

import com.julliet.mineralproductmngt_sys.model.Contact;

import java.util.List;

public interface ContactServises {
    public Contact saveContact(Contact contact);
    public List<Contact> getAllContact();
    public void deleteContact(String email);
}
