package com.fancy.blog.dao.impl;

import com.fancy.blog.dao.AuthorDao;
import com.fancy.blog.models.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * blog
 * Skrynnikov.M
 * 04.11.15  10:33
 */
@Repository
@Transactional
public class AuthorDaoImpl implements AuthorDao {

  @Autowired
  private EntityManager entityManager;

  @Override
  @SuppressWarnings("unchecked")
  public List<Author> getAllAuthors() {
    Query query = entityManager.createQuery("select a from " + Author.class.getSimpleName() + " a");
    return query.getResultList();
  }

  @Override
  public void addNewAuthor(Author author) {
    entityManager.persist(author);
  }

  @Override
  public Author getAuthorByUuid(String authorUuid) {
    return entityManager.find(Author.class, authorUuid);
  }

  @Override
  public Author getAuthorByLogin(String authorLogin) {
    Query query = entityManager.createQuery("select a from " + Author.class.getSimpleName() + " a where a.login = " + authorLogin);
    return (Author) query.getSingleResult();
  }

  @Override
  public void updateAuthor(Author author) {
    entityManager.merge(author);
  }
}
