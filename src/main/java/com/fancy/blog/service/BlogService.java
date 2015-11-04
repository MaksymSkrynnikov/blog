package com.fancy.blog.service;

import com.fancy.blog.models.entity.Blog;

import java.util.List;

/**
 * blog
 * Skrynnikov.M
 * 04.11.15  10:40
 */
public interface BlogService {

  List<Blog> getAllBlogs();

  List<Blog> getBlogDescending(int limit);

  Blog getBlog(String blogUuid);

  void addNewBlog(Blog blog);

  void updateBlog(Blog blog);
}
