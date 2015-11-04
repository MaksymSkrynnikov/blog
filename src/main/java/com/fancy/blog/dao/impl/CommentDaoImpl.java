package com.fancy.blog.dao.impl;

import com.fancy.blog.dao.CommentDao;
import com.fancy.blog.models.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * blog
 * Skrynnikov.M
 * 04.11.15  10:38
 */
@Repository
@Transactional
public class CommentDaoImpl implements CommentDao {

  @Autowired
  private EntityManager entityManager;

  @Override
  public void addComment(Comment comment) {
    entityManager.persist(comment);
  }
}
