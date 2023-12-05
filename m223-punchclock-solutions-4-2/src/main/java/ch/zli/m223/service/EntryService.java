package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Entry;

@ApplicationScoped
public class EntryService {
    @Inject
    EntityManager entityManager;

    @Transactional
    public Entry createEntry(Entry entry) {
        return entityManager.merge(entry);
    }

    @Transactional
    public void deleteEntry(Long id) {
        var entity = entityManager.find(Entry.class, id);
        entityManager.remove(entity);
    }

    @Transactional
    public Entry updateEntry(Long id, Entry entry) {
        entry.setId(id);
        return entityManager.merge(entry);
    }

    public List<Entry> findAll() {
        var query = entityManager.createQuery("FROM Entry", Entry.class);
        return query.getResultList();
    }
}
