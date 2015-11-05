package com.fancy.blog.dao;

import com.fancy.blog.models.entity.Author;

import java.util.List;

/**
 * blog
 * Skrynnikov.M
 * 04.11.15  10:28
 */
public interface AuthorDao {

  List<Author> getAllAuthors();

  void addNewAuthor(Author author);

  Author getAuthorByUuid(String authorUuid);

  Author getAuthorByLogin(String authorLogin);

  void updateAuthor(Author author);
}
