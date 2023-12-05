package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Category;

@ApplicationScoped
public class CategoryService {
    @Inject
    EntityManager entityManager;

    @Transactional
    public Category createCategory(Category category) {
        return entityManager.merge(category);
    }

    @Transactional
    public void deleteCategory(Long id) {
        var entity = entityManager.find(Category.class, id);
        entityManager.remove(entity);
    }

    @Transactional
    public Category updateCategory(Long id, Category category) {
        category.setId(id);
        return entityManager.merge(category);
    }

    public List<Category> findAll() {
        var query = entityManager.createQuery("FROM Category", Category.class);
        return query.getResultList();
    }
}