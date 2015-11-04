package com.fancy.blog.dao;

import com.fancy.blog.models.entity.Blog;

import java.util.List;

/**
 * blog
 * Skrynnikov.M
 * 04.11.15  10:18
 */
public interface BlogDao {

  List<Blog> getAllBlogs();

  List<Blog> getBlogDescending(int limit);

  Blog getBlog(String blogUuid);

  void addNewBlog(Blog blog);

  void updateBlog(Blog blog);
}
