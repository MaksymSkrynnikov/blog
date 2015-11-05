package com.fancy.blog.service.impl;

import com.fancy.blog.models.entity.Blog;
import com.fancy.blog.models.vo.AuthorVO;
import com.fancy.blog.models.vo.BlogVO;
import com.fancy.blog.models.vo.CommentVO;
import com.fancy.blog.service.AuthorService;
import com.fancy.blog.service.BlogService;
import com.fancy.blog.service.BusinessService;
import com.fancy.blog.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * blog
 * Skrynnikov.M
 * 05.11.15  14:51
 */
@Service
@Transactional
public class BusinessServiceImpl implements BusinessService {

  @Autowired
  private BlogService blogService;

  @Autowired
  private AuthorService authorService;

  @Override
  public BlogVO getBlog(String blogUuid) {
    return Util.getBlogVO(blogService.getBlog(blogUuid));
  }

  @Override
  public List<BlogVO> getAllBlogs() {
    List<Blog> blogs = blogService.getAllBlogs();
    return Util.getBlogVOList(blogs);
  }

  @Override
  public void addComment(String blogUuid, CommentVO comment) {
    System.out.println(blogUuid);
    Blog blog = blogService.getBlog(blogUuid);
    blog.addComment(Util.getComment(comment));
    blogService.updateBlog(blog);
  }

  @Override
  public List<AuthorVO> getAllAuthors() {
    return Util.getAuthorVOList(authorService.getAllAuthors());
  }

  @Override
  public AuthorVO getAuthor(String authorUuid) {
    return Util.getAuthorVO(authorService.getAuthorByUuid(authorUuid));
  }
}
