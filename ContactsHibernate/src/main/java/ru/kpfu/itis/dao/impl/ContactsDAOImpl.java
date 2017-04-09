package ru.kpfu.itis.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.dao.ContactsDAO;
import ru.kpfu.itis.model.Contact;

import java.util.List;

@Repository
@Transactional
public class ContactsDAOImpl implements ContactsDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public List getALL() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Contact.class).list();
    }

    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Object contact = session.load(Contact.class, id);
        session.delete(contact);
    }

    public void add(Contact contact) {
        sessionFactory.getCurrentSession().save(contact);
    }

    public void edit(Contact contact) {
        Session session = sessionFactory.getCurrentSession();
        session.update(contact);
    }
}
