package ru.kpfu.itis.service;

import ru.kpfu.itis.model.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> getALL();

    void delete(Long id);

    void add(Contact contact);

    void edit(Contact contact);
}
