package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.model.Contact;
import ru.kpfu.itis.dao.ContactsDAO;
import ru.kpfu.itis.service.ContactService;

import java.util.List;

@Transactional
@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactsDAO contactsDAO;

    public List<Contact> getALL() {
        return contactsDAO.getALL();
    }

    public void delete(Long id) {
        contactsDAO.delete(id);
    }

    public void add(Contact contact) {
        contactsDAO.add(contact);
    }

    public void edit(Contact contact) {
        contactsDAO.edit(contact);
    }
}
