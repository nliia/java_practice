package ru.kpfu.itis.dao;

import ru.kpfu.itis.model.Contact;

import java.util.List;

public interface ContactsDAO {

    List<Contact> getALL();

    void delete(Long id);

    void add(Contact contact);

    void edit(Contact contact);

}
