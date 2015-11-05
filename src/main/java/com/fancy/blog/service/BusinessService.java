package com.fancy.blog.service;

import com.fancy.blog.models.vo.AuthorVO;
import com.fancy.blog.models.vo.BlogVO;
import com.fancy.blog.models.vo.CommentVO;

import java.util.List;

/**
 * blog
 * Skrynnikov.M
 * 05.11.15  14:46
 */
public interface BusinessService {

  BlogVO getBlog(String blogUuid);

  List<BlogVO> getAllBlogs();

  void addComment(String blogUuid, CommentVO comment);

  List<AuthorVO> getAllAuthors();

  AuthorVO getAuthor(String authorUuid);
}
