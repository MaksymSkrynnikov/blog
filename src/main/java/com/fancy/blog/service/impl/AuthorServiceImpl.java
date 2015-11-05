package com.fancy.blog.service.impl;

import com.fancy.blog.dao.AuthorDao;
import com.fancy.blog.models.entity.Author;
import com.fancy.blog.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * blog
 * Skrynnikov.M
 * 05.11.15  15:46
 */
@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

  @Autowired
  private AuthorDao authorDao;

  @Override
  public List<Author> getAllAuthors() {
    return authorDao.getAllAuthors();
  }

  @Override
  public Author getAuthorByUuid(String authorUuid) {
    return authorDao.getAuthorByUuid(authorUuid);
  }

  @Override
  public Author getAuthorByLogin(String login) {
    return authorDao.getAuthorByLogin(login);
  }

  @Override
  public void addNewAuthor(Author author) {
    authorDao.addNewAuthor(author);
  }
}
