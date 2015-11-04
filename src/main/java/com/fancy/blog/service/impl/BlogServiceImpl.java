package com.fancy.blog.service.impl;

import com.fancy.blog.dao.BlogDao;
import com.fancy.blog.models.entity.Blog;
import com.fancy.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * blog
 * Skrynnikov.M
 * 04.11.15  10:46
 */
@Service
@Transactional
public class BlogServiceImpl implements BlogService {

  @Autowired
  private BlogDao blogDao;

  @Override
  public List<Blog> getAllBlogs() {
    return blogDao.getAllBlogs();
  }

  @Override
  public List<Blog> getBlogDescending(int limit) {
    return blogDao.getBlogDescending(limit);
  }

  @Override
  public Blog getBlog(String blogUuid) {
    return blogDao.getBlog(blogUuid);
  }

  @Override
  public void addNewBlog(Blog blog) {
    blogDao.addNewBlog(blog);
  }

  @Override
  public void updateBlog(Blog blog) {
    blogDao.updateBlog(blog);
  }
}
