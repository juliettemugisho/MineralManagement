package com.julliet.mineralproductmngt_sys.service;

import com.julliet.mineralproductmngt_sys.model.Contact;
import com.julliet.mineralproductmngt_sys.repository.ContactorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContactServiceImp  implements ContactServises{
    private final ContactorRepository contactorRepository;

    public ContactServiceImp(ContactorRepository contactorRepository) {
        this.contactorRepository = contactorRepository;
    }

    @Override
    public Contact saveContact(Contact contact) {
        return contactorRepository.save(contact);
    }

    @Override
    public List<Contact> getAllContact() {
        return contactorRepository.findAll();
    }

    @Override
    public void deleteContact(String email) {
        contactorRepository.deleteById(email);
    }
}
