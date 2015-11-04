package com.fancy.blog.dao.impl;

import com.fancy.blog.dao.BlogDao;
import com.fancy.blog.models.entity.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * blog
 * Skrynnikov.M
 * 04.11.15  10:18
 */
@Repository
public class BlogDaoImpl implements BlogDao {

  @Autowired
  private EntityManager entityManager;

  @Override
  @SuppressWarnings("unchecked")
  public List<Blog> getAllBlogs() {
    Query query = entityManager.createQuery("SELECT b from " + Blog.class.getSimpleName() + " b");
    return query.getResultList();
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<Blog> getBlogDescending(int limit) {
    Query query = entityManager.createQuery("SELECT b from " + Blog.class.getSimpleName() + " b order by b.creationMoment desc");
    return query.getResultList();
  }

  @Override
  public Blog getBlog(String blogUuid) {
    return entityManager.find(Blog.class, blogUuid);
  }

  @Override
  public void addNewBlog(Blog blog) {
    entityManager.persist(blog);
  }

  @Override
  public void updateBlog(Blog blog) {
    entityManager.merge(blog);
  }
}
